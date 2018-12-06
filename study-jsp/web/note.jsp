<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试JSP中的注释</title>
</head>
<body>
    <%-- 1.三种注释，修饰文字 --%>

    <%-- JSP注释1 --%>
    <!-- html注释 -->
    <%!
        // java注释1
        /* java注释2 */
        /** java注释3 */
        int x = 1;
    %>


    <%-- 2.三种注释，修饰代码 --%>

    <%-- <p>JSP注释，既可以注释HTML代码</p> --%>
    <%-- <%! String s2 ="JSP注释，又可以注释Java代码"; %> --%>

    <!-- <p>HTML注释，可以注释HTML代码</p> --%>
    <!-- <%! String s3 ="HTML注释，其实也可以注释Java代码，只不过脚本依然会执行"; %> --%>

    <%!
        // String s4 ="Java注释，只能注释Java代码";
    %>
</body>
</html>
