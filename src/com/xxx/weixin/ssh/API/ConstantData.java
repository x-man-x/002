package com.xxx.weixin.ssh.API;

public class ConstantData {
	 public final static String APPID="wxa8476ad109c11e44";
	 public final static String SECRET="fec22adf272b9a9046c8aebf63e486d5";
	 public final static String get_code_url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";
	 public final static String get_access_token        = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
	 public final static String val_access_token_url = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=APPID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN";
	 public final static String get_userinfo_url	 = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN"; 
	 public final static String get_ticket_url	 = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?type=jsapi&access_token=ACCESS_TOKEN";
	 public final static String get_access_token_web ="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=SECRET";





}
