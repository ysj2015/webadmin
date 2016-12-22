<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html style="height:100%">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css">
*{padding:0px;margin:0px;}
html,body{width:100%;height:100%;}
.left{position:absolute;top:66px;width:212px;left:0px;bottom:0px;z-index:7;}
.left{*height:100%;*top:0;*bottom:0;*border-top:66px solid #FFF;*border-bottom:0px solid #FFF;*z-index:1;}
.right{position:absolute;right:0;left:212px;top:66px;bottom:0px;z-index:7;float:left}
.right{*height:100%;*top:0;*bottom:0;*border-top:66px solid #FFF;*border-bottom:0px solid #FFF;*z-index:1;}
.menu{height:100%;}
.menu iframe{height:100%;width:99.99%;z-index:20;}
.main{height:100%;}
.main iframe{height:100%;width:99.99%;z-index:20;}
</style>
</head>
<body>
aaaaaaa
<div class="left">
	<div class="menu">
	<iframe frameborder="0" src="success.jsp" 
		name="leftFrame" id="leftFrame" title="leftFrame"></iframe>
	</div>
</div>
<div class="right">
<div class="main">
	<iframe frameborder="0" src="error.jsp"
		name="rightFrame" id="rightFrame" title="rightFrame"></iframe>
</div>
</div>				
<jsp:include page="foot.jsp"></jsp:include>