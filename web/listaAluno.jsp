<%-- 
    Document   : listaAluno
    Created on : 17/12/2012, 14:04:54
    Author     : Quele
--%>

<%@page import="model.Aluno"%>
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
        <h1> Alunos </h1>

        <table>
            <thead>
                <tr>
                    <th>Aluno</th>
                    <th>RG</th>
                    <th>Tipo Pessoa</th>
                    <th>Matricula</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>

        <%Iterator it; %>
        <%List dados = (List) request.getAttribute("dados");
            for (it = dados.iterator(); it.hasNext();){
            Aluno aluno = (Aluno) it.next();
        %>     
        <tr>
            <td ><%=aluno.getNome() %></td>
            <td ><%=aluno.getRg() %></td>
            <td ><%=aluno.getTipoPessoa() %></td>
            <td ><%=aluno.getNumeroMatricula() %></td>
            <form action="editarAluno.jsp" method="POST">
                    <td align="center"><input type="hidden" name="codPessoa" value="<%= aluno.getCodPessoa() %>"/>
                        <input type="submit" value="Editar Aluno">
            </form>
            <form action="FrontController" method="POST">
                    <input type="hidden" name="cmd" value="trataExcluirAluno" />
                    <input type="hidden" name="codPessoa" value="<%= aluno.getCodPessoa() %>"/>
                    <input type="submit" value="Excluir Aluno"/></td>
            </form>
        </tr>
        <% } %>
        <a href="index.jsp">Voltar</a>
        </tbody>
    </table>
    </body>
</html>
