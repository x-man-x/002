package com.xxx.weixin.ssh.Action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import com.opensymphony.xwork2.ActionSupport;
import com.xxx.weixin.ssh.API.WxGetToken;
import com.xxx.weixin.ssh.API.WxGetUserinfo;
import com.xxx.weixin.ssh.DAO.AwardsDAO;
import com.xxx.weixin.ssh.DAO.AwardsLogsDAO;
import com.xxx.weixin.ssh.DAO.UserDAO;
import com.xxx.weixin.ssh.DAO.WxUserInfoDAO;
import com.xxx.weixin.ssh.Model.Awards;
import com.xxx.weixin.ssh.Model.AwardsLogs;
import com.xxx.weixin.ssh.Model.Token;
import com.xxx.weixin.ssh.Model.User;
import com.xxx.weixin.ssh.Model.WxUserInfo;
import com.xxx.weixin.ssh.util.CommonUtil;
import com.xxx.weixin.ssh.util.HttpRequest;

public class getAwardAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, Object> dataMap;

	public Map<String, Object> getDataMap() {
		return dataMap;
	}
	
	private AwardsDAO awardsDAO;
	private AwardsLogsDAO awardsLogsDAO;
	private WxUserInfoDAO wxUserInfoDAO;
	
	public WxUserInfoDAO getWxUserInfoDAO() {
		return wxUserInfoDAO;
	}

	public void setWxUserInfoDAO(WxUserInfoDAO wxUserInfoDAO) {
		this.wxUserInfoDAO = wxUserInfoDAO;
	}

	public AwardsDAO getAwardsDAO() {
		return this.awardsDAO;
	}

	public void setAwardsDAO(AwardsDAO awardsDAO) {
		this.awardsDAO = awardsDAO;
	}

	public AwardsLogsDAO getAwardsLogsDAO() {
		return this.awardsLogsDAO;
	}

	public void setAwardsLogsDAO(AwardsLogsDAO awardsLogsDAO) {
		this.awardsLogsDAO = awardsLogsDAO;
	}
	
	
	public String oid;
	

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String execute() throws Exception {
		dataMap = new HashMap<String, Object>();
		WxUserInfo wxUserInfo=(WxUserInfo)session.get("WxUser");
		String oid_g=wxUserInfo.getOpenId().toString();
		System.out.println("oid_g......."+oid_g);
		
		List lt=awardsLogsDAO.findByUserId(oid_g);
		if(lt.size()>0){
			dataMap.put("data", 0);
			System.out.println("中奖号码："+0);
		}else{
			List <Awards>list=awardsDAO.findAll();
			
			int Number_award = getAwardsNum(Awards_list(list));
			
			Awards award_update=list.get(Number_award);
			award_update.setNums(award_update.getNums()-1);
			
			awardsDAO.merge(award_update);
			AwardsLogs awardLogs=new AwardsLogs();
			WxUserInfo wxUser=(WxUserInfo)session.get("WxUser");
			
			awardLogs.setUserId(oid_g);
			awardLogs.setUsername(wxUserInfo.getNickname());
			awardLogs.setAwardId(Number_award+1);
			
			awardsLogsDAO.save(awardLogs);

			dataMap.put("data", Number_award+1);
			System.out.println("中奖号码："+(Number_award+1));
		}
		
		
		
		// 放入一个是否操作成功的标识
		dataMap.put("success", true);
		
		// 返回结果
		return SUCCESS;

	}
	

	public String valaWards() throws Exception {
		dataMap = new HashMap<String, Object>();
		WxUserInfo wxUserInfo=(WxUserInfo)session.get("WxUser");
		String oid_g=wxUserInfo.getOpenId().toString();
		System.out.println("oid_g......."+oid_g);
		
		List lt=awardsLogsDAO.findByUserId(oid_g);
		
		if(lt.size()>0){
			AwardsLogs awardsLogs= (AwardsLogs) lt.get(0);
			dataMap.put("data", 1);
			dataMap.put("username", awardsLogs.getUsername());
			dataMap.put("num", awardsLogs.getAwardId());
		}else{
			
			dataMap.put("data", 0);
			dataMap.put("username", wxUserInfo.getNickname());
		}
		
		// 放入一个是否操作成功的标识
		dataMap.put("success", true);
		
		// 返回结果
		return SUCCESS;

	}
	
	
	
	public List <Awards>Awards_list(List <Awards>list){
		List <Awards>list_new=new ArrayList<Awards>();
		for(int i=0;i<list.size();i++){
			Awards award_temp=list.get(i);
			if(award_temp.getNums()>0){
				list_new.add(award_temp);
			}
		}
		return list_new;
	}
	
	public int getAwardsNum(List <Awards>Awards_list){
		int awardCounts=Awards_list.size();
		int choose = new Random().nextInt(awardCounts-1);// 返回[0,10)集合中的整数，注意不包括10
		int i =Awards_list.get(choose).getId();
		return i;
	}

}
