<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ page import="dao.UsuarioDao" %>
<%@ page import="bean.Usuario" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: bobby
  Date: 07/05/2023
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Lista de Usuários</title>
</head>
<body>
    <%
        List<Usuario> listaUsuarios = new ArrayList<Usuario>();
        listaUsuarios = UsuarioDao.getAllUsuarios();
        request.setAttribute("listaUsuarios", listaUsuarios);
    %>

        <h1>Lista de Usuários</h1>

        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Email</th>
                    <th>Password</th>
                    <th>Sexo</th>
                    <th>País</th>
                    <th>Editar</th>
                    <th>Deletar</th>
                </tr>
                <c:forEach items="${listaUsuarios}" var="usuario">
                <tr>
                    <td>${usuario.id}</td>
                    <td>${usuario.nome}</td>
                    <td>${usuario.email}</td>
                    <td>${usuario.password}</td>
                    <td>${usuario.sexo}</td>
                    <td>${usuario.pais}</td>
                    <td><a href="editform.jsp?id=${usuario.id}">Editar</a></td>
                    <td><a href="delete.jsp?id=${usuario.id}">Deletar</a></td>
                </tr>
                </c:forEach>
            </thead>
        </table>
        <br>
        <a href="adduserform.jsp" class="m-8 bg-blue-500 hover:bg-blue-700 text-white font-bold rounded">Novo Usuário</a>
        <a href="index.jsp" class="m-8 bg-blue-500 hover:bg-blue-700 text-white font-bold rounded">Voltar</a>
</body>
</html>