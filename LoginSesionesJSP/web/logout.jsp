<%-- 
    Document   : logout
    Created on : 28/11/2017, 06:15:43 AM
    Author     : miguel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    session.setAttribute("user", null);
    session.invalidate();
    response.sendRedirect("index.jsp");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
