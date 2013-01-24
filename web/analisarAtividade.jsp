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
        <link rel="stylesheet" type="text/css" href="css/cadastra.css">
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
                    <input type="hidden" name="aluno" id="aluno" value="<%=atividade.getAluno().getCodPessoa() %>" >
                    <td ><input type="text" name="nomeAluno" id="nomeAluno" value="<%=atividade.getAluno().getNome() %>" size="70"/></td>
                </p>    
                </tr>
                <tr>
                 <p>
                    <td><label for="tipoAtividade">Tipo de Atividade </label></td>
                    <input type="hidden" name="tipoAtividade" id="tipoAtividade" value="<%=atividade.getTipoAtividade().getIdTipo() %>" >                    
                    <td><input type="text" name="tipoDesc" id="tipoDesc" value="<%=atividade.getTipoAtividade().getDescricaoTipo() %>" size="70"/></td>
                </p>
                </tr>
                <tr>
                <p>
                    <td><label for="professor">Professor </label></td> 
                    <input type="hidden" name="professor" id="professor" value="<%=atividade.getProfessorResponsavel().getCodPessoa() %>" >                      
                    <td><input type="text" name="prof" id="prof" value="<%=atividade.getProfessorResponsavel().getNome() %>" size="70"/></td>
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
        <br/><br/><font face="Verdana" size="2" color="#000000"><a href="index.jsp">Voltar</a></font>
    </body>
</html>