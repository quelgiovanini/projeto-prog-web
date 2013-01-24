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
        <link rel="stylesheet" type="text/css" href="css/listar.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> .:: SIATICO ::. </title>
    </head>
    <body>
        <h1> Atividades Complementares </h1>

        <table class="linhasAlternadas">
            <thead>
                <tr>
                    <th width="180px">Aluno</th>
                    <th width="180px">Tipo de Atividade</th>
                    <th width="160px">Professor</th>
                    <th width="100px">Status</th>
                    <th width="140px">Horas Aprovadas</th>
                </tr>
            </thead>
            <tbody>

        <%Iterator it; %>
        <%List dados = (List) request.getAttribute("dados");
            for (it = dados.iterator(); it.hasNext();){
            Atividade atividade = (Atividade) it.next();
        %>     
        <tr>
            <td align="center"><%=atividade.getAluno().getNome() %></td>
            <td align="center"><%=atividade.getTipoAtividade().getDescricaoTipo() %></td>
            <td align="center"><%=atividade.getProfessorResponsavel().getNome() %></td>
            <td align="center"><%=atividade.getStatus()%></td>
            <td align="center"><%=atividade.getHorasAceitas() %></td>
        </tr>
        <% } %>
        </tbody>
    </table>
        <br/><br/><a href="index.jsp">Voltar</a>
    </body>
</html>
