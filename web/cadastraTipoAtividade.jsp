<%-- 
    Document   : cadastraTipoAtividade
    Created on : Nov 20, 2012, 12:27:57 AM
    Author     : paddock
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SIATCO - Cadastrar tipo de atividade</title>
    </head>
    <body>
        <form action="FrontController" method="POST">
             <table width="625" border="0">
                <tr>
                    <td width="120">Descrição Tipo Atividade: </td>
                    <td width="546"><input name="descTipo" type="text" id="descTipo" size="70" maxlength="60" />
                        <span class="style1">*</span></td>
                </tr>                        
                <tr>
                    <td width="120">Proporcao:</td>
                    <td width="546"><input name="proporcao" type="text" id="proporcao" size="70" maxlength="60" />
                        <span class="style1">*</span></td>
                </tr>
                <tr>
                    <td width="120">Curso:</td>
                    <td><input name="curso" type="text" id="curso" size="70" maxlength="60" />
                        <span class="style1"> * </span></td>
                </tr>
                <tr>
                    <td width="120">Máximo de horas:</td>
                    <td><input name="maximoHoras" type="text" id="maximoHoras" size="70" maxlength="60" />
                        <span class="style1"> * </span></td>
                </tr>
             </table>
        </form>
    </body>
</html>
