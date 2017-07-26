<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=640,user-scalable=no,minimal-ui">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title><s:text name="loginPage"/></title>

<style type="text/css">
body{
	background-image: url("../images/bg_crm.jpg");
    background-repeat: no-repeat;
    background-color: #dbc68c;
    
    }
  label{font-size: 25px; line-height: 80px; color:#062b3e;}   
 input{font-size: 25px;color:#062b3e;     line-height: 40px;}
 #Login{
     margin-top: 285px;
    margin-left: 100px;
 }   
 
#Login_login {
    width: 100px;
    height: 50px;
    margin-top: 20px;
color:#fff;
border-radius: 5px;
background: -webkit-linear-gradient(top,#062b3e,#062b3e);
 background: -moz-linear-gradient(top,#062b3e,#062b3e);
background: linear-gradient(top,#062b3e,#062b3e);
 background: -ms-linear-gradient(top,#062b3e,#062b3e);
}
</style>
</head>
<body>

<s:form class="form1" action="Login">
    <s:textfield name="username" key="user"/>
    <s:textfield name="password" key="pass"/>
    <s:submit key="login"/>
</s:form>
</body>
</html>