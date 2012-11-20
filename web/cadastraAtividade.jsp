<%-- 
    Document   : cadastraNoticia
    Created on : Nov 17, 2012, 12:20:32 AM
    Author     : paddock
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SIATCO - Registrar Atividade Complementar</title>
    </head>
    <body>
        <form action="FrontController" method="POST">
            <table width="625" border="0">
                <tr>
                    <td width="120">Código Atividade: </td>
                    <td width="546"><input name="cod" type="text" id="cod" size="70" maxlength="60" />
                        <span class="style1">*</span></td>
                </tr>                        
                <tr>
                    <td width="120">Aluno:</td>
                    <td width="546"><input name="aluno" type="text" id="aluno" size="70" maxlength="60" />
                        <span class="style1">*</span></td>
                </tr>
                <tr>
                    <td width="120">Tipo de Atividade:</td>
                    <td><input name="tipo" type="text" id="tipo" size="70" maxlength="60" />
                        <span class="style1"> * </span></td>
                </tr>
                <tr>
                    <td width="120">Professor:</td>
                    <td><input name="prof" type="text" id="prof" size="70" maxlength="60" />
                        <span class="style1"> * </span></td>
                </tr>  
                <tr>
                    <td width="120">Status:</td>
                    <td><input name="sta" type="text" id="sta" size="70" maxlength="60" />
                        <span class="style1"> * </span></td>
                </tr>                        
                <tr>
                    <td colspan="2"><input name="ativo" type="checkbox" id="ativo" value="ATIVO" checked="checked" />
                        Deixar pendente </td>
                </tr>
                <tr>
                    <td colspan="2"><p>
                            <input name="cadastrar" type="submit" id="cadastrar" value="Finalizar analise" />
                            <input name="limpar" type="reset" id="limpar" value="Limpar dados" />
                            <input type="hidden" name="cmd" value='trataCadastroAtividade'>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
