package com.xxx.weixin.ssh.Action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringReader;

import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import com.xxx.weixin.common.message.XmlMessageHeader;
import com.xxx.weixin.mp.aes.WXBizMsgCrypt;
import com.xxx.weixin.mp.message.MpXmlMessages;

//appID
//wxf971f5b909dfaaf7
//appsecret
//cec902074c61e889cd2fc0d7a3d0e11b

public class CheckSignatureAction extends BaseAction {
    
    // 微信加密签名
    public String signature;
    // 时间戳
    public String timestamp;
    // 随机数
    public String nonce;
    // 随机字符串
    public String echostr;
    
	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getNonce() {
		return nonce;
	}

	public void setNonce(String nonce) {
		this.nonce = nonce;
	}

	public String getEchostr() {
		return echostr;
	}

	public void setEchostr(String echostr) {
		this.echostr = echostr;
	}
	
	private InputStream inputStream; //这个名字和struts.xml中对应，不能写错
	

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	//0vE8Pqpo3IZdMMQ5uBO5AeRV2LKniwgOxW0PX7TlBBU
	
	public String execute() throws Exception {
		
	try {
		ServletInputStream inputStream_content = request.getInputStream();
		ServletOutputStream outputStream = response.getOutputStream();
		System.out.println("GetInput: start！001");	
		String Xml_Data_From_Server =  IOUtils.toString(inputStream_content, "UTF-8");
		
		
		if(Xml_Data_From_Server!=null){
		    //转换XML
			System.out.println("转换ing！");
			System.out.println("Change :"+Xml_Data_From_Server);
			
//			MpXmlMessages mpXmlM = new MpXmlMessages();
//			XmlMessageHeader xmlMH=mpXmlM.fromXml(Xml_Data_From_Server);
//			
			String dataOut="<xml>"
					+ "<ToUserName><![CDATA[oODLNwsGaguxoFOJMRZtQcpkU-zg]]></ToUserName>"
					+ "<FromUserName><![CDATA[gh_5b54236328cc]]></FromUserName"
					+ "<CreateTime>12345678</CreateTime>"
					+ "<MsgType><![CDATA[text]]></MsgType>"
					+ "<Content><![CDATA[你好]]></Content>"
					+ "</xml>";
			System.out.println("dataOut:"+dataOut);
			//System.out.println("GetType:"+xmlMH.getMsgType().toString());
			//outputStream.write(dataOut.getBytes("utf-8"));
//			if(xmlMH.getMsgType().equals("text")){
//				outputStream.write(dataOut.getBytes("utf-8"));
//			}
			inputStream=new ByteArrayInputStream(dataOut.getBytes("UTF-8"));
			System.out.println("GetInput: stop！");
			return SUCCESS;
		}
		    
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println("ERROR:"+e);
		e.printStackTrace();
	}	   
	
	
	System.out.println("CheckSignatureAction: PJDR ....."+signature+"..."+timestamp+"..."+nonce+"..."+echostr);
	System.out.println("CheckSignatureAction: PJDR ....."+signature+"..."+timestamp+"..."+nonce+"..."+echostr);
	System.out.println(checkSignature(signature, timestamp, nonce));
	
	if (checkSignature(signature, timestamp, nonce)) {
		inputStream= new ByteArrayInputStream(echostr.getBytes("UTF-8"));  
		return SUCCESS;
	        }
		return ERROR;
    }

	    // 与接口配置信息中的Token要一致
	    private static String token = "pjdaren";
	    public static boolean checkSignature(String signature, String timestamp,String nonce) {
	        // 1.将token、timestamp、nonce三个参数进行字典序排序
	        String[] arr = new String[] { token, timestamp, nonce };
	        Arrays.sort(arr);
	        
	        // 2. 将三个参数字符串拼接成一个字符串进行sha1加密
	        StringBuilder content = new StringBuilder();
	        for (int i = 0; i < arr.length; i++) {
	            content.append(arr[i]);
	        }
	        MessageDigest md = null;
	        String tmpStr = null;
	        try {
	            md = MessageDigest.getInstance("SHA-1");
	            // 将三个参数字符串拼接成一个字符串进行sha1加密
	            byte[] digest = md.digest(content.toString().getBytes());
	            tmpStr = byteToStr(digest);
	        } catch (NoSuchAlgorithmException e) {
	            e.printStackTrace();
	        }
	        
	        content = null;
	        // 3.将sha1加密后的字符串可与signature对比，标识该请求来源于微信
	        return tmpStr != null ? tmpStr.equals(signature.toUpperCase()) : false;
	    }

	    private static String byteToStr(byte[] byteArray) {
	        String strDigest = "";
	        for (int i = 0; i < byteArray.length; i++) {
	            strDigest += byteToHexStr(byteArray[i]);
	        }
	        return strDigest;
	    }

	    private static String byteToHexStr(byte mByte) {
	        char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A','B', 'C', 'D', 'E', 'F' };
	        char[] tempArr = new char[2];
	        tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
	        tempArr[1] = Digit[mByte & 0X0F];
	        String s = new String(tempArr);
	        return s;
	    }

	
	
	
	
	
	
}
