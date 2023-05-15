<%--
  Created by IntelliJ IDEA.
  User: bobby
  Date: 08/05/2023
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ page import="dao.UsuarioDao" %>
<html>
<head>
    <title>deletar usuario</title>
</head>
<body>
<%
    String id = request.getParameter("id");
    UsuarioDao.deletarUsuario(Integer.parseInt(id));
    response.sendRedirect("viewusuarios.jsp");
%>

</body>
</html>
