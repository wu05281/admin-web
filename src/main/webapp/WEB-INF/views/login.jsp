<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="inc.jsp"></jsp:include>
<meta http-equiv="X-UA-Compatible" content="edge" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
<link href="${ctx}/style/login.css" type="text/css" rel="stylesheet" />
<script>

	var sessionInfo_userId = '${sessionInfo.id}';
	if (sessionInfo_userId) {//如果登录,直接跳转到index页面
		window.location.href='${ctx}/admin/index';
	}
		
	$(function() {
		
		$('#loginform').form({
		    url:'${ctx}/admin/login',
		    onSubmit : function() {
		    	progressLoad();
				var isValid = $(this).form('validate');
				if(!isValid){
					progressClose();
				}
				return isValid;
			},
		    success:function(result){
		    	result = $.parseJSON(result);
		    	progressClose();
		    	if (result.success) {
		    		window.location.href='${ctx}/admin/index';
		    	}else{
		    		$.messager.show({
		    			title:'提示',
		    			msg:'<div class="light-info"><div class="light-tip icon-tip"></div><div>'+result.msg+'</div></div>',
		    			showType:'show'
		    		});
		    	}
		    }
		});
	});
	function submitForm(){
		if($("#loginname").val()==''||$("#password").val()==''){
			$.messager.show({
    			title:'提示',
    			msg:'<div class="light-info"><div class="light-tip icon-tip"></div><div>用户名或密码不能为空</div></div>',
    			showType:'show'
    		});
			return false;
		}
		$('#loginform').submit();
	}
	
	function clearForm(){
		$('#loginform').form('clear');
	}
</script>
</head>
<body id="userlogin_body">

<div id="user_login">
	<dl>
		<dd id="user_top">
			<ul>
				<li class="user_top_l"></li>
				<li class="user_top_c"></li>
				<li class="user_top_r"></li>
			</ul>
		</dd>
		<dd id="user_main">
			<ul>
				<li class="user_main_l"></li>
				<li class="user_main_c">
					<div class="user_main_box">
					  <form id="loginform"  method="post">
						<ul>
							<li class="user_main_text">用户名： </li>
							<li class="user_main_input"><input name="loginname" maxlength="20" id="loginname" value="admin" placeholder="请输入用户名" class="txtusernamecssclass"> </li>
						</ul>
						<ul>
							<li class="user_main_text">密 码： </li>
							<li class="user_main_input"><input type="password" name="password" id="password" class="txtpasswordcssclass" placeholder="请输入密码" value="admin"> </li>
						</ul>
						<ul>
							<li class="user_main_text">Cookie： </li>
							<li class="user_main_input"><select name="DropExpiration" id="DropExpiration"> 
							<option selected="" value="None">不保存</option> <option value="Day">保存一天</option> 
							<option value="Month">保存一月</option> <option value="Year">保存一年</option></select> </li>
						</ul>
						</form>
					</div>
				</li>
				<li class="user_main_r"><img alt="" src="${ctx }/style/images/login/user_botton.gif" class="ibtnentercssclass" onclick="submitForm()"></li>
			</ul>
		</dd>
		<dd id="user_bottom">
			<ul>
				<li class="user_bottom_l"></li>
				<li class="user_bottom_c"></li>
				<li class="user_bottom_r"></li>
			</ul>
		</dd>
	</dl>
</div>


</body>
</html>