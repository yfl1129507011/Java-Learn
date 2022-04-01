<%--
  Created by IntelliJ IDEA.
  User: fenlon
  Date: 2022/3/15
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--加载Java包--%>
<%@ page import="java.util.*" %>

<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <%-- JSP表达式 输出到客户端网页 --%>
    <%= new Date()%>
    <br>
    <%-- jsp脚本片段 --%>
    <%
      for (int i = 0; i < 100; i++) {
        out.println(i+"<br>");
      }
    %>
  </body>
</html>
