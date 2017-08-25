<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="houtai/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="houtai/js/main.js"></script>


<script type="text/javascript">
  
   function check(){
   
     var vct_phone = document.getElementById("ct_phone").value;
     var vct_content = document.getElementById("ct_content").value;
     
     //alert(vct_phone);
     //alert(vct_content);
     var reg = /^1\d{10}$/;
     if(vct_phone==null || vct_phone.length==0){
        alert("联系电话不能为空");
        return false;
     }else if(!reg.test(vct_phone)){
          alert("联系电话格式不正确");
          return false;
     }else if(vct_content==null || vct_content.length==0){
        alert("内容不能为空");
        return false;
     }else if(vct_content.length>=255){
        alert("内容过长");
        return false;
     }else{
         if(confirm("确认提交？")){
            alert("提交成功");
            return true;
         }
     }    
   }
  
</script>

</head>
<body>
	<table width="100%" height="100%" border="0" cellspacing="0"
		cellpadding="3" name="surveyTable">
		<tr>
			<td
				style="height: 25px; background-color: #f3f3f3; font-weight: bold"
				valign="top">&nbsp;&nbsp;&nbsp;&nbsp;当前位置： <img
				src="houtai/images/arrow.gif" align="absmiddle">&nbsp;&nbsp;soda创业教育平台&nbsp;&nbsp;
				<img src="houtai/images/arrow.gif" align="absmiddle">&nbsp;&nbsp;后台管理&nbsp;&nbsp;
				<img src="houtai/images/arrow.gif" align="absmiddle">&nbsp;&nbsp;单页管理
			</td>
		</tr>
		<tr>
			<td
				style="height: 34px; background-image: url(houtai/images/main_header.gif); border-bottom: 1px solid #cfd8e0; padding: 0px">
				<table width="100%" border="0" cellspacing="0" cellpadding="0"
					name="surveyTable2">
					<tr>
						<td width="20" height="34"><img
							src="houtai/images/main_headerL.gif" width="20" height="34"></td>
						<td style="color: #90c8e8;"><img
							src="houtai/images/icon_card.gif" width="16" height="16"
							align="absmiddle">&nbsp;&nbsp; <strong>联系我们</strong></td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td height="100%" valign="top">
				<div style="overflow: auto; height: 100%; width: 100%">
				
					<form action="ContactServlet?gansha=update" method="post" name="surveyform" onsubmit="return check()" >
						<table width="100%" border="0" cellpadding="3" cellspacing="1"
							class="table1" name="surveyTable3">
							<tr>
								<td style="text-align: right">标题</td>
								<td>${contact.ct_title}</td>
							</tr>
							<tr>
								<td style="text-align: right">操作人</td>
								<td>${contact.ct_other}</td>
							</tr>
							<tr>
								<td style="text-align: right">联系电话</td>
								<td><input type="text" id="ct_phone" name="ct_phone" value="${contact.ct_phone}" /></td>
							</tr>
							<tr>
								<td style="text-align: right">内容</td>
								<td><textarea rows="15" cols="52" id="ct_content" name="ct_content">${contact.ct_content }</textarea></td>
							</tr>
							<tr>
								<td style="text-align: right"></td>
								<td><input type="submit" value="提交" name="submit"></td>
							</tr>
						</table>
					</form>
				</div>
			</td>
		</tr>
	</table>
</body>
</html>