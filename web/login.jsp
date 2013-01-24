<%-- 
    Document   : login
    Created on : 20/12/2012, 02:01:12
    Author     : Fellipe
--%>

<%@page import="model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
    Usuario usuario = new Usuario();
    session.setAttribute("usuario", usuario);
    if (usuario == null) {
%>        
     <jsp:forward page="/login.jsp" />
<%
    }
%>

<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/login.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> .:: SIATICO ::. </title>
    </head>
    <body>
        <form method="POST" action=trataLogin>
            <div class="campo">
           <h1> Sistema de Atividades Complementares </h1>
           <p> Para iniciar, insira os dados abaixo </p>
           <table>
                <tr> 
                    <td> Login</td> 
                    <td> <INPUT TYPE=TEXT SIZE=30 NAME = "Login"> </td> 
                </tr> 
                <tr> 
                    <td> Senha</td> 
                    <td> <INPUT TYPE = PASSWORD size =30 NAME = "Senha"> </td> 
                </tr>
           </table>
           <p>
               <input type=submit value="Autenticar"> 
               <input type=reset value="Cancelar">
           </p>
        </form>
        </div>
    </body>
</html>
