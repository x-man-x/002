package com.xxx.weixin.ssh.Action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xxx.weixin.ssh.Model.Token;
import com.xxx.weixin.ssh.Model.WxMpAccessToken;
import com.xxx.weixin.ssh.Util.HttpRequest;

public class BaseAction extends ActionSupport implements ServletRequestAware,ServletResponseAware,SessionAware,ApplicationAware{
	private static final long serialVersionUID = 1348913248;
	
	public static Token token=null;
    
	protected HttpServletRequest request;  
	protected HttpServletResponse response;
	
    protected Map<String, Object> session;  
    protected Map<String, Object> application;
    

	public Token getToken() {
		return this.token;
	}

	public void setToken(Token token) {
		this.token = token;
	}


    @Override
    public void setSession(Map<String, Object> session) {
        this.session=ActionContext.getContext().getSession();
    }

    @Override
    public void setServletResponse(HttpServletResponse response) {
        this.response=response;
    }

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request=request;
    }

	@Override
	public void setApplication(Map<String, Object> application) {
		// TODO Auto-generated method stub
		this.application=ActionContext.getContext().getApplication();
	}
	
//
//	public Map<String, Object> getSession() {
//		return ActionContext.getContext().getSession();
//	}
//
//	public Map<String, Object> getContextMap() {
//		return ActionContext.getContext().getContextMap();
//	}
//
//	public ActionContext getContext() {
//		return ActionContext.getContext();
//	}
	
}