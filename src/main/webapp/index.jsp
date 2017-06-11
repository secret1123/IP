<%--
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
</head>
<body>
<h1 style="text-align: center">IP SEARCH</h1>
<form style="text-align: center" action="index" method="post">
    <input style="text-align: center" type="text" name="ip" placeholder="ip 地址"><input style="background: slateblue" type="submit"
                                                                                            value="查询"><br>
</form>
<p style="text-align: center"><%
    String ip = request.getParameter("ip");
    if (ip != null) {
        out.print(ip);
    }%><br><%
    String message = (String) request.getAttribute("message");
    if (message != null) {
        out.print(message);
    }
%></p>
<%--<p style="text-align: center"><%=(request.getAttribute("message")) != null ? request.getAttribute("message") : ""%>--%>
<%--</p><br>--%>
<h5 style="text-align: center">全球IP信息管理中心</h5>
</body>
</html>
