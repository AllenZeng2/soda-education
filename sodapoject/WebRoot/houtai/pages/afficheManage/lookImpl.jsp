<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="houtai/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="houtai/js/main.js"></script>
<script type="text/javascript">
	function goBack() {
		location.href = "${pageContext.request.contextPath }/NoticeServlet";
	}
</script>
</head>
<body>
	<table width="100%" height="100%" border="0" cellspacing="0"
		cellpadding="3" name="lookTable">
		<tr>
			<td
				style="height: 25px; background-color: #f3f3f3; font-weight: bold"
				valign="top">&nbsp;&nbsp;&nbsp;&nbsp;当前位置： <img
				src="houtai/images/arrow.gif" align="absmiddle">&nbsp;&nbsp;soda创业教育平台&nbsp;&nbsp;
				<img src="houtai/images/arrow.gif" align="absmiddle">&nbsp;&nbsp;后台管理&nbsp;&nbsp;
				<img src="houtai/images/arrow.gif" align="absmiddle">&nbsp;&nbsp;soda公告管理
			</td>
		</tr>
		<tr>
			<td
				style="height: 34px; background-image: url(houtai/images/main_header.gif); border-bottom: 1px solid #cfd8e0; padding: 0px">
				<table width="100%" border="0" cellspacing="0" cellpadding="0"
					name="lookTable2">
					<tr>
						<td width="20" height="34"><img
							src="houtai/images/main_headerL.gif" width="20" height="34"></td>
						<td style="color: #90c8e8;"><img
							src="houtai/images/icon_card.gif" width="16" height="16"
							align="absmiddle">&nbsp;&nbsp; <strong>soda公告管理
								&nbsp;&nbsp;》》》编辑soda公告</strong></td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td height="100%" valign="top">
				<div style="overflow: auto; height: 100%; width: 100%">
					<form action="" method="post" name="lookForm">
						<table width="100%" border="0" cellpadding="3" cellspacing="1"
							class="table1" name="lookTable3">
							<tr>
								<td style="text-align: right">标题</td>
								<td>${notice.ne_title }</td>
							</tr>
							<tr>
								<td style="text-align: right">作者</td>
								<td>${notice.ne_other1 }</td>
							</tr>
							<tr>
								<td style="text-align: right">公告级别</td>
								<td>
									
									<c:if test="${notice.ne_level==3}">
									非常紧急
									</c:if>
									<c:if test="${notice.ne_level==2}">
									紧急
									</c:if>
									<c:if test="${notice.ne_level==1}">
									一般
									</c:if>
									</td>
							</tr>
							<tr>
								<td style="text-align: right">内容</td>
								<td>${notice.ne_content }</td>
							</tr>
							<tr>
								<td style="text-align: right"></td>
								<td><input type="button" value="返回"
									onClick="Javascript:goBack()" name="back"></td>
							</tr>
						</table>
					</form>
				</div>
			</td>
		</tr>
	</table>
</body>
</html>