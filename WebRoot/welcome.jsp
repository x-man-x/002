<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=640,user-scalable=no,minimal-ui">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title><s:text name="succPage"/></title>
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<style type="text/css">

body{background-color:#000; color:#fff;}
    
div{font-size: 25px;line-height:50px; text-align: center;} 
.row{width:100%;border: 1px solid #666666; border-radius: 5px;    background-color: rgb(27, 201, 142);   display: flex; height:50px;margin-top: 10px;}
.row->div{float: left;}
.name{width:40%; border-right: 1px solid #666666;  }
.awards{width:40%; border-right: 1px solid #666666; }
.action{width:20%;
color:#fff;
border-radius: 5px;
background: -webkit-linear-gradient(top,#062b3e,#062b3e);
 background: -moz-linear-gradient(top,#062b3e,#062b3e);
background: linear-gradient(top,#062b3e,#062b3e);
 background: -ms-linear-gradient(top,#062b3e,#062b3e);
}

.title{
text-align:left; border-bottom:1px solid #666; font-size:30px;}
.action_t{width:20%;}
</style>
</head>
<body>
   <%--  <s:text name="succTip">
        <s:param>${sessionScope.user}</s:param>
    </s:text><br/> --%>
 <div class="title">GossipRoom后台管理系统</div>
 <div class="dataAll">
 <div class="row"><div class="name">昵称</div><div class="awards">中奖信息</div><div class="action_t">审核</div></div>

 </div>
    <script>
    
    $.ajax({ url: "Approve!getAllData", success: function(result){
			var items=result.data;
			console.log(result);
			//awardsLogs
			var head="<div class='row'><div class='name'>昵称</div><div class='awards'>中奖信息</div><div class='action_t'>审核</div></div>";
			var temp="";
			var arr= ["龙牛共舞", "激情四射", "积极向上", "乖乖巧巧", "冰纷多彩", "干杯再干杯"];
			for (var i = 0; i < items.length; i++) {
		        console.log(i+":"+items[i]);
		        //String userId, String username, Integer awardId, Timestamp actionTime
		        var actionTime=items[i].actionTime;
		        console.log(actionTime);
		        if(actionTime=="null" || actionTime==null || actionTime==""){
		        	temp=temp+"<div class='row'><div class='name'>"+items[i].username+"</div><div class='awards'>"+arr[items[i].awardId-1]+"</div><div class='action' id='"+items[i].id+"' data-appid='"+items[i].id+"'>未审核</div></div>";
		        }else {
		        	temp=temp+"<div class='row'><div class='name'>"+items[i].username+"</div><div class='awards'>"+arr[items[i].awardId-1]+"</div><div class='action'>已审核</div></div>";
		        }
		       
		    };
		    
		     $(".dataAll").html(
		        	head+temp
		        );
		        
		        
		           
	    $(".action").click(function(){
			    	var id=$(this).attr('data-appid');
			
					if(id==null || id==""){
						alert("已审核");
					}else{
						$(this).attr('data-appid',"");
						$(this).html("已审核");
					 $.ajax({ url: "Approve!setApprove?approveId="+id, success: function(result){
							var item=result.data;
							console.log(item);
							
							if(item=="1" || item==1){
							
								$(this).attr('data-appid',"");
								$(this).html("已审核");
								}
							}
						});	
					};
	     });
	     
	  }});
    
    </script>
</body>
</html>