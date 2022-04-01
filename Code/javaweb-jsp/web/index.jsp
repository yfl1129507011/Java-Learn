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
  
    <%--内置对象--%>
    <%
      pageContext.setAttribute("name1", "fenlon1");
      request.setAttribute("name2", "fenlon2");
      session.setAttribute("name3", "fenlon3");
      application.setAttribute("name4", "fenlon4");
    %>

    <%
      String name1 = (String) pageContext.findAttribute("name1");
      String name2 = (String) pageContext.findAttribute("name2");
      String name3 = (String) pageContext.findAttribute("name3");
      String name4 = (String) pageContext.findAttribute("name4");
    %>

    <%--打印--%>
    <h1>${name1}</h1>
    <h1>${name2}</h1>
    <h1>${name3}</h1>
    <h1>${name4}</h1>
  </body>
</html>
