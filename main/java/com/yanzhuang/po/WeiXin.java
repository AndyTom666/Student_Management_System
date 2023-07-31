package com.yanzhuang.po;

public class WeiXin 
{
	private String FromUserName;
	private String ToUserName;
	private String CreateTime;
	private String MsgType;
	private String Event;
	private String Latitude;
	private String Longitude;
	private String Precision;
	private String Content;
	private String MsgId;
	private String MediaId;
	private String PicUrl;
	//private String Content;
	public WeiXin()
	{
		
	}
	public String getFromUserName() {
		return FromUserName;
	}
	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}
	public String getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(String createTime) {
		CreateTime = createTime;
	}
	public String getMsgType() {
		return MsgType;
	}
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
	public String getEvent() {
		return Event;
	}
	public void setEvent(String event) {
		Event = event;
	}
	public String getLatitude() {
		return Latitude;
	}
	public void setLatitude(String latitude) {
		Latitude = latitude;
	}
	public String getLongitude() {
		return Longitude;
	}
	public void setLongitude(String longitude) {
		Longitude = longitude;
	}
	public String getPrecision() {
		return Precision;
	}
	public void setPrecision(String precision) {
		Precision = precision;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public String getMsgId() {
		return MsgId;
	}
	public void setMsgId(String msgId) {
		MsgId = msgId;
	}
	public String getToUserName() {
		return ToUserName;
	}
	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}
	public String getMediaId() {
		return MediaId;
	}
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
	public String getPicUrl() {
		return PicUrl;
	}
	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}
	@Override
	public String toString() {
		return "WeiXin [FromUserName=" + FromUserName + ", CreateTime=" + CreateTime + ", MsgType=" + MsgType
				+ ", Event=" + Event + ", Latitude=" + Latitude + ", Longitude=" + Longitude + ", Precision="
				+ Precision + ", Content=" + Content + ", MsgId=" + MsgId + "]";
	}
	
}
