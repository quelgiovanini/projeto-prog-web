<%-- 
    Document   : analisarAtividade
    Created on : 20/11/2012, 21:36:58
    Author     : Quele
--%>

<%@page import="model.Atividade"%>
<%@page import="dao.AtividadeDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> .:: SIATICO ::. </title>
    </head>
    <body>
        <form action='TrataAnaliseAtividade' method='POST'>
        <fieldset><legend><font face="Verdana" color="#000000">  Controle de Atividades Complementares - Analise de Atividades </font></legend>
        
        <%
            // codigo por parametro
            String codAtiv = request.getParameter("codati");
            AtividadeDAO dao = new AtividadeDAO();
            Atividade atividade = dao.pesquisarCod(codAtiv);
            
        %>
        
               <table>
               <tr>
               <p class="first">
                    <td><label for="aluno">Aluno </label></td>                   
                    <td ><input type="text" name="aluno" id="aluno" value="<%=atividade.getAluno().getNomePessoa() %>" size="70" maxlength="60" /></td>
                </p>    
                </tr>
                <tr>
                 <p>
                    <td><label for="tipoAtividade">Tipo de Atividade </label></td>
                    <td><input type="text" name="tipo" id="tipo" value="<%=atividade.getTipoAtividade().getDescricaoTipo() %>" size="70" maxlength="60" /></td>
                </p>
                </tr>
                <tr>
                <p>
                    <td><label for="professor">Professor </label></td>                    
                    <td><input type="text" name="professor" id="professor" value="<%=atividade.getProfessorResponsavel().getNomePessoa() %>" size="70" maxlength="60" /></td>
                </p>
                </tr>  
                <tr>
                    <p>
                        <td><label for="status">Status </label></td>
                        <td><font face="Verdana" size="2" color="#000000"><select name="status" id="status" >
                                    <option>Selecione...</option>
                                    <option value="E" selected>Espera</option>
                                    <option value="A">Aprovado</option>
                                    <option value="R">Reprovado</option>
                                </select></td>
                    </p>            
                </tr> 
                    <input type="hidden" name="codati" id="codati" value="<%=atividade.getIdAtividade() %>" >
                    <input type="submit" value="Salvar">
               </table>     
        </form>
        <font face="Verdana" size="2" color="#000000"><a href="index.jsp">Voltar</a></font>
    </body>
</html>