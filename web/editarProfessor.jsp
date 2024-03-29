<%-- 
    Document   : editarProfessor
    Created on : 17/12/2012, 20:15:46
    Author     : Quele
--%>


<%@page import="model.Area"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.AreaDAO"%>
<%@page import="model.Professor"%>
<%@page import="dao.ProfessorDAO"%>
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
            String pro = request.getParameter("codPessoa");
            ProfessorDAO dao = new ProfessorDAO();
            Professor professor = dao.pesquisarCod(pro);
            
        %>
        
        <form action='FrontController' method='POST'>
                <input type="hidden" name="cmd" value="trataEditarProfessor">
                <fieldset><legend>  Controle de Atividades Complementares - Edicao de Professor </legend>
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
                    <!--<td > Área </font></td>
                    <td align="center" ><input type="text" name="area" id="area" value="<%=professor.getArea() %>" size="70" maxlength="60" />
                    </td>-->
                    
                    <p>
                        <td><label for="area">Área </label></td>
                        <td>
                    <%  AreaDAO r = new AreaDAO();
                    ArrayList<Area> listaArea = r.pesquisarTipo();
                    
                    String l = "<select name='area' id='area'>";
                    for(int i=0; i<listaArea.size(); i++){
                        l += "<option value='"+ listaArea.get(i).getCodArea()+"'>"+listaArea.get(i).getNomeArea()+"</option>";
                    }
                    
                    l+= "</select>";
                    out.print(l);
                    
                    %>
                        </td>
                      </p>
                </tr>  
               </table>                   
                    <input type="hidden" name="codPessoa" id="codPessoa" value="<%=professor.getCodPessoa() %>" />
                      <input type="submit" value="Salvar">
                </fieldset>
        </form>
        <font face="Verdana" size="2" color="#000000"><a href="index.jsp">Voltar</a></font>
    </body>
</html>
