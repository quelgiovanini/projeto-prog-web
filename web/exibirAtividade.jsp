<%-- 
    Document   : exibirAtividade
    Created on : 20/11/2012, 20:00:15
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
        <title> .:: SIATCO ::. </title>
    </head>
    <body>
        <h1> Atividades Pendentes </h1>

        <table class="linhasAlternadas">
            <thead>
                <tr>
                    <th width="180px">Aluno</th>
                    <th width="180px">Tipo de Atividade</th>
                    <th width="180px">Professor</th>
                    <th width="100px">Status</th>
                    <th></th>
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
            <td align="center"><%=atividade.getAluno().getNome() %></td>
            <td align="center"><%=atividade.getTipoAtividade().getDescricaoTipo() %></td>
            <td align="center"><%=atividade.getProfessorResponsavel().getNome() %></td>
            <td align="center"><%=atividade.getStatus()%></td>
            <form action="analisarAtividade.jsp" method="POST">
                    <td align="center"><input type="hidden" name="codati" value="<%= atividade.getIdAtividade() %>"/>
                        <input type="submit" value="Analisar Atividade"></td>
            </form>
            <form action="FrontController" method="POST">
                <td><input type="hidden" name="cmd" value="trataExcluirAtividade" />
                    <input type="hidden" name="codati" value="<%= atividade.getIdAtividade() %>"/>
                    <input type="submit" value="Excluir  Atividade"/></td>
            </form>
        </tr>
        <% } %>
        </tbody>
    </table>
        <br/><br/><a href="index.jsp">Voltar</a>
    </body>
</html>
