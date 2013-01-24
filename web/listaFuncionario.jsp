<%-- 
    Document   : listaFuncionario
    Created on : 01/12/2012, 04:07:16
    Author     : Quele
--%>

<%@page import="model.Funcionario"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/listar.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> .:: SIATICO ::. </title>
    </head>
    <body>
        <h1> Funcionarios </h1>

        <table class="linhasAlternadas">
            <thead>
                <tr>
                    <th width="180px">Nome</th>
                    <th width="120px">RG</th>
                    <!--<th>Tipo Pessoa</th>-->
                    <th width="120px">Setor</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>

        <%Iterator it; %>
        <%List dados = (List) request.getAttribute("dados");
            for (it = dados.iterator(); it.hasNext();){
            Funcionario func = (Funcionario) it.next();
        %>     
        <tr>
            <td align="center"><%=func.getNome() %></td>
            <td align="center"><%=func.getRg() %></td>
           <%-- <td ><%=func.getTipoPessoa() %></td>            --%>
            <td align="center"><%=func.getCodSetor() %></td>
            <form action="FrontController" method="POST">
                <td align="center">
                    <input type="hidden" name="cmd" value="trataExcluirFuncionario" />
                    <input type="hidden" name="codPessoa" value="<%= func.getCodPessoa() %>"/>
                    <input type="submit" value="Excluir  Funcionário"/></td>
            </form>
        </tr>
        <% } %>
        </tbody>
    </table>
        <br/><br/><a href="index.jsp">Voltar</a>
    </body>
</html>

