<%-- 
    Document   : cadastraCurriculo
    Created on : Nov 19, 2012, 11:48:38 PM
    Author     : paddock
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SIATCO - Inserir novo currículo</title>
    </head>
    <body>
        <form action="FrontController" method="POST">
            <table>
                <tr>
                    <td>Curso:</td>
                    <td><input type="text" name="curso" size="20"></td>
                </tr>
                <tr>
                    <td>Semestre Início:</td>
                    <td><input type="text" name="semestreInicio" size="20"></td>
                </tr>                
            </table>
        </form>
    </body>
</html>
