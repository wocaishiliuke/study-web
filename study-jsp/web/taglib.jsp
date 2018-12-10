<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>test taglib</title>
</head>
<body>
    <%
        for (int i = 0; i < 3; i++) {
            out.println(i);
        }
    %>

    <br/>

    <c:forEach var="i" begin="0" end="2" step="1">
        ${i}
    </c:forEach>

</body>
</html>
