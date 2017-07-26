package com.xxx.weixin.ssh.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream; 
import java.util.Iterator;
import java.util.Properties; 

import com.xxx.weixin.ssh.Model.WxMpAccessToken;

public class PropertiesDB {
	
	public PropertiesDB(){
		
	}
	
	public WxMpAccessToken loadProperties(){
        Properties prop = new Properties();  
       
        File directory = new File(""); 
        System.out.println(directory.getAbsolutePath());    //得到的是C:/test/abc
        System.out.println(this.getClass().getClassLoader().getResource("/").getPath());  
       
        
        try{
            //读取属性文件a.properties
            InputStream in = new BufferedInputStream (new FileInputStream("/Users/berryzhang/Documents/MyEclipse Professional 2014/.metadata/.me_tcat/webapps/WXCRM/WEB-INF/classes/com/xxx/weixin/ssh/util/weixin.properties"));
            prop.load(in);     ///加载属性列表
            Iterator<String> it=prop.stringPropertyNames().iterator();
            while(it.hasNext()){
                String key=it.next();
                System.out.println(key+":"+prop.getProperty(key));
            }
            
            WxMpAccessToken token=new WxMpAccessToken(prop.getProperty("grant_type"),prop.getProperty("appid"), prop.getProperty("secret"), prop.getProperty("access_token"), prop.getProperty("expiresTime"));
            
            in.close();
            return token;
        }
        catch(Exception e){
            System.out.println(e);
        }
		return null;
    } 
}