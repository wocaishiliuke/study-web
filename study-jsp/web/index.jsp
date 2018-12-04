<%--<%@ page pageEncoding="UTF-8" import="java.util.*" language="java" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>hello jsp</title>
  </head>
  <body>
    hello jsp!
    <br/>

    <%-- 脚本声明 --%>
    <%!
      int x = 1;
      String s ="test";
      class Inner {}
    %>

    <%-- 脚本片段 --%>
    <%
        request.setAttribute("key", "测试中文1");
        request.setAttribute("key2", "");
    %>

    <%-- 脚本表达式 --%>
    <%="哈哈哈1"%><br/>
    <%=x %><br/>
    <%=s.substring(0,3) %><br/>
    <%=true %><br/>
    <%=request.getAttribute("key") %><br/>

    <%-- 脚本片段和脚本表达式混用 --%>
    <%
      for (int i = 0; i < 3; i++) {
    %>
    <h3><%=i %></h3>
    <%
      }
    %>

    <%-- EL表达式 --%>
    key对应值: ${requestScope.key}<br/>

    <%-- 取不到值时，脚本表达式和EL的区别 --%>
    脚本表达式：<%=request.getAttribute("y") %><br/>
    EL：${requestScope.y}

    empty？：${empty requestScope.key}<br/>
    ==null？：${requestScope.key == null}<br/>
    empty？：${empty requestScope.key2}<br/>
    ==null？：${requestScope.key2 == null}<br/>

  </body>
</html>
