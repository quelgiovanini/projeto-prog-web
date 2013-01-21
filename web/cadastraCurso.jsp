<%-- 
    Document   : cadastraCurso
    Created on : 21/11/2012 19:27:57
    Author     : Quele
--%>

<%@page import="model.Area"%>
<%@page import="dao.AreaDAO"%>
<%@page import="model.Professor"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.ProfessorDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>  ..:: SIATICO ::.. </title>
    </head>
   <body>
       <form action="FrontController" method="POST">    
         
        <fieldset><legend>  Controle de Atividades Complementares - Cadastro de Cursos </legend>
            <table>
                <tr>
                <p class="first">
                    <td><label for="nomeCurso">Nome do Curso </label></td>
                    <td><input type="text" name="nomeCurso" id="nomeCurso" size="30" /></td>
                </p>
                </tr>
                <tr>
                <!--<p class="first">
                    <td><label for="coordenador">Coordenador </label></td>
                   <td><input name="coordenador" type="text" id="coordenador" size="70" maxlength="60" />    
                </p> -->
                
                <p>
                        <td><label for="coordenador">Professor </label></td>
                        <td>
                    <%  ProfessorDAO q = new ProfessorDAO();
                    ArrayList<Professor> listaProf = q.pesquisarTipo();
                    
                    String f = "<select name='coordenador' id='coordenador'>";
                    for(int i=0; i<listaProf.size(); i++){
                        f += "<option value='"+ listaProf.get(i).getCodPessoa()+"'>"+listaProf.get(i).getNome()+"</option>";
                    }
                    
                    f+= "</select>";
                    out.print(f);
                    %>
                        </td>
                        </p>
                </tr>
                <tr>
                    <!--<p>
                        <td><label for="codArea">Área </label></td>
                        <td><input type="text" name="codArea" id="codArea" size="30" /></td>
                    </p> -->
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
                
                <tr>
                    <td colspan="2"><p>
                            <input name="cadastrar" type="submit" id="cadastrar" value="Cadastrar"  />
                            <input name="limpar" type="reset" id="limpar" value="Limpar dados" />
                            <input type="hidden" name="cmd" value='trataCadastraCurso'>
                    </td>
                </tr>
           
            </table>
            </fieldset>            
        </form>
    </body>
</html>

