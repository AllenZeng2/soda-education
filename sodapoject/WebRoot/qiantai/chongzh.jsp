<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>soda教育</title>
<link href="qiantai/css/style.css" type="text/css" rel="stylesheet" />
<link href="qiantai/css/single.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="qiantai/js/banner1.js"></script>
<script type="text/javascript">
	function store(){
		//document.getElementById("stid").value="";
		document.myform.submit();
	}
</script>
</head>
<body>
<form name="myform" action="${pageContext.request.contextPath }/StudentServlet" method="post" >
	<input name="stid" id="stid" value="${student.st_id }" /> 
	<iframe style="width: 100%; height: 236px" scrolling="no"
		frameborder="0" src="qiantai/header.jsp" name="kangjiaIframe"></iframe>

	<div class="content">

		<div class="clear"></div>
		<div class="buyDiv">

			<div class="buyHeader">
				<h1>充值</h1>
				<div class="innerDiv" onclick="history.back();">返 回</div>
				<div class="innerDiv" onclick="store()">充 值</div>
			</div>


			<div class="loginBody">
				<fieldset class="registField">
					<legend style="color: #DE3237;" align="left">充 值</legend>
					<form name="chongzhiform">
						<table class="registTable" name="chongzhiTable">
							<tr>
								<td align="right" style="width: 30%;">用户</td>
								<td></td>
								<td align="left">${student.st_name }</td>
							</tr>
							<tr>
								<td align="right">余额</td>
								<td></td>
								<td align="left">${student.st_money }</td>
							</tr>
							<tr>
								<td align="right">充值金额</td>
								<td><img src="" /></td>
								<td align="left"><input type="text" size="5"
									id="st_money"
									name="st_money" />&nbsp;元</td>
							</tr>
						</table>
					</form>
				</fieldset>
			</div>
		</div>
		<div class="clear"></div>
		<!--清除浮动-->
	</div>
	<!--content end-->



	<div class="footer">
		<ul>


			<li class="li_left">${student.st_address }</li>
			<li class="li_right">${student.st_phone }</li>
		</ul>
	</div>
	<!--footer end-->
	<div style="display: none">
		<script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540'
			language='JavaScript' charset='gb2312'></script>
	</div>
</body>
</html>