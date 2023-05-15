<%--
  Created by IntelliJ IDEA.
  User: bobby
  Date: 08/05/2023
  Time: 19:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html>
<head>
    <title>Cadastrar novo usuario</title>
</head>
<body>
<h1>Cadastrar novo usuario</h1>
    <form action="addusuario.jsp" method="post">
        <input type="hidden" name="id">
        <label>Nome:</label>
        <label>
            <input type="text" name="nome">
        </label>
        <br>
        <label>Senha:</label>
        <label>
            <input type="password" name="password">
        </label>
        <br>
        <label>Email:</label>
        <label>
            <input type="email" name="email">
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
        <input type="submit" value="add new user">
    </form>
</body>
</html>
