<%-- 
    Document   : exibirAtividadeAluno
    Created on : 03/01/2013, 23:17:54
    Author     : Quele
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="model.Atividade"%>
<%@page import="dao.AtividadeDAO"%>
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
                    <th>Aluno</th>
                    <th>Tipo de Atividade</th>
                    <th>Professor</th>
                    <th>Status</th>
                    <th>Horas Aprovadas</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>

        <%Iterator it; %>
        <%List dados = (List) request.getAttribute("dados");
            for (it = dados.iterator(); it.hasNext();){
            Atividade atividade = (Atividade) it.next();
        %>     
        <tr>
            <td ><%=atividade.getAluno().getNome() %></td>
            <td ><%=atividade.getTipoAtividade().getDescricaoTipo() %></td>
            <td ><%=atividade.getProfessorResponsavel().getNome() %></td>
            <td ><%=atividade.getStatus()%></td>
            <td ><%=atividade.getHorasAceitas() %></td>
        </tr>
        <% } %>
        <a href="index.jsp">Voltar</a>
        </tbody>
    </table>
    </body>
</html>
