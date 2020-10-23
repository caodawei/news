<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<title>添加主题--管理后台</title>
<link href="../css/admin.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="header">
  <div id="welcome">欢迎使用新闻管理系统！</div>
  <div id="nav">
    <div id="logo"><img src="../images/logo.jpg" alt="新闻中国" /></div>
    <div id="a_b01"><img src="../images/a_b01.gif" alt="" /></div>
  </div>
</div>
<div id="admin_bar">
  <div id="status">管理员： 登录  &#160;&#160;&#160;&#160; <a href="#">login out</a></div>
  <div id="channel"> </div>
</div>
<div id="main">
  <%@include file="console_element/left.jsp" %>
  <div id="opt_area">    

    <ul class="classlist">
        <c:forEach items="${newsList}" var="news" varStatus="status">
	     <li>${news.ntitle}<span> ${news.nauthor}&#160;&#160;&#160;&#160; <a href='/admin/news?action=edit&nid=${news.nid}'>修改</a> &#160;&#160;&#160;&#160; <a href='/admin/news?action=del&nid=${news.nid}'>删除</a> </span> </li>
	     <c:if test="${status.index%5==4}">
	      <li class='space'></li>
         </c:if>
        </c:forEach>

        <p align="right"> 当前页数:[${pager.currentPage}/${pager.totalPages}]&nbsp;
            <c:if test="${pager.currentPage>1}">
                <a href="/admin/news?page=1${qs}">第一页</a>
                <a href="/admin/news?page=${pager.previousPage}${qs}">上一页</a>
            </c:if>
            <c:if test="${pager.currentPage<pager.totalPages}">
                <a href="/admin/news?page=${pager.nextPage}${qs}">下一页</a>
                <a href="/admin/news?page=${pager.lastPage}${qs}">末页</a>
            </c:if>
        </p>
    </ul>
  </div>
</div>
<div id="footer">
  <%@include file="console_element/bottom.jsp" %>
</div>
</body>
</html>
