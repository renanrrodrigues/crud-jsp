<%--
  Created by IntelliJ IDEA.
  User: bobby
  Date: 08/05/2023
  Time: 22:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ page import="dao.UsuarioDao" %>
<jsp:useBean id="u" class="bean.Usuario">
</jsp:useBean>
<jsp:setProperty name="u" property="*"/>

<%
    UsuarioDao.addUsuario(u);
    response.sendRedirect("viewusuarios.jsp");
%>