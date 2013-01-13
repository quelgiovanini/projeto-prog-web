<%-- 
    Document   : cadastraAtividade
    Created on : 19/11/2012, 11:52:42
    Author     : Quele
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="model.TipoAtividade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>  ..:: SIATICO ::.. </title>
    </head>
   <body>
       <form action="FrontController" method="POST">    


        <% Iterator it; %>
        <%List dados = (List) request.getAttribute("dados");
            for (it = dados.iterator(); it.hasNext();){
            TipoAtividade tipo = (TipoAtividade) it.next();
        %>               
           
        <fieldset><legend><font face="Verdana" color="#000000">  Controle de Atividades Complementares - Cadastro de Atividades </font></legend>
            <table>
                <tr>

                    <td><input name="codAtiv" type="hidden" id="codAtiv" size="70" maxlength="60" />

                </tr>                        
                <tr>
                <p class="first">
                    <td><label for="aluno">Aluno </label></td>
                    <td><input name="aluno" type="text" id="aluno" size="70" maxlength="60" />
                </p>
                </tr>
                <tr>
                <p>
                        <td><label for="tipoAtividade">Tipo de Atividade </label></td>
                        <td>
                          <select name="tipoAtividade">
                                    <option value="1" selected>Estágio</option>
                                    <option value="2">Palestra</option>
                                    <option value="3">Projeto Pesquisa</option>
                          </select>
                        </td>
                </p>    
                </tr>
                <tr>
                    <p>
                        <td><label for="professor">Professor </label></td>
                        <td><input type="text" name="professor" id="professor" size="30" /></td>
                    </p>
                 </tr>   
                <tr>
                    <p>
                        <td><label for="status">Status </label></td>
                        <td>
                          <select name="status">
                                    <option value="E" selected>Espera</option>
                                    <option value="A">Aprovado</option>
                                    <option value="R">Reprovado</option>
                          </select>
                        </td>
                    </p>
                 </tr>                   
                <tr>
                    <td colspan="2"><p>
                            <input name="cadastrar" type="submit" id="cadastrar" value="Cadastrar"  />
                            <input name="limpar" type="reset" id="limpar" value="Limpar dados" />
                            <input type="hidden" name="cmd" value='TrataCadastroAtividade'>
                    </td>
                </tr>
            </table>
            </fieldset>            
        </form>
    </body>
</html>

