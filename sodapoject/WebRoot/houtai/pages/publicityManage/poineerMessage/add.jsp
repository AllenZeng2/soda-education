<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="${pageContext.request.contextPath}/houtai/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/houtai/js/main.js"></script>
<script type="text/javascript">
	function goBack() {
		location.href = "${pageContext.request.contextPath }/NewsServlet";
	}
	function tijiao(){
		var vcontent=document.getElementById("content").value;
		if(vcontent==null || vcontent.length==0){
			alert("內容不能为空");
			return false;
		} else if(confirm("确认提交？")){
			alert("提交成功");
		
			return true;
		} else {
			return false;
		}
	}
</script>
</head>
<body>
	<table width="100%" height="100%" border="0" cellspacing="0"
		cellpadding="3" name="addTable">
		<tr>
			<td
				style="height: 25px; background-color: #f3f3f3; font-weight: bold"
				valign="top">&nbsp;&nbsp;&nbsp;&nbsp;当前位置： <img
				src="${pageContext.request.contextPath}/houtai/images/arrow.gif" align="absmiddle">&nbsp;&nbsp;soda创业教育平台&nbsp;&nbsp;
				<img src="${pageContext.request.contextPath}/houtai/images/arrow.gif" align="absmiddle">&nbsp;&nbsp;后台管理&nbsp;&nbsp;
				<img src="${pageContext.request.contextPath}/houtai/images/arrow.gif" align="absmiddle">&nbsp;&nbsp;咨询管理
			</td>
		</tr>
		<tr>
			<td
				style="height: 34px; background-image: url(${pageContext.request.contextPath}/houtai/images/main_header.gif); border-bottom: 1px solid #cfd8e0; padding: 0px">
				<table width="100%" border="0" cellspacing="0" cellpadding="0"
					name="addTable2">
					<tr>
						<td width="20" height="34"><img
							src="${pageContext.request.contextPath}/houtai/images/main_headerL.gif" width="20" height="34"></td>
						<td style="color: #90c8e8;"><img
							src="${pageContext.request.contextPath}/houtai/images/icon_card.gif" width="16" height="16"
							align="absmiddle">&nbsp;&nbsp; <strong><a
								href="index.jsp">添加咨询</strong></td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td height="100%" valign="top">
				<div style="overflow: auto; height: 100%; width: 100%">
					<form action="${pageContext.request.contextPath }/InformationServlet?param=7" method="post" name="addForm">
						<table width="100%" border="0" cellpadding="3" cellspacing="1"
							class="table1" name="addTable3">
							<tr>
								<td style="text-align: right" style="width:300px">标题</td>
								<td><input type="text" name="in_title" value=""></td>
							</tr>
							<tr>
								<td style="text-align: right" style="width:300px">作者</td>
								<td><input type="text" name="in_userId"></td>
							</tr>
							<tr>
								<td style="text-align: right">是否推荐</td>
								<td><input type="radio" name="in_state" checked="checked" value="1">是&nbsp;&nbsp;&nbsp;&nbsp;<input
									type="radio" name="in_state" value="0">否</td>
							</tr>
							<tr>
								<td style="text-align: right">内容</td>
								<td><textarea rows="15" cols="42" name="in_content" id="content" value="content"></textarea></td>
							</tr>
							<tr>
								<td style="text-align: right"></td>
								<td><input type="submit" value="提交" name="submit" onclick="return tijiao()">
									<input type="button" value="返回" onClick="Javascript:goBack()"
									name="back"></td>
							</tr>
						</table>
					</form>
				</div>
			</td>
		</tr>
	</table>
</body>
</html>