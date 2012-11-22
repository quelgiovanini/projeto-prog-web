<%-- 
    Document   : analisarAtividade
    Created on : 20/11/2012, 20:00:15
    Author     : Quele
--%>

<%@page import="java.util.List"%>
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
        <h1><font face="Verdana" color="#000000"> Atividades Complementares </font></h1>
        
        <%
            AtividadeDAO dao = new AtividadeDAO();
            List<Atividade> atividades = dao.pesquisarTudo();
        %>
        
        <table  BORDER="1" bordercolor="#C0C0C0"  width="100%" cellpadding="1" cellspacing="1">
            <tr>
                <td bgcolor="#F8F8FF" align="center"><font face="Verdana" size="2" color="#000000"><strong>Aluno</strong></font></td>
                <td bgcolor="#F8F8FF" align="center"><font face="Verdana" size="2" color="#000000"><strong>Tipo Atividade</strong></font></td>
                <td bgcolor="#F8F8FF" align="center"><font face="Verdana" size="2" color="#000000"><strong>Professor</strong></font></td>
                <td bgcolor="#F8F8FF" align="center"><font face="Verdana" size="2" color="#000000"><strong>Status</strong></font></td>
                <td bgcolor="#F8F8FF" colspan="2" align="center"><font face="Verdana" size="2" color="#000000"><strong>Opções</strong></font></td>
            </tr>
        <% for(int i = 0; i < atividades.size(); i++){
            Atividade atividade = atividades.get(i);
        %>     
        <tr>
            <td align="center"><font face="Verdana" size="2"<%=atividade.getAluno()%></font></td>
            <td align="center"><font face="Verdana" size="2"<%=atividade.getTipoAtividade()%></font></td>
            <td align="center"><font face="Verdana" size="2"<%=atividade.getProfessorResponsavel()%></font></td>
            <td align="center"><font face="Verdana" size="2"<%=atividade.getStatus()%></font></td>
            <td align="center"><font face="Verdana" size="2"><a href="analisarAtividade.jsp?codati=<%=atividade.getIdAtividade()%>">Analisar Atividade</font></a></td>
            <td align="center"><font face="Verdana" size="2"><a href="excluirAtividade.jsp?codati=<%=atividade.getIdAtividade()%>">Excluir Atividade</font></a></td>
        </tr>
        <% } %>
    </table>
    </body>
</html>
