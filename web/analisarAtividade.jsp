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
        <h1><font face="Verdana" color="#000000"> Analise de Atividades Complementares </font></h1>
        
        <%
            // codigo por parametro
            String codAtiv = request.getParameter("codati");
            AtividadeDAO dao = new AtividadeDAO();
            Atividade atividade = dao.pesquisarCod(codAtiv);
            
        %>
        
        <form action='TrataAnaliseAtividade' method='POST'>
               <table  BORDER="0" bordercolor="#C0C0C0"  width="70%" cellpadding="1" cellspacing="1">
               <tr>
                    <td bgcolor="#F8F8FF" align="center"><font face="Verdana" size="2" color="#000000"> Aluno: </font></td>
                    <td align="center" ><font face="Verdana" size="2" color="#000000"><input type="text" name="aluno" id="aluno" value="<%=atividade.getAluno().getNomePessoa() %>" size="70" maxlength="60" /></font>
                        <span class="style1">*</span></td>
                </tr>
                <tr>
                    <td bgcolor="#F8F8FF" align="center"><font face="Verdana" size="2" color="#000000"> Tipo de Atividade: </font></td>
                    <td align="center" ><font face="Verdana" size="2" color="#000000"><input type="text" name="tipo" id="tipo" value="<%=atividade.getTipoAtividade().getDescricaoTipo() %>" size="70" maxlength="60" /></font>
                        <span class="style1"> * </span></td>
                </tr>
                <tr>
                    <td bgcolor="#F8F8FF" align="center"><font face="Verdana" size="2" color="#000000"> Professor: </font></td>
                    <td align="center" ><font face="Verdana" size="2" color="#000000"><input type="text" name="prof" id="prof" value="<%=atividade.getProfessorResponsavel().getNomePessoa() %>" size="70" maxlength="60" /></font>
                        <span class="style1"> * </span></td>
                </tr>  
                <tr>
                    <td bgcolor="#F8F8FF" align="center"><font face="Verdana" size="2" color="#000000"> Status: </font></td>
                    <td align="center" ><font face="Verdana" size="2" color="#000000"><input type="text" name="status" id="status" value="<%=atividade.getStatus() %>" size="70" maxlength="60" /></font>
                        <span class="style1"> * </span></td>
                </tr> 
                    <input type="hidden" name="codati" id="codati" value="<%=atividade.getIdAtividade() %>" >
                    <input type="submit" value="Salvar">
               </table>     
        </form>
        <font face="Verdana" size="2" color="#000000"><a href="index.jsp">Voltar</a></font>
    </body>
</html>