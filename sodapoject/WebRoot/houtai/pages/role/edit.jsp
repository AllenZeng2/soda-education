<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="houtai/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="houtai/js/main.js"></script>

<script type="text/javascript">

	var aj=false;
	//编辑
	function edit(id){
		if(aj&&confirm("确认修改?")){
		document.getElementById("param").value="edit";
		document.getElementById("re_id").value=id;
		document.myform.submit();	
		}
	}
	
	//判断重名
	var xhr;
	function ckname(id){
	
		var vname=document.getElementById("role_name").value;
		//var vid=document.getElementById("re_id").value=id;
		xhr=new XMLHttpRequest();
		xhr.onreadystatechange=error;
		xhr.open("get", "RoleServlet?param=editSame&reid="+id+"&name="+vname, true);
		xhr.send(null);
	}
	function error(){
		aj=true;
		if(xhr.readyState==4&&xhr.status==200){
			var tx=xhr.responseText;
			var aa="fail";
			if(tx=="fail"){
				aj=false;
				document.getElementById("ckn").innerHTML="名字不能为空或已存在";
			}else{
				document.getElementById("ckn").innerHTML="";
		}
	}
	}
	
	
	
		//复选框
		function checkif(ck,num){
		//alert(111);
		var alls;
		var conterCheck;
		if(num==1){
			alls=document.getElementsByName("checkbox11");
			conterCheck=document.getElementById("checkbox1");
		}else if(num==2){
			alls=document.getElementsByName("checkbox21");
			conterCheck=document.getElementById("checkbox2");
		}else if(num==3){
			alls=document.getElementsByName("checkbox31");
			conterCheck=document.getElementById("checkbox3");
		}else if(num==4){
			alls=document.getElementsByName("checkbox41");
			conterCheck=document.getElementById("checkbox4");
		}

		for(var i=0;i<alls.length;i++){
			
			if(conterCheck.checked){
				alls[i].checked=true;
			}else{
				alls[i].checked=false;
			}
		}
	  }
	  
	  //当子菜单没有选中时,父级菜单取消
	  function cancel(num){
			//alert(111);
		  var alls;
		  var conterCheck;
		  if(num==1){
				alls=document.getElementsByName("checkbox11");
				conterCheck=document.getElementById("checkbox1");
			}else if(num==2){
				alls=document.getElementsByName("checkbox21");
				conterCheck=document.getElementById("checkbox2");
			}else if(num==3){
				alls=document.getElementsByName("checkbox31");
				conterCheck=document.getElementById("checkbox3");
			}else if(num==4){
				alls=document.getElementsByName("checkbox41");
				conterCheck=document.getElementById("checkbox4");
			}
			
			for(var i=0;i<alls.length;i++){
				if(alls[i].checked)
					return;		
			}
			conterCheck.checked=false;
	  }
	  /* 
	  function init(){
	  	var fmenus="${role.fmenu}";
	 	var menus="${role.menus}";
	  	
	  	for(var i=0;i<fmenus.length;i++){
	  		if(fmenus[i]==1){
				document.getElementById("checkbox1").checked="checked";	
							break;
			}
	  	}
	  	for(var i=0;i<fmenus.length;i++){
	  		if(fmenus[i]==4){
				document.getElementById("checkbox2").checked="checked";	
							break;
			}
	  	}
	  	for(var i=0;i<fmenus.length;i++){
	  		if(fmenus[i]==5){
				document.getElementById("checkbox3").checked="checked";	
							break;
			}
	  	}
	  	for(var i=0;i<fmenus.length;i++){
	  		if(fmenus[i]==6){
				document.getElementById("checkbox4").checked="checked";	
							break;
			}
	  	}
	  	for(var j=0;j<menus.length;j++){
					alert(menus[j]);
					if(menus[j]==2)
					document.getElementById("checkbox12").checked="checked";
					if(menus[j]==4)
					document.getElementById("checkbox14").checked="checked";
					if(menus[j]==5)
					document.getElementById("checkbox15").checked="checked";
					if(menus[j]==6)
					document.getElementById("checkbox16").checked="checked";
					if(menus[j]==7)
					document.getElementById("checkbox17").checked="checked";
					if(menus[j]==8)
					document.getElementById("checkbox18").checked="checked";
					if(menus[j]==9)
					document.getElementById("checkbox19").checked="checked";
					if(menus[j]==3)
					document.getElementById("checkbox13").checked="checked";
				}
	  	*/
	  //} 
	  
	  
	onload=init;
	
	
</script>

</head>
<body>
<form name="myform" action="${pageContext.request.contextPath }/RoleServlet" method="post">
<table width="100%" height="100%" border="0" cellspacing="0" cellpadding="3" name="editTable">
  <tr>
    <td style="height:25px; background-color:#f3f3f3; font-weight:bold" valign="top">&nbsp;&nbsp;&nbsp;&nbsp;当前位置： 
    <img src="houtai/images/arrow.gif" align="absmiddle">&nbsp;&nbsp;soda创业教育平台&nbsp;&nbsp;
    <img src="houtai/images/arrow.gif" align="absmiddle">&nbsp;&nbsp;后台管理&nbsp;&nbsp;
    <img src="houtai/images/arrow.gif" align="absmiddle">&nbsp;&nbsp;角色管理
    </td>
  </tr>
  <tr>
    <td style="height:34px; background-image:url(houtai/images/main_header.gif); border-bottom:1px solid #cfd8e0; padding:0px">
      <table width="100%" border="0" cellspacing="0" cellpadding="0" name="editTable2">
        <tr>
          <td width="20" height="34"><img src="houtai/images/main_headerL.gif" width="20" height="34"></td>
          <td style="color:#90c8e8;"><img src="houtai/images/icon_card.gif" width="16" height="16" align="absmiddle">&nbsp;&nbsp;<strong>修改角色信息</strong></td>
          <td align="right" class="white" style="padding-right:20px">
          <a href="javascript:history.go(-1);" class="barBtn" onClick="javascript:history.go(-1);" name="retreat"><img src="houtai/images/btn_left.gif" align="absmiddle"> 后退</a>
          <a href="javascript:history.go(+1);" class="barBtn" onClick="javascript:history.go(+1);" name="advance"><img src="houtai/images/btn_right.gif" align="absmiddle"> 前进</a>
          <a href="javascript:location.reload();" class="barBtn" name="flush" ><img src="houtai/images/btn_refresh.gif" align="absmiddle"> 刷新</a>
          </td>
        </tr>
    </table></td>
  </tr>
  <tr>
    <td height="100%" valign="top">
    <div style="overflow:auto;height:100%; width:100%">
      <table width="100%" border="0" cellpadding="3" cellspacing="1" class="table1" name="editTable3" >
        <TR>
          <th width="20%" align="center">角色名</th>
          <TD class="BGCgray"><input type="text" 
           onblur="ckname(${role.re_id})"
           id="role_name"
          value="${role.re_name }" name="ro_name"/>
           <span id="ckn" style="color: red" ></span>
          </TD>
        </TR>
      					   <!--隐藏param  -->
							<input type="hidden" name="param" id="param" />
							<input type="hidden" name="page" id="page"/>
							<input type="hidden" name="re_id" id="re_id"/>
							<input type="hidden" name="num" id="num"/>
							<!--隐藏param  -->
							
							
       <TR>
          <th align="center">对应菜单</th>
          <TD class="BGCgray">
          
			<ul>
			
			<c:forEach items="${fms }" var ="fm">
			<li><input type="checkbox" value="${fm.fmen_id }" 
            					name="checkbox"
								id="checkbox1"
            	/>${fm.fme_name }
                	<ul>
                	<c:forEach items="${fm.menu }" var ="m">
                   	<li><input 
                   	
					id="checkbox11" 
                   	name="checkbox11" type="checkbox"
					value="${m.mu_id }" />${m.mu_name }</li>
        	    	
                   </c:forEach>
                    </ul>
                    
                </li>
			
			
			
			</c:forEach>

  				<!--
  				
  				 <li><input type="checkbox" value="1" 
            					name="checkbox"
								id="checkbox1"
								onclick="checkif(this.checked,1)"
            	/>系统管理
                	<ul>
                   	<li><input onclick="cancel(1)" id="checkbox12" name="checkbox11" type="checkbox" value="2" />新闻管理</li>
        	    	<li><input onclick="cancel(1)" id="checkbox13" name="checkbox11" type="checkbox" value="3" />公告管理</li>
					<li><input onclick="cancel(1)" id="checkbox14" name="checkbox11" type="checkbox" value="4" />资讯管理</li>
					
						<li><input onclick="cancel(1)" id="checkbox15" name="checkbox11" type="checkbox" value="5" />行业介绍</li>
        	    	<li><input onclick="cancel(1)" id="checkbox16" name="checkbox11" type="checkbox" value="6" />概况管理</li>
					<li><input onclick="cancel(1)" id="checkbox17" name="checkbox11" type="checkbox" value="7" />关于我们</li>
						<li><input onclick="cancel(1)" id="checkbox18" name="checkbox11" type="checkbox" value="8" />版权声明</li>
        	    	<li><input onclick="cancel(1)" id="checkbox19" name="checkbox11" type="checkbox" value="9" />联系我们</li>
	
                    </ul>
                 </li>
                <li><input type="checkbox" value="4" name="checkbox"
                			id="checkbox2"
                			onclick="checkif(this.checked,2)"
                />权限管理
                	<ul>
                   	<li><input onclick="cancel(2)" id="checkbox25" name="checkbox21" type="checkbox" value="15" />角色管理</li>
        	    	<li><input onclick="cancel(2)" id="checkbox24" name="checkbox21" type="checkbox" value="14" />人员管理</li>
					<li><input onclick="cancel(2)" id="checkbox26" name="checkbox21" type="checkbox" value="16" />菜单管理</li>
                    </ul>
                </li> 
                <li><input type="checkbox" value="5" name="checkbox"
                			id="checkbox3"
                			onclick="checkif(this.checked,3)"
                />课程管理
                
                	<ul>
                   	<li><input onclick="cancel(3)" id="checkbox31" name="checkbox31" type="checkbox" value="11" />课程管理</li>
        	    	<li><input onclick="cancel(3)" id="checkbox32" name="checkbox31" type="checkbox" value="12" />学生管理</li>
					
                    </ul>
                </li>
                
                
                <li><input type="checkbox" value="6" name="checkbox"
                			id="checkbox4"
                			onclick="checkif(this.checked,4)"
                />个人信息管理
                
                	<ul>
                   	<li><input onclick="cancel(4)" name="checkbox48" type="checkbox" value="18" />修改密码</li>
        	    	<li><input onclick="cancel(4)" name="checkbox49" type="checkbox" value="19" />个人信息</li>
					
                    </ul>
                </li> 
                
                -->

            </ul>
            
          
             
          </TD>
        </TR>
         <TR>
          <th align="center">启用状态</th>
          <TD class="BGCgray">
          <input type="radio" checked="checked" value="1" name="ro_state" />启用
          <input type="radio" value="0" name="ro_state" />禁用
          </TD>
        </TR>
        <TR>
          <th align="center"><span class="BGCgray">备注</span></th>
          <TD class="BGCgray">
          	<textarea name="ro_remark">暂无
            </textarea>
          </TD>
        </TR>
      </table>
      <div style="width:100%; text-align:center; padding:5px">
        <BUTTON style="HEIGHT:25px" onClick="edit(${role.re_id});return false;" 
        name="submit"><img src="houtai/images/btn_edit.gif" width="16" height="16"
         align="absmiddle"> 修改</BUTTON>
         
         <BUTTON style="HEIGHT:25px" onClick="javascript:if (confirm('您填写的信息还未保存，确认返回么？')) history.go(-1);else return false;" name="back" >
         <img src="houtai/images/btn_back.gif" width="16" height="16" align="absmiddle"> 返回</BUTTON>
      </div>
    </div>
  </td>
  </tr>
</table>
</form>
</body>
</html>