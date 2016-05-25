<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/inc.jsp" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
<script type="text/javascript">
        $(function () {
        	var msg='${msg}';
            $.messager.alert("操作提示", msg, "warning", function () {
                setTimeout("parent.location.href='${ctx}/admin/index'",1000);
            });
        });
    </script> 
<script type="text/javascript" charset="utf-8">

	//
</script>
</head>
</html>