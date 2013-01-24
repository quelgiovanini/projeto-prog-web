<%-- 
    Document   : listaCurso
    Created on : 19/01/2013, 20:12:09
    Author     : Quele
--%>

<%@page import="model.Curso"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/listar.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> .:: SIATCO ::. </title>
    </head>
    <body>
        <h1> Cursos </h1>

        <table class="linhasAlternadas">
            <thead>
                <tr>
                    <th width="250px">Nome do Curso</th>
                    <th>Professor Coordenador</th>
                    <th width="200px">Área</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>

        <%Iterator it; %>
        <%List dados = (List) request.getAttribute("dados");
            for (it = dados.iterator(); it.hasNext();){
            Curso curso = (Curso) it.next();
        %>     
        <tr>
            <td align="center"><%=curso.getNome() %></td>
            <td align="center"><%=curso.getOrientador().getNome() %></td>
            <td align="center"><%=curso.getArea().getNomeArea() %></td>
            
            <form action="FrontController" method="POST">
                    <td align="center">
                    <input type="hidden" name="cmd" value="trataExcluirCurso" />
                    <input type="hidden" name="codCurso" value="<%= curso.getCodCurso() %>"/>
                    <input type="submit" value="Excluir Curso"/></td>
            </form>
        </tr>
        <% } %>
        </tbody>
    </table>
        
        <br/><br/><a href="index.jsp">Voltar</a>
    </body>
</html>
