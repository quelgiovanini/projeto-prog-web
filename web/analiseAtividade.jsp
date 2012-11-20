<%-- 
    Document   : analiseAtividade
    Created on : Nov 18, 2012, 11:25:23 PM
    Author     : paddock
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SIATCO - Sistema de Gerenciamento de Horas Complementares</title>
    </head>
    <body>
        <h1> Analise de Atividades Complementares </h1>
        <form action="FrontController" method="POST">
            <table width="625" border="0">
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
                    <td width="120">Horas Aprovadas:</td>
                    <td><input name="horas" type="text" id="horas" size="70" maxlength="60" />
                        <span class="style1"> * </span></td>
                </tr>
                <tr>
                    <td>Status:</td>
                    <td><select name="status" id="status" >
                            <option>Selecione...</option>
                            <option value="E" selected>Espera</option>
                            <option value="A">Aprovado</option>
                            <option value="R">Reprovado</option>
                        </select>
                        <span class="style1"> * </span></td>
                </tr>
                <tr>
                    <td colspan="2"><input name="ativo" type="checkbox" id="ativo" value="ATIVO" checked="checked" />
                        Deixar pendente </td>
                </tr>
                <tr>
                    <td colspan="2"><p>
                            <input name="cadastrar" type="submit" id="cadastrar" value="FInalizar analise" />
                            <input name="limpar" type="reset" id="limpar" value="Cancelar" />
                            <input type="hidden" name="cmd" value="trataAnaliseAtividade" />
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
