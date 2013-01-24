<%-- 
    Document   : cadastraTipoAtividade
    Created on : 19/11/2012, 11:52:42
    Author     : Quele
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/cadastra.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>  ..:: SIATICO ::.. </title>
    </head>
   <body>
       <form action="FrontController" method="POST">    
         
        <fieldset><legend>  Controle de Atividades Complementares - Cadastro de Tipo de Atividades </legend>
            <table>
                <tr>
                <p class="first">
                    <td><label for="descricaoTipo">Tipo de Atividade </label></td>
                    <td><input type="text" name="descricaoTipo" id="descricaoTipo" size="30" /></td>
                </p>
                </tr>
                <tr>
                <p class="first">
                    <td><label for="proporcao">Proporção </label></td>
                   <td><input type="text" name="proporcao" id="proporcao" size="30" maxlength="60" />    
                </p>
                </tr>
                <tr>
                    <p>
                        <td><label for="maximoPermitido">Máximo Permitido </label></td>
                        <td><input type="text" name="maximoPermitido" id="maximoPermitido" size="30" /></td>
                    </p>
                 </tr>                  
                
                <tr>
                    <td colspan="2"><p>
                            <input name="cadastrar" type="submit" id="cadastrar" value="Cadastrar"  />
                            <input name="limpar" type="reset" id="limpar" value="Limpar dados" />
                            <input type="hidden" name="cmd" value='trataCadastraTipoAtividade'>
                    </td>
                </tr>
           
            </table>
            </fieldset>            
        </form>
    </body>
</html>

