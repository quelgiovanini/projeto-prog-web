<%-- 
    Document   : cadastraCurso
    Created on : 21/11/2012 19:27:57
    Author     : Quele
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>  ..:: SIATICO ::.. </title>
    </head>
   <body>
       <form action="FrontController" method="POST">    
         
        <fieldset><legend>  Controle de Atividades Complementares - Cadastro de Cursos </legend>
            <table>
                <tr>
                <p class="first">
                    <td><label for="nomeCurso">Nome do Curso </label></td>
                    <td><input type="text" name="nomeCurso" id="nomeCurso" size="30" /></td>
                </p>
                </tr>
                <tr>
                <p class="first">
                    <td><label for="coordenador">Coordenador </label></td>
                   <td><input name="coordenador" type="text" id="coordenador" size="70" maxlength="60" />    
                </p>
                </tr>
                <tr>
                    <p>
                        <td><label for="codArea">Área </label></td>
                        <td><input type="text" name="codArea" id="codArea" size="30" /></td>
                    </p>
                 </tr>                  
                
                <tr>
                    <td colspan="2"><p>
                            <input name="cadastrar" type="submit" id="cadastrar" value="Cadastrar"  />
                            <input name="limpar" type="reset" id="limpar" value="Limpar dados" />
                            <input type="hidden" name="cmd" value='trataCadastraCurso'>
                    </td>
                </tr>
           
            </table>
            </fieldset>            
        </form>
    </body>
</html>

