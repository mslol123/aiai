package com.jxky.bgxs.httpApiDemo;

import java.net.URLEncoder;
import java.util.Random;

import com.google.gson.Gson;
import com.jxky.bgxs.httpApiDemo.common.Config;
import com.jxky.bgxs.httpApiDemo.common.HttpUtil;
import com.jxky.bgxs.httpJson.JsonEntity;

/**
 * 验证码通知短信接口
 * 
 * @ClassName: IndustrySMS
 * @Description: 验证码通知短信接口
 *
 */
public class IndustrySMS
{
	private static String operation = "/industrySMS/sendSMS";
	/**
	 * 随机生成6位验证码
	 */
	static String safetyResult="";
	static{
		Random random = new Random();
		for (int i=0;i<6;i++)
		{
			safetyResult+=random.nextInt(10);
		}
	}
	private static String accountSid = Config.ACCOUNT_SID;
	private static String smsContent = "【嘉信科盈科技】您的验证码为"+safetyResult+"，请于2分钟内正确输入，如非本人操作，请忽略此短信。";

	/**
	 * 验证码通知短信
	 */
	public static String execute(String to)
	{
		String tmpSmsContent = null;
	    try{
	      tmpSmsContent = URLEncoder.encode(smsContent, "UTF-8");
	    }catch(Exception e){
	      
	    }
	    String url = Config.BASE_URL + operation;
	    String body = "accountSid=" + accountSid + "&to=" + to + "&smsContent=" + tmpSmsContent
	        + HttpUtil.createCommonParam();

	    // 提交请求
	    String result = HttpUtil.post(url, body);
	    System.out.println("result:" + System.lineSeparator() + result);
	    System.out.println("******************************************");
	    JsonEntity gson = new Gson().fromJson(result, JsonEntity.class);
	    System.out.println(gson.getRespCode());
	    System.out.println(gson.getRespDesc());
	    System.out.println(gson.getFailCount());
	    System.out.println(gson.getFailList());
	    System.out.println(gson.getSmsId());
	    System.out.println("*****************-------------***************");
	    if(gson.getRespCode().equals("00000")){
	    	System.out.println("验证码已发送成功");
	    	System.out.println("验证码为"+safetyResult);
	    }
	    return safetyResult;
	}
}
