<%@page import="com.bdqn.zmj.entity.News"%>
<%@page import="com.bdqn.zmj.util.Page"%>
<%@page import="com.bdqn.zmj.service.NewsSerice"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title></title>
</head>
<body>
	<%
  int cur = Integer.parseInt(request.getParameter("cur"));
  NewsSerice service = new NewsSerice();
	Page<News> p = service.getList(cur,5);
	//跳转页面
	request.setAttribute("p",p);
	request.getRequestDispatcher("newsList.jsp").forward(request, response);
   %>
</body>
</html>
