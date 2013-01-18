<%-- 
    Document   : analisarAtividade
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> .:: SIATCO ::. </title>
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
            <td ><%=atividade.getAluno().getCodPessoa() %></td>
            <td ><%=atividade.getTipoAtividade().getIdTipo() %></td>
            <td ><%=atividade.getProfessorResponsavel().getCodPessoa() %></td>
            <td ><%=atividade.getStatus()%></td>
            <form action="analisarAtividade.jsp" method="POST">
                    <td align="center"><input type="hidden" name="codati" value="<%= atividade.getIdAtividade() %>"/>
                        <input type="submit" value="Analisar Atividade">
            </form>
            <form action="FrontController" method="POST">
                    <input type="hidden" name="cmd" value="trataExcluirAtividade" />
                    <input type="hidden" name="codati" value="<%= atividade.getIdAtividade() %>"/>
                    <input type="submit" value="Excluir  Atividade"/></td>
            </form>
        </tr>
        <% } %>
        </tbody>
    </table>
        <a href="index.jsp">Voltar</a>
    </body>
</html>
