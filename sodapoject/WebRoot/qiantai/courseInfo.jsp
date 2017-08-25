﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>soda教育</title>
<link href="qiantai/css/style.css" type="text/css" rel="stylesheet" />
<link href="qiantai/css/single.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="js/banner1.js"></script>






</head>

<body>
	<iframe style="width: 100%; height: 236px" scrolling="no"
		frameborder="0" src="qiantai/header.jsp" name="kangjiaIframe"></iframe>

	<div class="content">

		<div class="clear"></div>
		<div class="buyDiv">

			<div class="buyHeader">
				<h1>课程信息</h1>
				<div class="innerDiv" onclick="history.back();">返回</div>
				<div class="innerDiv">
					<a href="BaomingGoumaiServlet?param=dangemai&ce_id=${course.ce_id }">${baominggoumai}</a>
				</div>
			</div>

			<div class="infoBody">
				<fieldset class="infoField">
					<legend style="color: #DE3237;" 
					align="left">课程信息</legend>
					
					<form name="courseInfoform" 
					action="CourseInfoServlet"
						method="post">
						<table class="registTable" name="courseInfoTable">
							<tr>
								<td align="right" style="width: 30%;">课程名称:
								</td>
								<td align="left">${course.ce_name }</td>
								<td align="right">课程类型:</td>
								<td align="left">现场课程</td>
							</tr>
							<tr>
								<td align="right">课程价格:</td>
								<td align="left">${course.ce_money }</td>
								<td align="right">课程状态:</td>

								<c:if test="${course.ce_state==1 }">
									<td align="left">可报名</td>
								</c:if>
								<c:if test="${course.ce_state==0 }">
									<td align="left">不可报名</td>
								</c:if>

							</tr>
							<tr>
								<td align="right">开课时间:</td>
								<td align="left">${course.ce_opentime }</td>
								<td align="right">结课时间:</td>
								<td align="left">${course.ce_endtime }</td>
							</tr>
							<tr>
								<td align="right">课程讲师:</td>
								<td align="left">李国华</td>
								<td align="right">视频资源:</td>

								<c:if test="${course.ce_type==1 }">
									<td align="left">无视频资源</td>
								</c:if>
								<c:if test="${course.ce_type==2 }">
									<td align="left"><a href="javascript:alert('下载成功！');"
										name="Download">javaSE</a></td>
								</c:if>

							</tr>
							<tr>
								<td align="right">备注信息:</td>
								<td align="left" colspan="3">${course.ce_easy }</td>
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


			<li class="li_left">地址：${sessionScope.contact.ct_content }</li>
			<li class="li_right">联系电话：${sessionScope.contact.ct_phone }</li>
		</ul>
	</div>
	<!--footer end-->
	<div style="display: none">
		<script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540'
			language='JavaScript' charset='gb2312'></script>
	</div>
</body>
</html>