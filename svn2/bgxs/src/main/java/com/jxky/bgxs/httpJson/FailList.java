package com.jxky.bgxs.httpJson;

public class FailList {

	//必选    请求状态码，取值00000（成功： 此步响应只表明客户的短信请求发送成功，不表明短信通道已经发送短信成功。） 具体可参照
	private String respCode;
	//可选	对返回状态码的描述 如：00000 代表成功
	private String respDesc;
	//电话
	private String phone;
	public String getRespCode() {
		return respCode;
	}
	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}
	public String getRespDesc() {
		return respDesc;
	}
	public void setRespDesc(String respDesc) {
		this.respDesc = respDesc;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "FailList [respCode=" + respCode + ", respDesc=" + respDesc + ", phone=" + phone + "]";
	}
	
	
}
