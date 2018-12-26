package com.jxky.bgxs.httpJson;

import java.util.Arrays;

public class JsonEntity {
	//必选    请求状态码，取值00000（成功： 此步响应只表明客户的短信请求发送成功，不表明短信通道已经发送短信成功。） 具体可参照
	private String respCode;
	//可选	对返回状态码的描述 如：00000 代表成功
	private String respDesc;
	//必选	表示验证码通知短信发送失败的条数。
	private String failCount;
	//可选	失败列表，包含失败号码、失败原因。
	private FailList failList[];
	//必选	短信标识符。一个由32个字符组成的短信唯一标识符。
	private String smsId;
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
	public String getFailCount() {
		return failCount;
	}
	public void setFailCount(String failCount) {
		this.failCount = failCount;
	}
	public String getSmsId() {
		return smsId;
	}
	public void setSmsId(String smsId) {
		this.smsId = smsId;
	}
	public FailList[] getFailList() {
		return failList;
	}
	public void setFailList(FailList[] failList) {
		this.failList = failList;
	}
	@Override
	public String toString() {
		return "JsonEntity [respCode=" + respCode + ", respDesc=" + respDesc + ", failCount=" + failCount
				+ ", failList=" + Arrays.toString(failList) + ", smsId=" + smsId + "]";
	}
	
}
