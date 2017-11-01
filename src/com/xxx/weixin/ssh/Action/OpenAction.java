package com.xxx.weixin.ssh.Action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.xxx.weixin.ssh.Util.CommonUtil;
import com.xxx.weixin.ssh.Util.HttpRequest;

public class OpenAction extends BaseAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public WxUserInfoDAO wxUserInfoDAO;
	

	private String code;
    private String STATE;
	
    public WxUserInfoDAO getWxUserInfoDAO() {
		return this.wxUserInfoDAO;
	}

	public void setWxUserInfoDAO(WxUserInfoDAO wxUserInfoDAO) {
		System.out.println("注入进来了"); 
		this.wxUserInfoDAO = wxUserInfoDAO;
	}

	
    
    public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSTATE() {
		return this.STATE;
	}

	public void setSTATE(String sTATE) {
		this.STATE = sTATE;
	}

	private Map<String,Object> dataMap;  
    
    public Map<String, Object> getDataMap() {  
        return dataMap;  
    }  
    
  
	
    public String execute() throws Exception {
    		
    	try {
			String APPID=ConstantData.APPID;
			String SECRET=ConstantData.SECRET;
			String RootPath =request.getSession().getServletContext().getRealPath("/");
			Token token=WxGetToken.getToken(APPID,SECRET,code,RootPath);
			
			setToken(token);
			WxUserInfo wxUser=new WxUserInfo();
			wxUser=WxGetUserinfo.getUserInfo(token.getAccessToken(), token.getOpenid());
			
			
			String oid=wxUser.getOpenId().toString();
			System.out.println("Oid--------:"+oid);
			List lt=wxUserInfoDAO.findByOpenId(oid);
			if(lt.size()==0){
				wxUserInfoDAO.save(wxUser);
			}
			
			session.put("WxUser", wxUser);
			// 返回结果  
			return SUCCESS;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
			
		}
    	
    }
    
    
    
    public String ajax_execute() throws Exception {

    	String APPID=ConstantData.APPID;
    	String SECRET=ConstantData.SECRET;
    	System.out.println("Code--------:"+code);
    	String RootPath =request.getSession().getServletContext().getRealPath("/");
    	Token token=WxGetToken.getToken(APPID,SECRET,code,RootPath);
    	setToken(token);
    	
    	WxUserInfo user=WxGetUserinfo.getUserInfo(token.getAccessToken(), token.getOpenid());
//    	WxUserInfo user=WxGetUserinfo. getUserInfo("lDtrLfzPe0mO-6LXr71RYol2p1bp32jXeCC9hWTOPWyhCu1R3gJAKZH8Agm2GfarG8QugRu9ZeGBnIzBIPylu3NerFOwRw-aNQfKiknd-bw", "o9kTfwQzOMx-vlKgAq2cJBJHw8Pk");
    	dataMap = new HashMap<String, Object>();  
        dataMap.put("data", user);  
        // 放入一个是否操作成功的标识  
        dataMap.put("success", true);  
        // 返回结果  
    	return SUCCESS;
    	
    }
    
    
    
    public static void main(String []args){
    	
    	
    }
	

}
