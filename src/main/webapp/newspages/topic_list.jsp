<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加主题--管理后台</title>
<link href="../css/admin.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="header">
  <div id="welcome">
    欢迎使用新闻管理系统！</div>
  <div id="nav">
    <div id="logo"><img src="../images/logo.jpg" alt="新闻中国" /></div>
    <div id="a_b01"><img src="../images/a_b01.gif" alt="" /></div>
  </div>
</div>
<div id="admin_bar">
  <div id="status">管理员： 登录  &#160;&#160;&#160;&#160; <a href="newspage/login.jsp?action=loginout">login out</a></div>
  <div id="channel"> </div>
</div>
<div id="main">
  <%@include file="console_element/left.jsp" %>
  <div id="opt_area">
    <ul class="classlist">
     
<%--      <li> &#160;&#160;&#160;&#160; 桭顶棚 &#160;&#160;&#160;&#160; <a href='#'>修改</a> &#160;&#160;&#160;&#160; <a href='#'>删除</a> </li>--%>
<%--           <li> &#160;&#160;&#160;&#160; 桭顶棚  &#160;&#160;&#160;&#160; <a href='#'>修改</a> &#160;&#160;&#160;&#160; <a href='#'>删除</a> </li>--%>
<%--           <li> &#160;&#160;&#160;&#160; 桭顶棚  &#160;&#160;&#160;&#160; <a href='#'>修改</a> &#160;&#160;&#160;&#160; <a href='#'>删除</a> </li>--%>
<%--           <li> &#160;&#160;&#160;&#160; 桭顶棚  &#160;&#160;&#160;&#160; <a href='#'>修改</a> &#160;&#160;&#160;&#160; <a href='#'>删除</a> </li>--%>
<%--           <li> &#160;&#160;&#160;&#160; 桭顶棚  &#160;&#160;&#160;&#160; <a href='#'>修改</a> &#160;&#160;&#160;&#160; <a href='#'>删除</a> </li>--%>
     
    </ul>
  </div>
</div>
<div id="footer">
  <%@include file="console_element/bottom.jsp" %>
</div>
</body>
<script src="/js/jquery-1.12.4.js"></script>
<script>
    $(function () {
        $.getJSON({
           url:"/admin/topic",
            success:function (res,txt,obj) {
                var $ul=$("ul.classlist");
                for(var i=0;i<res.length;i++){
                    // var str=res[i].tid+","+res[i].tname;
                var $li=$("<li></li>");
                $li.html(res[i].tname);
                var $a=$("<a>修改</a>");
                $a.attr("href","/admin/topic?action=edit&tid="+res[i].tid);
                $li.append($a);
                  $a=$("<a>删除</a>");
                  $a.attr("href","/admin/topic?action=delt&id="+res[i].tid);
                  $li.append($a);
                $ul.append($li);
                }
            }
        });
    });
</script>
</html>
