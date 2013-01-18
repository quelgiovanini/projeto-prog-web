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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>  ..:: Controle de Contas ::.. </title>
    </head>
    <body>
        <h1><font face="Verdana" color="#000000"> Edição de Lançamento </font></h1>
        
        <%
            // codigo por parametro
            //Integer tp = Integer.parseInt(request.getParameter("codtip"));
            String tp = request.getParameter("codtip");
            TipoAtividadeDAO dao = new TipoAtividadeDAO();
            TipoAtividade tipo = dao.pesquisarCod(tp);
            
        %>
        
        <form action='FrontController' method='POST'>
                <input type="hidden" name="cmd" value="trataEditarTipoAtividade">

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
        </form>
        <a href="index.jsp">Voltar</a>
    </body>
</html>
