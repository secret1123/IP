<%@ page import="demo.servlet.AddressServlet" %>
<%@ page import="demo.util.Ip" %><%--
  Created by IntelliJ IDEA.
  User: anlu
  Date: 2017/6/10
  Time: 08:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index page</title>
    <%--<script>--%>
    <%--function  ip() {--%>
    <%--var form = document.getElementById('form');--%>
    <%--form.submit();--%>
    <%--}--%>
    <%--</script>--%>
</head>
<body onload="ip()">
<h1 style="text-align: center">IP SEARCH</h1>
<form style="text-align: center" id="form" action="index" method="post">
    <input style="text-align: center" type="text" name="ip" placeholder="ip 地址">
    <input style="background: slateblue" type="submit" value="查询"><br>
</form>
<p style="text-align: center">${sessionScope.geo}</p>
<p style="text-align: center"><%
    if (session.getAttribute("geo") == null) {
        String ip = request.getRemoteAddr();
        out.print(ip + "<br>");
        out.print(AddressServlet.getGeo(ip));
    }
%></p>
<h5 style="text-align: center">全球IP信息管理中心</h5>
</body>
</html>
