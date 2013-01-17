<%-- 
    Document   : editarProfessor
    Created on : 17/12/2012, 20:15:46
    Author     : Quele
--%>


<%@page import="model.Professor"%>
<%@page import="dao.ProfessorDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>  ..:: Controle de Contas ::.. </title>
    </head>
    <body>
        <h1><font face="Verdana" color="#000000"> Edição de Professor </font></h1>
        
        <%
            // codigo por parametro
            String pro = request.getParameter("codPessoa");
            ProfessorDAO dao = new ProfessorDAO();
            Professor professor = dao.pesquisarCod(pro);
            
        %>
        
        <form action='FrontController' method='POST'>
                <input type="hidden" name="cmd" value="trataEditarProfessor">

               <table>
               <tr>
                    <td > Nome </font></td>
                    <td align="center" ><input type="text" name="nome" id="nome" value="<%=professor.getNome() %>" size="70" maxlength="60" />
                    </td>
                </tr>
                <tr>
                    <td >RG </font></td>
                    <td align="center" ><input type="text" name="rg" id="rg" value="<%=professor.getRg() %>" size="70" maxlength="60" />
                        <span class="style1"> * </span></td>
                </tr>
                <tr>

                    <td align="center" ><input type="hidden" name="tipopessoa" id="tipopessoa" value="<%=professor.getTipoPessoa() %>" size="70" maxlength="60" />
                    </td>
                </tr>  
                <tr>
                    <td > Área </font></td>
                    <td align="center" ><input type="text" name="area" id="area" value="<%=professor.getArea() %>" size="70" maxlength="60" />
                    </td>
                </tr>  
               </table>                   
                    <input type="hidden" name="codPessoa" id="codPessoa" value="<%=professor.getCodPessoa() %>" />
                      <input type="submit" value="Salvar">
        </form>
        <font face="Verdana" size="2" color="#000000"><a href="index.jsp">Voltar</a></font>
    </body>
</html>
