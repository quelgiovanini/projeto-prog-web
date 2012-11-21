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
        <title>SIATCO - Cadastrar Curso</title>
    </head>
    <body>
        <form action="FrontController" method="POST">
             <table width="625" border="0">
                <tr>
                    <td width="120">Nome do curso: </td>
                    <td width="546"><input name="nomeCurso" type="text" id="nomeCurso" size="70" maxlength="60" />
                        <span class="style1">*</span></td>
                </tr>                        
                <tr>
                    <td width="120">Professor Coordenador:</td>
                    <td width="546"><input name="professor" type="text" id="professor" size="70" maxlength="60" />
                        <span class="style1">*</span></td>
                </tr>
                <tr>
                    <td width="120">Sigla Curso:</td>
                    <td><input name="siglaCurso" type="text" id="siglaCurso" size="70" maxlength="60" />
                        <span class="style1"> * </span></td>
                </tr>
                <tr>
                    <td width="120">Área:</td>
                    <td><input name="area" type="text" id="area" size="70" maxlength="60" />
                        <span class="style1"> * </span></td>
                </tr>
             </table>
        </form>
    </body>
</html>
