<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.baicai.util.CookieUtils"%>
<html>
<head>
    <title>login</title>
    <style type="text/css">
        table {
            margin: 50px auto;
            border: 1px solid red;
            width: 600px;
            height: 150px;
        }

        td {
            padding: 10px;
        }
    </style>
    <script type="text/javascript">
        /* 刷新验证码 */
        function changeImg() {
            document.getElementById("checkCode").src = "/login/checkCode?" + new Date().getMilliseconds();
        }
    </script>
</head>
<body>
    <%
        //获取cookie中的用户名（只有登录成功过，且未过期，才回显用户名）
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
                <td>验证码</td>
                <td>
                    <input type="text" name="form_checkCode">
                    <img id="checkCode" src="/login/checkCode" onclick="changeImg()">
                    <a href="javascript:void(0)" onclick="changeImg()">看不清，换一张</a>
                </td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="登录"></td>
            </tr>
        </table>
    </form>
</body>
</html>
