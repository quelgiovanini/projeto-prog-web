<%-- 
    Document   : editarTipoAtividade
    Created on : 16/12/2012, 23:59:38
    Author     : Quele
--%>

<%@page import="model.TipoAtividade"%>
<%@page import="dao.TipoAtividadeDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/cadastra.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>  ..:: SIATICO ::.. </title>
    </head>
    <body>
        
        <%
            // codigo por parametro
            //Integer tp = Integer.parseInt(request.getParameter("codtip"));
            String tp = request.getParameter("codtip");
            TipoAtividadeDAO dao = new TipoAtividadeDAO();
            TipoAtividade tipo = dao.pesquisarCod(tp);
            
        %>
        
        <form action='FrontController' method='POST'>
                <input type="hidden" name="cmd" value="trataEditarTipoAtividade">
                <fieldset><legend>  Controle de Atividades Complementares - Edicao de Tipo de Atividade </legend>
               <table>
               <tr>
                    <td >Descrição do Tipo</td>
                    <td align="center" ><input type="text" name="descricaoTipo" id="descricaoTipo" value="<%=tipo.getDescricaoTipo() %>" size="70" maxlength="60" /></td>
                </tr>
                <tr>
                    <td> Proporção </td>
                    <td align="center" ><input type="text" name="proporcao" id="proporcao" value="<%=tipo.getProporcao() %>" size="70" maxlength="60" /></td>
                </tr>
                <tr>
                    <td >Máximo Permitido </td>
                    <td><input type="text" name="maximoPermitido" id="maximoPermitido" value="<%=tipo.getMaximoPermitido() %>" size="70" maxlength="60" /></td>
                </tr>   
               </table>                   
                    <input type="hidden" name="codtip" id="codtip" value="<%=tipo.getIdTipo() %>" />
                      <input type="submit" value="Salvar">
                </fieldset>
        </form>
        <br/><br/><a href="index.jsp">Voltar</a>
    </body>
</html>
