<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="houtai/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="houtai/js/main.js"></script>
<script type="text/javascript">
	
	
	//导出excel
	function expolExcel() {
		var count = 0;
		var dd=[];
		var j=0;
		var alls = document.getElementsByName("checkbox2");
		for ( var i = 0; i < alls.length; i++) {
			if (alls[i].checked) {
				count++;
			}
		}
		if (count > 0) {
			if (confirm("确认要导出吗?")) {
				for ( var i = 0; i < alls.length; i++) {
					if (alls[i].checked) {		
						dd[j++]=alls[i].value;
					}
				}
				window.location.href="NewsExceServlet?dd="+dd;	
				alert("成功!");
			}
		} else {
			alert("请选中要操作的项");
		}
	}

	//全选和全不选
	function allCheck() {
		var alls = document.getElementsByName("checkbox2");
		var conterCheck = document.getElementById("checkbox1");
		for ( var i = 0; i < alls.length; i++) {
			if (conterCheck.checked) {
				alls[i].checked = true;
			} else {
				alls[i].checked = false;
			}
		}
	}
	function tiaozhuan(pageText){
		window.location.href="${pageContext.request.contextPath }/SelectNewsServlet?page="+pageText;
		document.myform.submit;
	}
	function tijiao(num){
		document.getElementById("page").value=num;
		document.myform.submit();
	}
	function update(sel,id){
		
		var val=sel.value;
		var va;
		if(val==0){
			va=1;
		}if(val==1){
			va=0;
		}
		
		var xhr;
		xhr=new XMLHttpRequest();
		xhr.open("get","${pageContext.request.contextPath }/UpdateStateByIdServlet?id="+id+"&&state="+va,true);
		
		xhr.send(null);
	}
	function select(){
		
		window.location.href="${pageContext.request.contextPath }/SelectNewsServlet";
	}
	function shanchu1(){
		
		var alls = document.getElementsByName("checkbox2");
		var list=[];
		var j=0;
		for ( var i = 0; i < alls.length; i++) {
			if (alls[i].checked) {
			var sel=document.getElementsByName("checkbox2").value;
			list[j++]=alls[i].value;	
			
			}
		}
	 if (j > 0) {
			if (confirm("确认要删除吗?")) {
				 window.location.href="${pageContext.request.contextPath }/UpdateStatusByIdServlet?id="+list;		
				alert("删除成功!");
			}
		} else {
			alert("请选中要操作的项");
		}
	 }		
	 function shanchu(sel){
	 if (confirm("确认要删除吗?")) {
				var id=sel.value;
				 window.location.href="${pageContext.request.contextPath }/UpdateStatusByIdServlet?id="+id;		
				
			}else {
			alert("请选中要操作的项");
		}
	 }
	function tia(){
		var pa=document.getElementById("pageText").value;
		var totalPage=document.getElementById("totalPage").value;
		if(isNaN(pa)){
			alert("请输入数字!");
			location.href="SelectNewsServlet";
		}else if(pa*1>totalPage*1){
			alert("输入的数字超出范围!");	
			location.href="SelectNewsServlet";
		}
		else{
			
			window.location.href="javascript:tiaozhuan(document.getElementById('pageText').value)";
			
		}	
	
	}
</script>
</head>
<body>
	<form method="post" action="SelectNewsServlet" name="myform">
		<input type="hidden" name="page" id="page" />
		<input type="hidden" name="totalPage" id="totalPage" value="${p.totalNum }" />
		<table width="100%" height="100%" border="0" cellspacing="0"
			cellpadding="3" name="listTable">
			<tr>
				<td style="height:25px; background-color:#f3f3f3; font-weight:bold"
					valign="top">&nbsp;&nbsp;&nbsp;&nbsp;当前位置： <img
					src="houtai/images/arrow.gif" align="absmiddle">&nbsp;&nbsp;soda创业教育平台&nbsp;&nbsp;
					<img src="houtai/images/arrow.gif" align="absmiddle">&nbsp;&nbsp;后台管理&nbsp;&nbsp;
					<img src="houtai/images/arrow.gif" align="absmiddle">&nbsp;&nbsp;新闻管理</td>
			</tr>
			<tr>
				<td
					style="height:34px; background-image:url(houtai/images/main_header.gif); border-bottom:1px solid #cfd8e0; padding:0px">
					<table width="100%" border="0" cellspacing="0" cellpadding="0"
						name="listTable2">
						<tr>
							<td width="20" height="34"><img
								src="houtai/images/main_headerL.gif" width="20" height="34">
							</td>
							<td style="color:#90c8e8;"><img
								src="houtai/images/icon_card.gif" width="16" height="16"
								align="absmiddle">&nbsp;&nbsp;<strong>新闻管理</strong></td>
							<td align="right" class="white" style="padding-right:20px">
								<a href="Javascript:expolExcel()" class="barBtn" name="export"><img
									src="houtai/images/1.png" width="16" height="16"
									align="absmiddle"> 导出</a> <a
								href="houtai/pages/newconter/add.jsp" class="barBtn" name="add"><img
									src="houtai/images/5.png" width="16" height="16"
									align="absmiddle"> 添加</a> <a href="Javascript:shanchu1()"
								class="barBtn" name="batchDelete"><img
									src="houtai/images/6.png" width="16" height="16"
									align="absmiddle"> 删除</a>
							</td>
						</tr>
					</table></td>
			</tr>
			<tr>
				<td
					style="height:30px; background-color:#bddbff; border-bottom:1px solid #cfd8e0;"><table
						width="100%" border="0" cellpadding="3" cellspacing="1"
						class="table1" name="listTable3">
						<TR>
							<th width="10%" align="center">标题</th>
							<td width="20%" class="BGCgray"><input type="text"
								name="ns_title" id="textfield" value="${param.ns_title }">
							</td>
							<th width="10%" align="center">更新时间</th>
							<td width="20%" class="BGCgray"><input type="text"
								name="ns_showtime" id="textfield" value="${param.ns_showtime}"></td>
							<th width="10%" align="center">是否推荐</th>
							<td width="20%" class="BGCgray"><select name="ns_state"
								id="select2">
									<option value="2" selected="selected">全部</option>
									<option value="0" <c:if test="${param.ns_state==0 }">selected="selected"</c:if>>是</option>
									<option value="1" <c:if test="${param.ns_state==1 }">selected="selected"</c:if>>否</option>
							</select></td>
							<th width="10%" align="center"><BUTTON type="submit"
									style="HEIGHT:25px" onClick="javascript:select()"
									name="dimSelect">
									<img src="houtai/images/btn_search.gif" width="16" height="16"
										align="absmiddle"> 查询
								</BUTTON></th>
						</TR>
					</table></td>
			</tr>
			<tr>
				<td height="100%" valign="top">
					<div style="overflow:auto;height:100%; width:100%">
						<table width="100%" border="0" cellpadding="3" cellspacing="1"
							class="table1" name="listTable4">
							<TR>
								<th align="center"><input type="checkbox" name="checkbox"
									id="checkbox1" onChange="allCheck()"></th>
								<th align="center">ID</th>
								<th align="center">信息标题</th>
								<th align="center">发布时间</th>
								<th align="center">是否推荐</th>
								<th width="180" align="center">操作</th>
							</TR>
							<c:forEach items="${news }" var="n">
								<TR style="color:black;">
									<TD align="center"><input type="checkbox" name="checkbox2"
										value="${n.ns_id }"></TD>
									<TD align="center">${n.ns_id }</TD>
									<TD align="left"><a
										href="javascript:location.href='SelectNewsByidServlet?ns_id=${n.ns_id }&&param=1'"
										style="color:black;">${n.ns_title}</a>
									</TD>
									<TD align="center">${n.ns_showtime }</TD>
									<TD align="center"><input type="checkbox" name="checkbox3"
										value="${n.ns_state }" onclick="update(this,${n.ns_id})"
										<c:if test="${n.ns_state==0}">checked="checked" </c:if> />
									</TD>
									<TD width="180" align="center">
										<BUTTON type="button" style="height:21px; font-size:12px"
											onClick="javascript:location.href='SelectNewsByidServlet?ns_id=${n.ns_id }&&param=1'">查看</BUTTON>
										<BUTTON type="button" style="height:21px; font-size:12px"
											onClick="javascript:location.href='SelectNewsByidServlet?ns_id=${n.ns_id }&&param=2'">编辑</BUTTON>
										<BUTTON type="button" id="choose"
											style="height:21px; font-size:12px"
											onClick="javascript:shanchu(this)" value="${n.ns_id }">删除</BUTTON>
									</TD>
								</TR>
							</c:forEach>


						</table>
						<table width="100%" border="0" cellspacing="0" cellpadding="0"
							name="listTable5">
							<tr>
								<td width="20%" height="25"><table border="0"
										cellspacing="0" cellpadding="3">
										<tr>
											<td style="width:60px"></td>
											<td style="width:60px"><a
												href="SelectNewsServlet?page=1" name="pageFirst"><span
													style="color:#000;">首页</span> </a></td>
											<td style="width:60px"><a
												href="SelectNewsServlet?page=${p.pageNum-1 }" name="pageUp"><span
													style="color:#000; ">上一页</span> </a></td>
											<c:forEach begin="1" end="${p.totalNum }" var="pa">
												<td style="width:30px">
												
												<a
													href="SelectNewsServlet?page=${pa}"><span
														style="color:#000; " name="pp">${pa}</span> </a>
														
													
														
														</td>
											</c:forEach>
											<td style="width:60px"><a
												href="javascript:tijiao(${p.pageNum+1 })"
												name="pageNext"><span style="color:#000;">下一页</span> </a></td>
											<td style="width:60px"><a
												href="SelectNewsServlet?page=${p.totalNum }" name="pageEnd"><span
													style="color:#000;">尾页</span>></a></td>
										</tr>
									</table></td>
								<td width="20%" align="center"><table border="0"
										cellspacing="0" cellpadding="3" name="listTable6">
										<tr>
											<td><a onclick="tia()" name="pageGo"><img src="houtai/images/next.gif"
													width="16" height="16" border="0"> </a></td>
											<td><input id="pageText" name="pageText" type="text"
												size="3" style="width:25;height:18"> /页</td>
										</tr>
									</table></td>
								<td width="20%" align="right">共${p.totalSize}条记录显示到1/1</td>
							</tr>
						</table>
					</div>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>