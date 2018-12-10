<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test include</title>
</head>
<body>
    <%@ include file="include_header.jsp"%>
    <%@ include file="include_body.jsp"%>
    <%@ include file="include_footer.jsp"%>

    <%= x + y + z%>
</body>
</html>
