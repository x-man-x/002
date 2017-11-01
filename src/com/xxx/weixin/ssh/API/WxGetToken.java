package com.xxx.weixin.ssh.API;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import com.xxx.weixin.ssh.Model.Token;
import com.xxx.weixin.ssh.Util.CommonUtil;
import com.xxx.weixin.ssh.Util.HttpRequest;

public class WxGetToken {
	 private static Logger log = LoggerFactory.getLogger(CommonUtil.class);
    /**
     * 获取接口访问凭证
     * 
     * @param appid 凭证
     * @param appsecret 密钥
     * @return
     * @throws IOException 
     * @throws UnsupportedEncodingException 
     */
    public static Token getToken(String appid, String appsecret,String code,String path) throws UnsupportedEncodingException, IOException {
        Token token = null;
        String requestUrl = ConstantData.get_access_token.replace("APPID", appid).replace("SECRET", appsecret).replace("CODE", code);
        // 发起GET请求获取凭证
        JSONObject jsonObject = HttpRequest.httpsRequest(requestUrl, "GET", null);

        if (null != jsonObject) {
            try {
                token = new Token();
                token.setAccessToken(jsonObject.getString("access_token"));
                token.setExpiresIn(jsonObject.getInt("expires_in"));
                token.setRefresh_token(jsonObject.getString("refresh_token"));
                token.setOpenid(jsonObject.getString("openid"));
                token.setScope(jsonObject.getString("scope"));
                
                System.out.println(token.getAccessToken()+":"+token.getOpenid());
                writeToken(path,token.getAccessToken());
                
            } catch (JSONException e) {
                token = null;
                // 获取token失败
                log.error("获取token失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"), jsonObject.getString("errmsg"));
            }
        }
        return token;
    }
    
    public static String getWebToken(String appid, String appsecret,String path) throws UnsupportedEncodingException, IOException {
        String requestUrl = ConstantData.get_access_token_web.replace("APPID", appid).replace("SECRET", appsecret);
        // 发起GET请求获取凭证
        JSONObject jsonObject = HttpRequest.httpsRequest(requestUrl, "GET", null);
        String access_token="";
        if (null != jsonObject) {
            try {
            	access_token=jsonObject.getString("access_token");
                
                writeWebToken(path,access_token);
                
            } catch (JSONException e) {
               
                // 获取token失败
                log.error("获取token失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"), jsonObject.getString("errmsg"));
            }
        }
        return access_token;
    }
    
    
    
    public static boolean validateToken(String openid,String path) throws UnsupportedEncodingException, IOException {
    	//https://api.weixin.qq.com/sns/auth?access_token=ACCESS_TOKEN&openid=OPENID
    	String accesstoken=readToken(path);
    	String requestUrl = ConstantData.val_access_token_url.replace("ACCESS_TOKEN", accesstoken).replace("OPENID", openid);
    	JSONObject jsonObject = HttpRequest.httpsRequest(requestUrl, "GET", null);
    	int temp=0;
    	temp=jsonObject.getInt("errcode");
    	if(temp==1){
    		return true;
    	}else return false;
        
    	
    }
    
    public static String getTicket(String accesstoken) {
    	String requestUrl = ConstantData.get_ticket_url.replace("ACCESS_TOKEN", accesstoken);
    	JSONObject jsonObject = HttpRequest.httpsRequest(requestUrl, "GET", null);
    	String jsapi_ticket="";
    	 if (null != jsonObject) {
             try {
            	 jsapi_ticket = jsonObject.getString("ticket").toString();
             } catch (JSONException e) {
                 // 获取token失败
                 log.error("获取token失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"), jsonObject.getString("errmsg"));
             }
    	 }
		return jsapi_ticket;
    	
    }
    
    
    	
    	
    
    public static void writeToken(String path,String token) throws UnsupportedEncodingException, IOException{
    	   File tokenFile=new File(path+"token.txt");
           FileOutputStream out=new FileOutputStream(tokenFile,false); //如果追加方式用true        
           StringBuffer sb=new StringBuffer();
           sb.append(token);
           out.write(sb.toString().getBytes("utf-8"));//注意需要转换对应的字符集
           out.close();
    }
    
    public static void writeWebToken(String path,String token) throws UnsupportedEncodingException, IOException{
 	   File tokenFile=new File(path+"webtoken.txt");
        FileOutputStream out=new FileOutputStream(tokenFile,false); //如果追加方式用true        
        StringBuffer sb=new StringBuffer();
        sb.append(token);
        out.write(sb.toString().getBytes("utf-8"));//注意需要转换对应的字符集
        out.close();
 }
    
    public static String readToken(String path) throws UnsupportedEncodingException, IOException{
    	   StringBuffer sb=new StringBuffer();
           String tempstr=null;
	 	   File tokenFile=new File(path+"token.txt");
	 	   FileInputStream fis=new FileInputStream(tokenFile);
	       BufferedReader br=new BufferedReader(new InputStreamReader(fis));
	       while((tempstr=br.readLine())!=null)
           sb.append(tempstr);
	       return sb.toString();
    }
    public static String readWebToken(String path) throws UnsupportedEncodingException, IOException{
 	   StringBuffer sb=new StringBuffer();
        String tempstr=null;
	 	   File tokenFile=new File(path+"webtoken.txt");
	 	  
	 	   FileInputStream fis=new FileInputStream(tokenFile);
	       BufferedReader br=new BufferedReader(new InputStreamReader(fis));
	       while((tempstr=br.readLine())!=null)
        sb.append(tempstr);
	       return sb.toString();
 }
    
    
    public static void main(String args[]) throws UnsupportedEncodingException, IOException{
    	writeToken("/Users/berryzhang/Workspaces/","123456");
    	readToken("/Users/berryzhang/Workspaces/");
    }

    
}
