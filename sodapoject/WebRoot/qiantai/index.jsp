﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>soda教育</title>

<link href="qiantai/css/style.css" type="text/css" rel="stylesheet" />
<script type="qiantai/text/javascript" src="qiantai/js/banner1.js"></script>

</head>

<body>
	<iframe style="width: 100%; height: 236px" scrolling="no"
		frameborder="0" src="qiantai/header.jsp" name="kangjiaIframe"></iframe>
	<div class="content">

		<div class="clear"></div>
		<div class="content_left">
			<div class="left_top">
				<div class="left_top_zuo">
					<div class="hyaq">
						<h1>

							现场课程<a
								href="${pageContext.request.contextPath }/xianchangServlet?param=1"
								style="float: right; font-size: 12px;" name="xianchanggengduo">更多...</a>

						</h1>

						<div class="list" style="overflow: hidden;">
							<ul>

								<c:forEach items="${course1 }" var="ce">
									<li><img src="qiantai/images/dian.png" width="5px"
										height="5px" alt="" />&nbsp;&nbsp; <a
										href="${pageContext.request.contextPath }/CourseInfoServlet?param=1&ce_id=${ce.ce_id }"
										target="_top">${ce.ce_name }</a></li>
								</c:forEach>

							</ul>
						</div>
						<!--list end-->
					</div>
					<!--hyaq end-->
					<div class="hyaq">
						<h1>创业资讯</h1>
						<div class="list">
							<ul>

								<c:forEach items="${information }" var="infor">
									<li><img src="qiantai/images/dian.png" width="5px"
										height="5px" alt="" />&nbsp;&nbsp;<a
										href="${pageContext.request.contextPath }/InfoServlet?in_id=${infor.in_id }&param=2">${infor.in_content
											}</a>
									</li>
								</c:forEach>

							</ul>
						</div>
						<!--list end-->
					</div>

					<div class="hyaq">
						<h1>公告信息</h1>

						<div class="list">
							<ul>

								<c:forEach items="${notice }" var="no">
									<li><img src="qiantai/images/dian.png" width="5px"
										height="5px" alt="" />&nbsp;&nbsp;<a
										href="InfoServlet?ne_id=${no.ne_id }&param=3">${no.ne_content
											}</a>
									</li>
								</c:forEach>

							</ul>
						</div>
						<!--list end-->
					</div>
				</div>
				<!--top_left_zuo end-->
				<div class="left_top_you">


					<div class="dfdt">
						<h1>

<!--
							在线课程<a href="${pageContext.request.contextPath }/ZaixianServlet"
  -->
							在线课程<a href="${pageContext.request.contextPath }/ZaixianServlet?param=1"

								style="float: right; font-size: 12px;" name="zaixiangengduo">更多...</a>

						</h1>
						<div class="list">
							<ul>

								<c:forEach items="${course2 }" var="ce">
									<li><img src="qiantai/images/dian.png" width="5px"
										height="5px" alt="" /><a
										href="${pageContext.request.contextPath }/CourseInfoServlet?param=2&ce_id=${ce.ce_id }"
										target="_top">${ce.ce_name }</a>
									</li>
								</c:forEach>

							</ul>
						</div>
						<!--list end-->
					</div>
					<!--dfdt end-->

					<div class="dfdt">
						<h1>动态新闻</h1>
						<div class="list">
							<ul>

								<c:forEach items="${news }" var="ns">
									<li><img src="qiantai/images/dian.png" width="5px"
										height="5px" alt="" />&nbsp;&nbsp;<a
										href="${pageContext.request.contextPath }/InfoServlet?ns_id=${ns.ns_id }&param=1">${ns.ns_content
											}</a>
									</li>
								</c:forEach>

							</ul>
						</div>
						<!--list end-->
					</div>
					<div class="dfdt">
						<h1>行业信息简介</h1>
						<div class="list">
							<ul>
								<c:forEach items="${industry }" var="iy">
									<li><img src="qiantai/images/dian.png" width="5px"
										height="5px" alt="" />&nbsp;&nbsp;<a
										href="InfoServlet?iy_id=${iy.iy_id }&param=4">${iy.iy_content
											}</a></li>
								</c:forEach>
							</ul>
						</div>
						<!--list end-->
					</div>
				</div>
				<!--top_left_you end-->
			</div>
			<!--left_top end-->
			<div class="clear"></div>
			<!--清除浮动-->
			<div class="left_under"></div>
			<!--left_under end-->
		</div>
		<!--content_left end-->


		<div class="content_right">

			<div class="qyfc">
				<h1>Soda概况</h1>
				<div class="list">
					<ul style="color:#666;">
						<c:forEach items="${survey }" var="sy" >
							<c:if test="${sy.sy_id==3}">
								<li>${sy.sy_content}</li>
							</c:if>
						</c:forEach>
					</ul>
				</div>
			</div>
			

			<!--qyfc end-->
			<div class="qyfc">
				<h1>关于我们</h1>
				<div class="list">
					<ul style="color:#666;">
						<li>
						<c:forEach items="${survey }" var="sy" >
							<c:if test="${sy.sy_id==2}">
								${sy.sy_content}
						    </c:if>
						</c:forEach>
						</li>
					</ul>

				</div>
				<!--list end-->
			</div>
			<!--qyfc end-->
			<div class="qyfc">
				<h1>版权声明</h1>
				<div class="list">
					<ul style="color:#666;">
						<li>
						<c:forEach items="${survey }" var="sy" >
							<c:if test="${sy.sy_id==1}">
								${sy.sy_content}
						    </c:if>
						</c:forEach>
						</li>
					</ul>

					</p>
				</div>
				<!--list end-->
			</div>
			<!--qyfc end-->
		</div>
		<!--content_right end-->

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