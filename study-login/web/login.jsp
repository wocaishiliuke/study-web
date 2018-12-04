<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.baicai.util.CookieUtils"%>
<html>
<head>
    <title>login</title>
</head>
<body>
    <%
        //获取cookie中的用户名
        String username = CookieUtils.getCookieValueByName(request.getCookies(), "username");
    %>

    <form action="/login/loginServlet" method="post">
        <div style="color: red">${requestScope.errorMsg}</div>
        <table>
            <tr>
                <td>用户名：</td>
                <td><input type="text" name="username" value="<%= username == null ? "" : username%>"></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="登录"></td>
            </tr>
        </table>
    </form>
</body>
</html>
