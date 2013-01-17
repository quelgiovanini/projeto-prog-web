<%-- 
    Document   : listaPessoa
    Created on : Nov 22, 2012, 12:06:52 AM
    Author     : paddock
--%>

<%@page import="model.Pessoa"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>  ..:: SIATICO ::.. </title>
    </head>
    <body>
        <h1> Pessoas cadastradas </h1>
        <table>
            <thead>
                <tr>
                    <th>CodPessoa</th>
                    <th>Nome</th>
                    <th>RG</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <%Iterator itr;%>
                <% List data = (List) request.getAttribute("data");
                for (itr = data.iterator(); itr.hasNext();){
                    Pessoa pessoa = (Pessoa)itr.next();
                %>
                <tr>
                    <td><%=pessoa.getCodPessoa()%></td>
                    <td><%=pessoa.getNomePessoa()%></td>
                    <td><%=pessoa.getRg()%></td>
                    <td><form action="FrontController" method="POST">
                            <input type="hidden" name="cmd" value="EditarPessoa" />
                            <input type="hidden" name="codPessoa" value="<%=pessoa.getCodPessoa()%>" />
                            <input type="submit" value="Editar" />
                        </form>
                    </td>
                </tr>
                <%
                }
                %>
            </tbody>
        </table>
    </body>
</html>
