package com.xxx.weixin.ssh.Action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import com.opensymphony.xwork2.ActionSupport;
import com.xxx.weixin.ssh.API.ConstantData;
import com.xxx.weixin.ssh.API.WxGetToken;
import com.xxx.weixin.ssh.API.WxGetUserinfo;
import com.xxx.weixin.ssh.DAO.UserDAO;
import com.xxx.weixin.ssh.DAO.WxUserInfoDAO;
import com.xxx.weixin.ssh.Model.Token;
import com.xxx.weixin.ssh.Model.User;
import com.xxx.weixin.ssh.Model.WxUserInfo;
import com.xxx.weixin.ssh.util.CommonUtil;
import com.xxx.weixin.ssh.util.HttpRequest;

public class ShareAction extends BaseAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String,Object> dataMap;  
    
    public Map<String, Object> getDataMap() {  
        return dataMap;  
    }  
    
    public String execute() throws Exception {
    	
//    	 timestamp=objData.timestamp; 
//    	 noncestr=objData.noncestr; 
//    	 signature=objData.signature;
    	//获取签名随即字符串
        String noncestr = getRandomString(15);
        //获取签名时间戳
        String timestamp = Long.toString(System.currentTimeMillis());
        //请求accessToken
        String signature ="";
        String RootPath =request.getSession().getServletContext().getRealPath("/");
        
    	System.out.println(RootPath);
        String tokenStr=WxGetToken.readWebToken(RootPath);
        System.out.println(tokenStr);
        if(tokenStr==null || tokenStr.equals("")){
        	System.out.println("t----1");
        	signature=WxGetToken.getTicket(WxGetToken.getWebToken(ConstantData.APPID, ConstantData.SECRET,RootPath));
        	System.out.println("t----11"+signature);
        }else{
        	System.out.println("t----2");
        	signature=WxGetToken.getTicket(tokenStr);
        	System.out.println("t----21"+signature);
        	
      }
        dataMap = new HashMap<String, Object>();  
        dataMap.put("noncestr", noncestr);  
        dataMap.put("timestamp", timestamp);
        dataMap.put("signature", signature);
        
        dataMap.put("success", true);  
        
        // 返回结果  
    	return SUCCESS;
    	
    }
    
    


 public String getRandomString(int length) {
 String base = "abcdefghijklmnopqrstuvwxyz0123456789"; 
 Random random = new Random(); 
 StringBuffer sb = new StringBuffer(); 
 for (int i = 0; i < length; i++) { 
  int number = random.nextInt(base.length()); 
  sb.append(base.charAt(number)); 
 } 
 return sb.toString(); 
 }
 
 
    
}
