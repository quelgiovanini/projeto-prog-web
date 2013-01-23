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

        <fieldset><legend><font face="Verdana" color="#000000">  Controle de Atividades Complementares - Analise de Atividades </font></legend>
        
        <%
            // codigo por parametro
            String ativ = request.getParameter("codati");
            AtividadeDAO dao = new AtividadeDAO();
            Atividade atividade = dao.pesquisarCod(ativ);
            
        %>
        <form action='FrontController' method='POST'>
              <input type="hidden" name="cmd" value="trataAnalisarAtividade">        
               <table>
               <tr>
               <p class="first">
                    <td><label for="aluno">Aluno </label></td>                   
                    <td ><input type="text" name="aluno" id="<%=atividade.getAluno().getCodPessoa() %>" value="<%=atividade.getAluno().getNome() %>" size="70"/></td>
                </p>    
                </tr>
                <tr>
                 <p>
                    <td><label for="tipoAtividade">Tipo de Atividade </label></td>
                    <td><input type="text" name="tipoAtividade" id="<%=atividade.getTipoAtividade().getIdTipo() %>" value="<%=atividade.getTipoAtividade().getDescricaoTipo() %>" size="70"/></td>
                </p>
                </tr>
                <tr>
                <p>
                    <td><label for="professor">Professor </label></td>                    
                    <td><input type="text" name="professor" id="<%=atividade.getProfessorResponsavel().getCodPessoa() %>" value="<%=atividade.getProfessorResponsavel().getNome() %>" size="70"/></td>
                </p>
                </tr>  
                <tr>
                <p>
                    <td><label for="status">Status </label></td>                    
                    <td><input type="text" name="status" id="status" value="<%=atividade.getStatus() %>" size="10" /></td>
                </p>
                </tr>
                <tr>
                <p>
                    <td><label for="horas">Horas Aprovadas </label></td>                    
                    <td><input type="text" name="horas" id="horas" value="<%=atividade.getHorasAceitas() %>" size="10" /></td>
                </p>
                </tr> 
                    <input type="hidden" name="codati" id="codati" value="<%=atividade.getIdAtividade() %>" >
                    <input type="submit" value="Salvar">
               </table>     
        </form>
        <font face="Verdana" size="2" color="#000000"><a href="index.jsp">Voltar</a></font>
    </body>
</html>