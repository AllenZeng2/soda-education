<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="houtai/css/style.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript" src="houtai/js/main.js"></script>
<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">

	//批量删除
	function checkeDel() {
		var count = 0;
		var alls = document.getElementsByName("checkbox2");
		for ( var i = 0; i < alls.length; i++) {
			if (alls[i].checked) {
			    //alert(alls[i].value);
				count++;
			}
		}
		if (count > 0) {
			if (confirm("确认要删除吗?")) {
			    document.getElementById("gansha").value = "deleteAll";
			    //document.forms[0].submit();
			    document.myform.submit();
			    //var fo = document.getElementsByName("myform");
				//fo[0].submit(); 
				alert("删除成功!");
			}
		} else {
			alert("请选中要操作的项");
		}
	}
	//导出excel
	function expolExcel() {
		var count = 0;
		var alls = document.getElementsByName("checkbox2");
		for ( var i = 0; i < alls.length; i++) {
			if (alls[i].checked) {
				count++;
			}
		}
		if (count > 0) {
			if (confirm("确认要导出吗?")) {
   			    document.getElementById("gansha").value = "export";
			    document.myform.submit();
				alert("导出成功!");
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

    //判断输入的跳转页码是否符合要求
    function jump(){
       
       var vpageText = document.getElementById("pageText").value;
       var viy_title=document.getElementById("iy_title").value;
	   var viy_updatetime=document.getElementById("iy_updatetime").value;
	   var viy_state = document.getElementById("iy_state").value;
       var totalpage = ${pi.totalpage};
       if(vpageText==null || vpageText.length==0){
           alert("请输入您要跳转的页码");
       }else if(window.isNaN(vpageText)){
           alert("请输入正确的数字页码");
       }else if(vpageText<=0 || vpageText>totalpage ){
           alert("您输入的页码范围不正确，请重新输入");
       }else{
           location.href="IndustryServlet?gansha=show&page="+vpageText+"&iy_title="+viy_title+"&iy_updatetime="+viy_updatetime+"&iy_state="+viy_state;
       }
       
    }
    
    //提交模糊查询的信息到后台
    function mohuSearch() {
    
        
	    var viy_title=document.getElementById("iy_title").value;
	    var viy_updatetime=document.getElementById("iy_updatetime").value;
	    var viy_state = document.getElementById("iy_state").value;
	    //检查
	    //alert(viy_title+" "+viy_updatetime+" "+viy_state);
	    window.location.href="IndustryServlet?gansha=mohuSearch&iy_title="+viy_title+"&iy_updatetime="+viy_updatetime+"&iy_state="+viy_state;
	}
	
	//单个删除提示
	function del(id) {
		if(!confirm('删除该信息？')){
		   return false;
		}else{
		   alert('删除成功！');
		   //alert(id);
		  window.location.href="IndustryServlet?gansha=delete&iy_id="+id;
		}
	}
	
	//异步请求修改状态，是否推荐
	function ajaxState(id) {
		var xhr = new XMLHttpRequest();
		xhr.open("get", "IndustryServlet?gansha=ajaxState&iy_id="+id,true);
	    xhr.send(null);
	}
    

</script>
</head>
<body>
  
	<table width="100%" height="100%" border="0" cellspacing="0"
		cellpadding="3" name="listTable">
		<tr>
			<td style="height: 25px; background-color: #f3f3f3; font-weight: bold" valign="top">&nbsp;&nbsp;&nbsp;&nbsp;
				<img src="houtai/images/arrow.gif" align="absmiddle">&nbsp;&nbsp;soda创业教育平台&nbsp;&nbsp;
				<img src="houtai/images/arrow.gif" align="absmiddle">&nbsp;&nbsp;后台管理&nbsp;&nbsp; 
				<img src="houtai/images/arrow.gif" align="absmiddle">&nbsp;&nbsp;行业介绍</td>
		</tr>
		<tr>
			<td  style="height: 34px; background-image: url(houtai/images/main_header.gif); border-bottom: 1px solid #cfd8e0; padding: 0px">
				<table width="100%" border="0" cellspacing="0" cellpadding="0" name="listTable2">
					<tr>
						<td width="20" height="34">
						    <img src="houtai/images/main_headerL.gif" width="20" height="34">
						</td>
						<td style="color: #90c8e8;">
						    <img src="${pageContext.request.contextPath }/houtai/images/icon_card.gif" width="16" height="16" align="absmiddle">&nbsp;&nbsp; <strong>行业介绍管理</strong>
						</td>
						<td align="right" class="white" style="padding-right: 20px">
							<a href="Javascript:expolExcel()" class="barBtn" name="export">
							<img src="${pageContext.request.contextPath }/houtai/images/1.png" width="16" height="16" align="absmiddle">导出 </a> 
							<a href="houtai/pages/publicityManage/classManage/add.jsp" class="barBtn" name="add"> 
							<img src="${pageContext.request.contextPath }/houtai/images/5.png" width="16" height="16" align="absmiddle"> 添加 </a> 
							<a href="Javascript:checkeDel()" class="barBtn" name="batchDelete">
							<img src="${pageContext.request.contextPath }/houtai/images/6.png" width="16" height="16" align="absmiddle"> 删除 </a>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td style="height: 30px; background-color: #bddbff; border-bottom: 1px solid #cfd8e0;">
			    <table width="100%" border="0" cellpadding="3" cellspacing="1"	class="table1" name="listTable3">
					<TR>
						<th width="10%" align="center">标题</th>
						<td width="20%" class="BGCgray"><input type="text"  value="${iy_title}"
							name="iy_title" id="iy_title"></td>
						<th width="10%" align="center">更新时间</th>
						<td width="20%" class="BGCgray">
						<input type="text" name="iy_updatetime"  class="Wdate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',readOnly:true})" id="iy_updatetime" value="${iy_updatetime }"></td>
						<%-- <input type="text"  value="${iy_updatetime }" name="iy_updatetime" id="iy_updatetime"></td> --%>
						<th width="10%" align="center">是否推荐</th>
						<td width="20%" class="BGCgray"><select name="iy_state" id="iy_state">
								<option <c:if test="${iy_state == '全部'}">selected="selected"</c:if>  >全部</option>
								<option <c:if test="${iy_state == '是'}">selected="selected"</c:if>  >是</option>
								<option <c:if test="${iy_state == '否'}">selected="selected"</c:if>  >否</option>
						</select></td>
						<th width="10%" align="center">
						<BUTTON  onclick="mohuSearch()" style="HEIGHT: 25px name="dimSelect">
					    	<img src="houtai/images/btn_search.gif" width="16" height="16" align="absmiddle"   > 查询
						</BUTTON>
						</th>
					</TR>
				</table></td>
		</tr>
		<tr>
			<td height="100%" valign="top">
				<div style="overflow: auto; height: 100%; width: 100%">
				
				<form action="IndustryServlet" method="post" name="myform" >
				 <input type="hidden" name="gansha" id="gansha" >
				 
					<table width="100%" border="0" cellpadding="3" cellspacing="1"
						class="table1" name="listTable4">
						<TR>
							<th align="center">
							    <input type="checkbox" name="checkbox1"	id="checkbox1" onChange="allCheck()">
							</th>
							<th align="center">ID</th>
							<th align="center">标题</th>
							<th align="center">更新日期</th>
							<th align="center">是否推荐</th>
							<th width="180" align="center">操作</th>
						</TR>


						<c:forEach items="${list}" var="i">

							<TR>
								<TD align="center">
								    <input type="checkbox" name="checkbox2" id="checkbox2" value="${i.iy_id}" >
								</TD>
								<TD align="center">${i.iy_id}</TD>
								<TD align="left">
								   <a href="IndustryServlet?gansha=look&iy_id=${i.iy_id}" style="color: black;">${i.iy_title }</a></TD>
								<TD align="center">${i.iy_updatetime }</TD>
								<TD align="center">
								   <input type="checkbox" name="checkbox3" id="checkbox3" onclick="ajaxState(${i.iy_id})"
									<c:if test="${i.iy_state==1 }">
							               checked="checked"
							        </c:if> />
								</TD>
								<TD width="180" align="center">
									<BUTTON style="height: 21px; font-size: 12px" onClick="javascript:location.href='IndustryServlet?gansha=look&iy_id=${i.iy_id}';return false;">查看</BUTTON>
									<BUTTON style="height: 21px; font-size: 12px" onClick="javascript:location.href='IndustryServlet?gansha=edit&iy_id=${i.iy_id}';return false;">编辑</BUTTON>
									<BUTTON style="height: 21px; font-size: 12px" onClick="del(${i.iy_id})"  type="button" >删除</BUTTON>
								</TD>
							</TR>
						</c:forEach>
					</table>
					</form>
					
					<table width="100%" border="0" cellspacing="0" cellpadding="0"
						name="listTable5">
						<tr>
							<td width="20%" height="25"><table border="0"
									cellspacing="0" cellpadding="3">
									<tr>
										<td style="width: 60px"></td>
										
										<c:if test="${pi.pagenum!=1 }">
										    <td style="width: 60px">
										    <a href="IndustryServlet?gansha=mohuSearch&page=1&iy_title=${iy_title}&iy_updatetime=${iy_updatetime}&iy_state=${iy_state}" name="pageFirst"  >
										    <span style="color: #000;">首页</span> </a></td>
										<td style="width: 60px">
										    <a href="IndustryServlet?gansha=mohuSearch&page=${pi.pagenum-1}&iy_title=${iy_title}&iy_updatetime=${iy_updatetime}&iy_state=${iy_state}" name="pageUp">
											<span style="color: #000;">上一页</span> </a></td>
										</c:if>
										
										<c:if test="${pi.pagenum==1 }">
										    <td style="width: 60px">
										       <span style="color: #aaa;">首页</span>
										    </td>
										    <td style="width: 60px">
											   <span style="color: #aaa;">上一页</span> 
										    </td>
										</c:if>
										
										 <c:forEach begin="1" end="${pi.totalpage}" var="index" >
										    <c:if test="${pi.pagenum-index<=2 && index-pi.pagenum<=2}">
										       <c:if test="${pi.pagenum!=index}">
										          <td style="width: 30px">
										          <a href="IndustryServlet?gansha=mohuSearch&page=${index}&iy_title=${iy_title}&iy_updatetime=${iy_updatetime}&iy_state=${iy_state}">
										          <span style="color: #000;">${index}</span> </a></td>
										       </c:if>
										    </c:if>
										 </c:forEach>
										
										
										<c:if test="${pi.pagenum!=pi.totalpage }">
									    	 <td style="width: 60px">
										     <a  href="IndustryServlet?gansha=mohuSearch&page=${pi.pagenum+1}&iy_title=${iy_title}&iy_updatetime=${iy_updatetime}&iy_state=${iy_state}"
											     name="pageNext"> <span style="color: #000;">下一页</span>
										     </a></td>
										    <td style="width: 60px">
										    <a href="IndustryServlet?gansha=mohuSearch&page=${pi.totalpage}&iy_title=${iy_title}&iy_updatetime=${iy_updatetime}&iy_state=${iy_state}" name="pageEnd">
											<span style="color: #000;">尾页</span></a></td>
									    </c:if>
									    
									    <c:if test="${pi.pagenum==pi.totalpage }">
									    	 <td style="width: 60px">
										        <span style="color: #aaa;">下一页</span>
										     </td>
										    <td style="width: 60px">
											    <span style="color: #aaa;">尾页</span>
											</td>
									    </c:if>
									    
									    </tr>
								</table></td>
							<td width="20%" align="center"><table border="0"
									cellspacing="0" cellpadding="3" name="listTable6">
									<tr>
										<td>
										    <a href="javascript:jump()" name="pageGo">
										    <img src="houtai/images/next.gif" width="16" height="16" border="0"> </a></td>
										<td><input id="pageText" name="pageText" type="text" size="3"	style="width: 25; height: 18"> 页</td>
									</tr>
								</table>
							</td>
							<td width="20%" align="right">共${pi.totalcount}条记录显示到${pi.pagenum}/${pi.totalpage }</td>
						</tr>
					</table>
				</div>
			</td>
		</tr>
	</table>
</body>
</html>
