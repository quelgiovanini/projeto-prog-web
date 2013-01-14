<%-- 
    Document   : index
    Created on : 18/10/2012, 21:57:53
    Author     : Quele
--%>

<%@page import="model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%

    Usuario usuario = (Usuario) session.getAttribute("usuario");
    if (usuario == null) {
%>        
    <jsp:forward page="/login.jsp" />
<% 
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> .:: SIATICO ::. </title>
    </head>
    <body>
        <h1> Controle de Atividades Complementares </h1>
        <div id="nav">
        <ul>
            <li><a href="FrontController?cmd=TrataExibirAtividade"> Analisar atividades </a></li>
        </ul>  
        </div>    

        <div id="nav1">
          <ul>
              <li><a href="cadastraPessoa.jsp"> Cadastrar Pessoas </a><br/></li>
              <li><a href="cadastraAtividade.jsp"> Cadastrar Atividade </a><br/></li>
          </ul>
        </div>
          <form action="FrontController" method="POST">
              <input type="hidden" name="cmd" value="listaPessoas" />
              <input type="submit" value="Listar pessoas" />
          </form>          
    </body>
</html>
