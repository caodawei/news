<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加主题--管理后台</title>
<link href="../css/admin.css" rel="stylesheet" type="text/css" />
  <script src="/ckeditor/ckeditor.js"></script>
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
  <div id="status">管理员： 登录  &#160;&#160;&#160;&#160;<a href="#">login out</a></div>
  <div id="channel"> </div>
</div>
<div id="main">
  <%@include file="console_element/left.jsp" %>
  <div id="opt_area">
    <h1 id="opt_type"> 添加新闻： </h1>
    <form action="/admin/news?action=save" enctype="multipart/form-data" method="post">
      <input type="hidden" name="nid" value="${news.nid}"/>
      <p>
        <label> 主题 </label>
        <select name="ntid">
          <c:forEach items="${topics}" var="topic">
          <option <c:if test="${topic.tid==news.ntid}">selected</c:if>  value="${topic.tid}">${topic.tname}</option>
          </c:forEach>
        </select>
      </p>
      <p>
        <label> 标题 </label>
        <input name="ntitle" type="text" class="opt_input" value="${news.ntitle}"/>
      </p>
      <p>
        <label> 作者 </label>
        <input name="nauthor" type="text" class="opt_input" value="${news.nauthor}" />
      </p>
      <p>
        <label> 摘要 </label>
        <textarea class="ckeditor" name="nsummary" cols="40" rows="3">
          ${news.nsummary}</textarea>
      </p>
      <p>
        <label> 内容 </label>
        <textarea class="ckeditor" name="ncontent" cols="70" rows="10" >
          ${news.ncontent}
        </textarea>
      </p>
      <p>
        <label> 上传图片 </label>
        <input name="file" type="file" class="opt_input" />
      </p>
      <input name="action" type="hidden" value="addnews"/>
      <input type="submit" value="提交" class="opt_sub" />
      <input type="reset" value="重置" class="opt_sub" />
    </form>
  </div>
</div>
<div id="footer">
  <%@include file="console_element/bottom.jsp" %>
</div>
</body>
</html>
