package com.jxky.bgxs.controller.wjt;

import com.alibaba.fastjson.JSON;
import com.jxky.bgxs.entity.Indent;
import com.jxky.bgxs.entity.LoginResult;
import com.jxky.bgxs.entity.PayResult;
import com.jxky.bgxs.service.zq.IndentService;
import com.jxky.bgxs.util.PayCommonUtil;
import com.jxky.bgxs.util.PayConfigUtil;
import com.jxky.bgxs.util.XmlUtil;
import com.jxky.bgxs.util.ZxingUtil;
import io.goeasy.GoEasy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;

@Controller
@RequestMapping("/pay")
@SessionAttributes(value = {"oid","image"})
public class WXPayController {

    @Resource
    private IndentService indentService;

    @RequestMapping("/weiXin")
    public String weiXin(){
        return "/pay";
    }
    @GetMapping("/payTest")
    public String payTest(String price,String body,String number, Model model){
        String priceString = price.replace(".", "");
        Indent indent = new Indent();
        indent.setNumber(number);
        indent.setState("已支付");
        indentService.updateState(indent);
        Random random = new Random();
        try {
            body = new String(body.getBytes("ISO8859-1"), "UTF-8");
            String orderId = random.nextInt(100000000) + "";
            String url = PayCommonUtil.weixin_pay(priceString, body, orderId);
            BufferedImage image = ZxingUtil.createImage(url, 300, 300);
            System.out.println(image);
            model.addAttribute("oid",orderId);
            model.addAttribute("image",image);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/payment";
    }
    @RequestMapping("/image")
    public void image(@SessionAttribute(value = "image") BufferedImage image, HttpServletResponse resp){
        if (image != null) {
            try {
                ImageIO.write(image, "JPEG", resp.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @RequestMapping("/result")
    public void result(HttpServletRequest request, HttpServletResponse response){
        GoEasy goEasy = new GoEasy("BC-9f6395b045e94368a90769a9cb3549c9");
        try {
            PayResult payResult = weixin_notify(request, response);
            String jsonString = JSON.toJSONString(payResult);
            goEasy.publish("WXpay",jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public PayResult weixin_notify(HttpServletRequest request,HttpServletResponse response) throws Exception{
        LoginResult result = new LoginResult();
        PayResult payResult = new PayResult();
        String writeContent="默认支付失败";
        String path = request.getServletContext().getRealPath("file");
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(path+"/result.txt", true);
        InputStream inputStream ;
        StringBuffer sb = new StringBuffer();
        inputStream = request.getInputStream();
        String s ;
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
        while ((s = in.readLine()) != null){
            sb.append(s);
        }
        in.close();
        inputStream.close();
        Map<String, String> m = new HashMap<String, String>();
        m = XmlUtil.doXMLParse(sb.toString());
        SortedMap<Object,Object> packageParams = new TreeMap<Object,Object>();
        Iterator it = m.keySet().iterator();
        while (it.hasNext()) {
            String parameter = (String) it.next();
            String parameterValue = m.get(parameter);
            String v = "";
            if(null != parameterValue) {
                v = parameterValue.trim();
            }
            packageParams.put(parameter, v);
        }
        String key = PayConfigUtil.API_KEY;
        System.err.println(packageParams);
        String out_trade_no = (String)packageParams.get("out_trade_no");
        if(PayCommonUtil.isTenpaySign("UTF-8", packageParams,key)){
            String resXml = "";
            if("SUCCESS".equals((String)packageParams.get("result_code"))){
                String mch_id = (String)packageParams.get("mch_id");
                String openid = (String)packageParams.get("openid");
                String is_subscribe = (String)packageParams.get("is_subscribe");
                String total_fee = (String)packageParams.get("total_fee");
                System.err.println("mch_id:"+mch_id);
                System.err.println("openid:"+openid);
                System.err.println("is_subscribe:"+is_subscribe);
                System.err.println("out_trade_no:"+out_trade_no);
                System.err.println("total_fee:"+total_fee);
                System.err.println("支付成功");
                writeContent = "订单:" + out_trade_no + "支付成功";
                System.err.println(writeContent);
                resXml = "<xml>" + "<return_code><![CDATA[SUCCESS]]></return_code>"+ "<return_msg><![CDATA[OK]]></return_msg>" + "</xml> ";
                result.setCode(0);
                result.setMsg("订单"+out_trade_no+"支付成功");
                BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
                out.write(resXml.getBytes());
                out.flush();
                out.close();
                fileOutputStream.write(writeContent.getBytes());
                fileOutputStream.close();
            }else {
                writeContent = "订单"+out_trade_no+"支付失败，错误信息" +packageParams.get("err_code");
                System.err.println("订单"+out_trade_no+"支付失败，错误信息" +packageParams.get("err_code"));
                resXml = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>"+ "<return_msg><![CDATA[报文为空]]></return_msg>" + "</xml>";
                result.setCode(1);
                result.setMsg("订单"+out_trade_no+"支付失败，错误信息");
                BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
                out.write(resXml.getBytes());
                out.flush();
                out.close();
                fileOutputStream.write(writeContent.getBytes());
                fileOutputStream.close();
            }
        }else {
            writeContent = "订单"+out_trade_no+"通知签名验证失败，支付失败";
            System.err.println("通知签名验证失败");
            fileOutputStream.write(writeContent.getBytes());
            fileOutputStream.close();
            result.setCode(2);
            result.setMsg("订单"+out_trade_no+"支付失败，通知签名验证失败");
        }
        payResult.setTel(out_trade_no);
        payResult.setResult(result);
        return payResult;
    }
}
