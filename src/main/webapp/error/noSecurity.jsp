<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<jsp:include page="inc.jsp"></jsp:include>
var a =${msg};
$.messager.alert('提示', a, 'info');