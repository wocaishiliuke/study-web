<%@ page import="com.baicai.pojo.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Insert title here</title>
</head>
<body>
  <%-- JSP中，从Session中获取用户名 --%>
  <marquee>欢迎<%=((User) session.getAttribute("user")).getUsername() %>，登录成功!</marquee>
  <marquee>欢迎${sessionScope.user.username}，登录成功!</marquee>
</body>
</html>
