<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.news.service.NewsService" %>
<%@ page import="com.news.service.impl.NewsServiceImpl" %>
<%@ page import="com.news.entity.News" %>
<%@ page import="com.news.service.CommentService" %>
<%@ page import="com.news.service.impl.CommentServiceImpl" %>
<%@ page import="com.news.entity.Comment" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新闻中国</title>
<link href="../css/read.css" rel="stylesheet" type="text/css" />

</head>
<body>
	<div id="header">
		<div id="top_login">
			<label> 登录名 </label> <input type="text" id="uname" value=""
				class="login_input" /> <label> 密&#160;&#160;码 </label> <input
				type="password" id="upwd" value="" class="login_input" /> <input
				type="button" class="login_sub" value="登录" onclick="login()" /> <label
				id="error"> </label> <a href="../index.jsp" class="login_link">返回首页</a>
			<img src="../images/friend_logo.gif" alt="Google" id="friend_logo" />
		</div>
		<div id="nav">
			<div id="logo">
				<img src="../images/logo.jpg" alt="新闻中国" />
			</div>
			<div id="a_b01">
				<img src="../images/a_b01.gif" alt="" />
			</div>
			<!--mainnav end-->
		</div>
	</div>
	<div id="container">
		<div class="sidebar">
			<h1>
				<img src="../images/title_1.gif" alt="国内新闻" />
			</h1>
			<div class="side_list">
				<ul>
					<li><a href='#'><b> 重庆涉黑富豪黎强夫妇庭审答辩言辞相互矛盾 </b>
					</a></li>
					<li><a href='#'><b> 发改委：4万亿投资计划不会挤占民间投资空间 </b>
					</a></li>
					<li><a href='#'><b> 河南2个乡镇政绩报告内容完全一致引关注 </b>
					</a></li>
				</ul>
			</div>
			<h1>
				<img src="../images/title_2.gif" alt="国际新闻" />
			</h1>
			<div class="side_list">
				<ul>
					<li><a href='#'><b> 日本首相鸠山首次全面阐述新政府外交政策 </b>
					</a></li>
					<li><a href='#'><b> 黎巴嫩以色列再次交火互射炮弹 </b>
					</a></li>
					<li><a href='#'><b> 伊朗将于30日前就核燃料供应方案作出答复 </b>
					</a></li>
					<li><a href='#'><b> 与基地有关组织宣称对巴格达连环爆炸负责 </b>
					</a></li>
				</ul>
			</div>
			<h1>
				<img src="../images/title_3.gif" alt="娱乐新闻" />
			</h1>
			<div class="side_list">
				<ul>
					<li><a href='#'><b> 施瓦辛格启动影视业回迁计划 推进加州经济复苏 </b>
					</a></li>
					<li><a href='#'><b> 《沧海》导演回应观众质疑 自信能超越《亮剑》 </b>
					</a></li>
					<li><a href='#'><b> 《海角七号》导演新片开机 吴宇森等出席 </b>
					</a></li>
					<li><a href='#'><b> 《四大名捕》敦煌热拍 八主演飙戏火花四溅 </b>
					</a></li>
				</ul>
			</div>
		</div>
		<div class="main">
			<div class="class_type">
				<img src="../images/class_type.gif" alt="新闻中心" />
			</div>
			<div class="content">
				<ul class="classlist">
					<table width="80%" align="center">
						<tr width="100%">
							<td colspan="2" align="center">${news.ntitle}</td>
						</tr>
						<tr>
							<td colspan="2"><hr /></td>
						</tr>
						<tr>
							<td align="center">${news.ncreateDate}</td>
							<td align="left">${news.topic.tname}</td>
						</tr>
						<tr>
							<td colspan="2" align="center"></td>
						</tr>
						<tr>
							<td colspan="2">${news.ncontent}</td>
						</tr>
						<tr>
							<td colspan="2"><hr /></td>
						</tr>
					</table>
				</ul>
				<ul class="classlist">
					<table width="80%" align="center">
						<c:if test="${empty comments}">
						<tr><td colspan="6">暂无评论！</td></tr>
						</c:if>
						<c:forEach items="${comments}" var="comment">
						<tr><td colspan="6">${comment.ccontent}</td></tr>
						</c:forEach>
						<tr>
							<td colspan="6"><hr /></td>
						</tr>
					</table>
				</ul>
				<ul class="classlist">
					<form action="#" method="post">
						<table width="80%" align="center">
							<tr>
								<td>评 论</td>
							</tr>
							<tr>
								<td>用户名：</td>
								<td><input id="cauthor" name="cauthor" value="这家伙很懒什么也没留下" />
									IP： <input name="cip" value="127.0.0.1" readonly="readonly" />
								</td>
							</tr>
							<tr>
								<td colspan="2"><textarea name="ccontent" cols="70"
										rows="10"></textarea></td>
							</tr>
							<tr>
							<td><input name="submit" value="发  表" type="submit" /></td>
							</tr>
						</table>
					</form>
				</ul>
			</div>
		</div>
	</div>
	<%@include file="../index-elements/index_bottom.jsp"%>
</body>
</html>
