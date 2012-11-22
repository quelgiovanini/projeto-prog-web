<%-- 
    Document   : editaPessoa
    Created on : Nov 22, 2012, 2:29:26 AM
    Author     : paddock
--%>

<%@page import="model.Pessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SIATCO - Editar Pessoa</title>
    </head>
    <body>
        <% Pessoa pessoa = (Pessoa)request.getAttribute("data"); %>
        <form id="form1" action="FrontController" method="POST">
            <input type="hidden" name="codPessoa" value="<%=pessoa.getCodPessoa()%>"/>
            <fieldset><legend>Cadastrar pessoa</legend>
                <table>
                    <tr>
                    <p class="first">
                        <td><label for="nome">Nome</label></td>
                        <td><input type="text" name="nome" id="nome" size="30" value="<%=pessoa.getNomePessoa()%>" /></td>
                    </p>
                    </tr>
                   <!-- <tr>
                    <p>
                        <td><label for="email">E-mail</label></td>
                        <td><input type="text" name="email" id="email" size="30" /></td>
                    </p>
                    </tr>
                    <tr>
                    <p>
                        <td><label for="senha">Senha</label></td>
                        <td><input type="password" name="senha" id="senha" size="30" /></td>
                    </p>
                    </tr>-->
                    <tr>
                    <p>
                        <td><label for="rg">RG</label></td>
                        <td><input type="text" name="rg" id="rg" size="30" value="<%=pessoa.getRg()%>" /></td>
                    </p>
                    </tr>
                    <tr>
                    <p>
                        <td><label for="datanasc">Data de Nascimento</label></td>
                        <td><input type="text" name="datanasc" id="datanasc" size="30" value="<%=pessoa.getDataNascimento()%>" /></td>
                    </p>
                    </tr>
                    <tr>
                      <p>
                        <td><label for="tipopessoa">Tipo Pessoa</label></td>
                        <td>
                          <select name="tipopessoa">
                            <option value="1">Aluno</option>
                            <option value="2">Funcionario</option>
                            <option value="3">Professor</option>
                          </select>
                        </td>
                     </p>
                    </tr>
                    <tr>
                      <p>
                        <td><label for="datanasc">Data de ingresso (aluno):</label></td>
                        <td><input type="text" name="dataingresso" id="dataingresso" size="30" /></td>
                      </p>
                    </tr>
                    <tr>
                      <p>
                        <td><label for="datanasc">Numero matricula (aluno):</label></td>
                        <td><input type="text" name="numeromatricula" id="numeromatricula" size="30" /></td>
                      </p>
                    </tr>
                    <tr>
                      <p>
                        <td><label for="datanasc">Setor(Funcionario):</label></td>
                        <td><input type="text" name="setor" id="setor" size="30" /></td>
                      </p>
                    </tr>
                    <tr>
                      <p>
                        <td><label for="datanasc">Curso(Funcionario):</label></td>
                        <td><input type="text" name="dataingresso" id="dataingresso" size="30" /></td>
                      </p>
                    </tr>
                </table>
                <br/>
                <input type="submit" value="Salvar Mudanças">
                <input type="reset" value="Limpar">
                <input type="hidden" name="cmd" value="trataEditaPessoa">
            </fieldset>
        </form>
    </body>
</html>
