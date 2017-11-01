package com.xxx.weixin.ssh.Action;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xxx.weixin.ssh.DAO.AwardsLogsDAO;
import com.xxx.weixin.ssh.DAO.UserDAO;
import com.xxx.weixin.ssh.Model.AwardsLogs;
import com.xxx.weixin.ssh.Model.User;
import com.xxx.weixin.ssh.Util.PropertiesDB;

public class LoginAction extends BaseAction {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UserDAO userDAO;
	public AwardsLogsDAO awardsLogsDAO;
	
	public int approveId;
	
	public int getApproveId() {
		return approveId;
	}

	public void setApproveId(int approveId) {
		this.approveId = approveId;
	}

	public UserDAO getUserDAO() {
		return this.userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public String username;
	public String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
	
    public AwardsLogsDAO getAwardsLogsDAO() {
		return awardsLogsDAO;
	}

	public void setAwardsLogsDAO(AwardsLogsDAO awardsLogsDAO) {
		this.awardsLogsDAO = awardsLogsDAO;
	}
	
	private Map<String, Object> dataMap;

	public Map<String, Object> getDataMap() {
		return dataMap;
	}
	


	public String execute() throws Exception {
    	PropertiesDB PDB=new PropertiesDB();
    //	token=PDB.loadProperties();

    	System.out.println("start");
    	
    	List<User> Users =userDAO.findAll();
    	System.out.println(Users.size());
    	
        if (username.equals("admin") && password.equals("admin")) {

        session.put("user", getUsername());
        	
        	
            return SUCCESS;
        }else{
            return ERROR;
        }
    }
	
	
	public String getAllData(){
		dataMap = new HashMap<String, Object>();
		List<AwardsLogs> awardsLogs= awardsLogsDAO.findAll();
		dataMap.put("data", awardsLogs);
		// 放入一个是否操作成功的标识
		dataMap.put("success", true);
		
		// 返回结果
		return SUCCESS;

	}
	
	public String setApprove(){
		dataMap = new HashMap<String, Object>();

		AwardsLogs awardsLogs=awardsLogsDAO.findById(approveId);
        //注意format的格式要与日期String的格式相匹配  
		Date date = new Date();       
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");  
		String dateStr = "";
		dateStr = sdf.format(date);  

		System.out.print(dateStr);
		
		awardsLogs.setActionTime(dateStr);
		
		awardsLogsDAO.merge(awardsLogs);
		
		
		dataMap.put("data", 1);
		// 放入一个是否操作成功的标识
		dataMap.put("success", true);
		
		// 返回结果
		return SUCCESS;

	}
	
	
}