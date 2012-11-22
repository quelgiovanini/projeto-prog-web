<%-- 
    Document   : excluirAtividade
    Created on : 21/11/2012, 21:24:42
    Author     : Quele
--%>

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
        <%
            String codigo = request.getParameter("codati");
            AtividadeDAO dao = new AtividadeDAO();
            Atividade atividade = dao.pesquisarCod(codigo);
        %>
        
        <form action='TrataRemoverAtividade' method="POST">
            <p> Confirmar a exclusão da atividade do aluno: <%=atividade.getAluno().getNomePessoa() %> ? </p>
            <input type="hidden" name="codati" value="<%= atividade.getIdAtividade()%>" >
            <input type="submit" value="Excluir">
        </form>
            <a href="index.jsp"> Voltar </a>
    </body>
</html>
