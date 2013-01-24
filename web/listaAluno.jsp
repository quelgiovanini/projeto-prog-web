<%-- 
    Document   : listaAluno
    Created on : 17/12/2012, 14:04:54
    Author     : Quele
--%>

<%@page import="model.Aluno"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="dao.AlunoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/listar.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> .:: SIATICO ::. </title>
    </head>
    <body>
        <h1> Alunos </h1>

        <table class="linhasAlternadas">
            <thead>
                <tr>
                    <th width="150px">Aluno</th>
                    <th width="100px">RG</th>
                    <!--<th>Tipo Pessoa</th>-->
                    <th width="100px">Matricula</th>
                    <th width="200px">Horas Acumuladas</th>
                    <th></th>
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
            <td align="center"><%=aluno.getRg() %></td>
            <%--<td ><%=aluno.getTipoPessoa() %></td>--%>
            <td align="center"><%=aluno.getNumeroMatricula() %></td>
            <td align="center"><%=aluno.getHorasAcumuladas() %></td>
            <form action="editarAluno.jsp" method="POST">
                    <td align="center">
                        <input type="hidden" name="codPessoa" value="<%= aluno.getCodPessoa() %>"/>
                        <input type="submit" value="Editar Aluno"></td>
            </form>
            <form action="FrontController" method="POST">
                
                    <td align="center">
                    <input type="hidden" name="cmd" value="trataExcluirAluno" />
                    <input type="hidden" name="codPessoa" value="<%= aluno.getCodPessoa() %>"/>
                    <input type="submit" value="Excluir Aluno"/></td>
            </form>
        </tr>
        <% } %>
        </tbody>
    </table>
        <br/><br/><a href="index.jsp">Voltar</a>
    </body>
</html>
