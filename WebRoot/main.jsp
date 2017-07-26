<%@page import="com.xxx.weixin.ssh.Model.WxUserInfo"%>
<%@page import="org.apache.struts2.jasper.tagplugins.jstl.core.Import"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
		WxUserInfo user =(WxUserInfo)session.getAttribute("WxUser");
		if(user==null || user.equals("") || user.equals(null)){
		response.sendRedirect("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxa8476ad109c11e44&redirect_uri=http%3a%2f%2fgossiproom.wechat121.com%2fOpen&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect");
		  return;      
		}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=640,user-scalable=no,minimal-ui">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>人人有奖幸运轮</title>
<link rel="shortcut icon" href="../favicon.ico" />
<link href="../css/style.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="../js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="../js/awardRotate.js"></script>
<script type="text/javascript" src="../js/main.js"></script>

</head>
<body>
	<div>
		<div class="award_c">
			<div class="award_bg">
				<img src="../images/11.png" />
			</div>
			<div class="award">
				<!-- 代码 开始 -->
				<img src="../images/1.png" id="shan-img" style="display:none;" /> <img
					src="../images/2.png" id="sorry-img" style="display:none;" />
				<div class="banner">
					<div class="turnplate"
						style="background-image:url(../images/turnplate-bg.png);background-size:100%;">
						<canvas class="item" id="wheelcanvas" width="422px" height="422px"></canvas>
						<img class="pointer" src="../images/turnplate-pointer.png" />
					</div>
				</div>
				<!-- 代码 结束 -->

			</div>
		</div>
		

		<div class="yellow_bar"></div>

		<div class="container">
			<div class="tips">
				<br /> <br /> <br /> <br /> 
				<a class="tip_txt"><%=user.getNickname()%>请点击抽取大奖</a>
				<input class="oid" style="display:none;" value=<%=user.getOpenId().toString()%> />
			</div>
			<div class="lawyer">
				<a>本次抽奖最终解释权属于GossipRoom</a><br/><br/>
				<a class="tip_txt_awards">点击查看中奖信息</a>
				
			</div>
		</div>
		<div class="yellow_bar"></div>

		<div class="aw_des">
			<a class="title_c">奖项设置：<br /> <br /></a> 
			
			<a class="aw_name">壕如金狮<br /></a>
			<a class="aw_content">赠送免费双人龙虾安格斯牛排套餐，价值¥636<br /><br /></a>
			 
			<a class="aw_name">激情四射<br /></a> 
			<a class="aw_content">买泰式鸡翅薯条下午茶套餐配苹果汁／雪梨汁，只要¥38 － 原价¥58<br /><br /></a>

			<a class="aw_name">积极向上<br /></a>
			<a class="aw_content">买港式酱油鸡腿薯条套餐配苹果汁／雪梨汁，只要¥38 － 原价¥58<br /><br /></a> 
			
			<a class="aw_name">爱“饼”才会赢<br /></a>
			<a class="aw_content">买巧克力香蕉可丽饼，只要¥40 – 原价¥60<br /><br /></a> 
				
			<a class="aw_name">广告的莓丽人生<br /></a>
			<a class="aw_content">买缤纷草莓可丽饼，只要¥40 – 原价¥60<br /><br /></a> 
		
			<a class="aw_name">干杯继续干<br /></a>
			<a class="aw_content">赠送两杯指定白葡萄／红葡萄酒， 价值¥90<br /><br /></a> 
				
			<a class="aw_tips">温馨提示：<br /><br />
				(1) 中奖后您将中奖信息给到工作人员验证，用于兑奖。
				(2) 因餐厅每天采购当日鲜活龙虾，故中该奖者需提前一天订位，并说明兑换壕如金狮大奖。<br />
				(3) 鸡极向上奖和鸡情四射奖只限于下午3点后兑换，可以堂吃或免费外送至WPP大楼内。 <br />
				(4) 爱“饼”才会赢奖、广告的莓丽人生奖和干杯继续干奖只限于下午3点后兑换并于餐厅享用。<br /> 
				(5) 所有大奖均不能兑换成现金，并需要在2017年6月30日前兑换。<br /> 
				(6) 活动日期从2017年5月8日至2017年5月20日。<br /> 
				<br /> <br /> <br />
				
			</a>
		</div>



		<div class="yellow_bar"></div>


		<div class="qrcode">


			<img src="../images/4.png" />
			<div>
				<a class="qr_t1"><br /> <br /> <br />扫一扫关注我们<br /> <br /> <br />
					<a />
					<div class="qr_c">
						<a class="qr_t2"> Gossip Room --是一家用心经营、用料新鲜上盛的法式创意餐厅和酒吧，
							提供各类有范儿的饮料和美食。是广告潮人、制片人、极客、网红的时 尚聚集地，也是行内八卦和业界资讯的潮流驻所，亦是好友聚会和工作
							交流的幸福天地。<br /> <br /> 餐厅地址：上海市恒丰路399号达邦协作广场2层L2-01
						</a>
					</div>
			</div>

		</div>

		<div class="yellow_bar add_y"></div>

	</div>


</body>
</html>
