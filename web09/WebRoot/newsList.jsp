<%@page import="com.bdqn.zmj.service.NewsSerice"%>
<%@page import="com.bdqn.zmj.entity.News"%>
<%@page import="com.bdqn.zmj.util.Page"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style>
#content {
	text-align: center;
	width: 800px;
	margin: 40px auto;
}

#content {
	width: 800px;
	border-collapse: collapse;
}
</style>
</head>
<body>
	<%
		Page<News> p = (Page<News>)request.getAttribute("p");
		if(p==null){
		//第一次访问该页面的时候request是没有p的
		//然后默认查询第一页
		NewsSerice service = new NewsSerice();
		p = service.getList(1,5);
		}	
	%>
	<div id="content">
		<table>
			<tr>
				<th>编号</th>
				<th>标题</th>
				<th>作者</th>
				<th>日期</th>
			</tr>
			<%
				for(News n:p.getData()){
			%>
			<tr>
				<td><%=n.getNid()%></td>
				<td><%=n.getNtitle()%></td>
				<td><%=n.getNauthor()%></td>
				<td><%=n.getNcreatedate()%></td>
			</tr>
			<%
				}
			%>
		</table>
		<p>
			总共<%=p.getTotal()%>条 当前[<%=p.getCurrentPage()%>/<%=p.getTotalPage()%>]
			<a href="doPage.jsp">首页</a>
			<a href="doPage.jsp?cur=<%=p.getCurrentPage()-1%>"onclick=" return val(1)">上一页</a>
			<a href="doPage.jsp?cur=<%=p.getCurrentPage()+1%>"onclick=" return val(2)">下一页</a> 
			<a href="doPage.jsp">尾页</a>
	</div>
	<script>
		function val(type) {
			var cur ="${p.getCurrentPage()}";//获取当前页面
			var totalPage ="${p.getTotalPage()}";//获取总页数
			if (cur =="") {
				cur = 1
			}
			if (type == 1) {
				if (cur == 1) {
					alert("已经是第一页了");
					return false;
				}
			} else {
				if (cur == totalPage) {
					alert("已经是最后一页了");
					return false;
				}
			}
		}
	</script>
</body>
</html>
