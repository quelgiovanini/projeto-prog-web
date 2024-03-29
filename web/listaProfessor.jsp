<%-- 
    Document   : listaProfessor
    Created on : 17/12/2012, 14:24:15
    Author     : Quele
--%>

<%@page import="model.Professor"%>
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
        <h1> Professores </h1>

        <table class="linhasAlternadas">
            <thead>
                <tr>
                    <th width="180px">Nome</th>
                    <th width="120px">RG</th>
                    <!--<th>Tipo Pessoa</th> -->
                    <th width="120">Área</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>

        <%Iterator it; %>
        <%List dados = (List) request.getAttribute("dados");
            for (it = dados.iterator(); it.hasNext();){
            Professor prof = (Professor) it.next();
        %>     
        <tr>
            <td align="center"><%=prof.getNome() %></td>
            <td align="center"><%=prof.getRg() %></td>
            <%--<td ><%=prof.getTipoPessoa() %></td>--%>
            <td align="center"><%=prof.getArea().getNomeArea() %></td>
            <form action="editarProfessor.jsp" method="POST">
                    <td align="center"><input type="hidden" name="codPessoa" value="<%= prof.getCodPessoa() %>"/>
                        <input type="submit" value="Editar Professor"></td>
            </form>
            <form action="FrontController" method="POST">
                
                    <td align="center">
                    <input type="hidden" name="cmd" value="trataExcluirProfessor" />
                    <input type="hidden" name="codPessoa" value="<%= prof.getCodPessoa() %>"/>
                    <input type="submit" value="Excluir Professor"/></td>
            </form>
        </tr>
        <% } %>
        </tbody>
    </table>
        <br/><br/><a href="index.jsp">Voltar</a>
    </body>
</html>
