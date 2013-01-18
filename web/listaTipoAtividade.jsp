<%-- 
    Document   : listaTipoAtividade
    Created on : 13/12/2012, 23:18:55
    Author     : Quele
--%>

<%@page import="model.TipoAtividade"%>
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
        <h1> Tipos de Atividades Complementares </h1>

        <table>
            <thead>
                <tr>
                    <th>Descricao do Tipo</th>
                    <th>Proporção</th>
                    <th>Máximo Permitido</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>

        <%Iterator it; %>
        <%List dados = (List) request.getAttribute("dados");
            for (it = dados.iterator(); it.hasNext();){
            TipoAtividade tipo = (TipoAtividade) it.next();
        %>     
        <tr>
            <td ><%=tipo.getDescricaoTipo() %></td>
            <td ><%=tipo.getProporcao() %></td>
            <td ><%=tipo.getMaximoPermitido() %></td>
            <form action="editarTipoAtividade.jsp" method="POST">
                    <td align="center">
                        <input type="hidden" name="codtip" value="<%= tipo.getIdTipo() %>"/>
                        <input type="submit" value="Editar Tipo"></td>
            </form>
            <form action="FrontController" method="POST">
                    <td align="center">
                    <input type="hidden" name="cmd" value="trataExcluirTipoAtividade" />
                    <input type="hidden" name="codtip" value="<%= tipo.getIdTipo() %>"/>
                    <input type="submit" value="Excluir Tipo"/></td>
            </form>
        </tr>
        <% } %>
        </tbody>
    </table>
        <a href="index.jsp">Voltar</a>
    </body>
</html>
