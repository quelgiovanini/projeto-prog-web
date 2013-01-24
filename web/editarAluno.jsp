<%-- 
    Document   : editarAluno
    Created on : 17/12/2012, 21:33:16
    Author     : Quele
--%>

<%@page import="model.Aluno"%>
<%@page import="dao.AlunoDAO"%>
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
            String alu = request.getParameter("codPessoa");
            AlunoDAO dao = new AlunoDAO();
            Aluno aluno = dao.pesquisarCod(alu);
            
        %>
        
        <form action='FrontController' method='POST'>
                <input type="hidden" name="cmd" value="trataEditarAluno">
                <fieldset><legend>  Controle de Atividades Complementares - Edicao de Aluno </legend>
               <table>
               <tr>
                    <td > Nome </font></td>
                    <td align="center" ><input type="text" name="nome" id="nome" value="<%=aluno.getNome() %>" size="70" maxlength="60" />
                    </td>
                </tr>
                <tr>
                    <td >RG </font></td>
                    <td align="center" ><input type="text" name="rg" id="rg" value="<%=aluno.getRg() %>" size="70" maxlength="60" />
                        </td>
                </tr>
                <tr>

                    <td align="center" ><input type="hidden" name="tipopessoa" id="tipopessoa" value="<%=aluno.getTipoPessoa() %>" size="70" maxlength="60" />
                    </td>
                </tr>  
                <tr>
                    <td > Número de Matricula </font></td>
                    <td align="center" ><input type="text" name="nummatricula" id="nummatricula" value="<%=aluno.getNumeroMatricula() %>" size="70" maxlength="60" />
                    </td>
                </tr>  
               </table>                   
                    <input type="hidden" name="codPessoa" id="codPessoa" value="<%=aluno.getCodPessoa() %>" />
                      <input type="submit" value="Salvar">
                </fieldset>
        </form>
        <br/><br/><font face="Verdana" size="2" color="#000000"><a href="index.jsp">Voltar</a></font>
    </body>
</html>
