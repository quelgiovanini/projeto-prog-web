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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> .:: SIATICO ::. </title>
    </head>
    <body>
        <h1> Atividades Complementares </h1>

        <table>
            <thead>
                <tr>
                    <th>Nome do Curso</th>
                    <th>Professor Coordenador</th>
                    <th>Área</th>
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
            <td ><%=curso.getNome() %></td>
            <td ><%=curso.getCodProfessor() %></td>
            <td ><%=curso.getArea() %></td>
            
            <form action="FrontController" method="POST">
                    <input type="hidden" name="cmd" value="trataExcluirCurso" />
                    <input type="hidden" name="codCurso" value="<%= curso.getCodCurso() %>"/>
                    <input type="submit" value="Excluir  Curso"/></td>
            </form>
        </tr>
        <% } %>
        <a href="index.jsp">Voltar</a>
        </tbody>
    </table>
    </body>
</html>
