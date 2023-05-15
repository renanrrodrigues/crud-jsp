<%--
  Created by IntelliJ IDEA.
  User: bobby
  Date: 08/05/2023
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ page import="dao.UsuarioDao" %>
<%@ page import="bean.Usuario" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>editar usuário</title>
</head>
<body>
    <%
        /*UsuarioDao dao = new UsuarioDao();
        Usuario usuario = new Usuario();
        usuario.setId(Integer.parseInt(request.getParameter("id")));
        usuario = UsuarioDao.getUsuarioById(usuario.getId());*/

        String id = request.getParameter("id");
        Usuario usuario = UsuarioDao.getUsuarioById(Integer.parseInt(id));

    %>

    <h1>Editar usuário</h1>

    <form action="edituser.jsp" method="post">
        <input type="hidden" name="id" value="<%=usuario.getId()%>">
        <label>Nome:</label>
        <label>
            <input type="text" name="nome" value="<%=usuario.getNome()%>">
        </label>
        <br>
        <label>Senha:</label>
        <label>
            <input type="password" name="password" value="<%=usuario.getPassword()%>">
        </label>
        <br>
        <label>Email:</label>
        <label>
            <input type="email" name="email" value="<%=usuario.getEmail()%>">
        </label>
        <br>
        <label>Sexo:</label>
        <label>
            <input type="radio" name="sexo" value="masculino">Masculino
            <input type="radio" name="sexo" value="feminino">Feminino
        </label>
        <br>
        <label>País:</label>
        <label>
            <select name="pais">
                <option value="brasil">Brasil</option>
                <option value="argentina">Argentina</option>
                <option value="uruguai">Uruguai</option>
                <option value="paraguai">Paraguai</option>
                <option value="outro">Outro</option>
            </select>
        </label>
        <%--<input type="submit" value="Editar">--%>
        <input type="submit" value="Editar Usuário">
    </form>

</body>
</html>
