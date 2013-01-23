<%-- 
    Document   : cadastraAtividade
    Created on : 19/11/2012, 11:52:42
    Author     : Quele
--%>

<%@page import="model.Professor"%>
<%@page import="dao.ProfessorDAO"%>
<%@page import="model.Aluno"%>
<%@page import="dao.AlunoDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.TipoAtividadeDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="model.TipoAtividade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>  ..:: SIATICO ::.. </title>
    </head>
   <body>
       <form action="FrontController" method="POST">    
         
        <fieldset><legend>  Controle de Atividades Complementares - Cadastro de Atividades </legend>
            <table>
                <tr>
                <p class="first">
                    <td><label for="aluno">Aluno </label></td>
                    <td>
                    <%  AlunoDAO a = new AlunoDAO();
                    ArrayList<Aluno> listaAluno = a.pesquisarTipo();
                    
                    String p = "<select name='aluno' id='aluno'>";
                    for(int i=0; i<listaAluno.size(); i++){
                        p += "<option value='"+ listaAluno.get(i).getCodPessoa()+"'>"+listaAluno.get(i).getNome()+"</option>";
                    }
                    
                    p+= "</select>";
                    out.print(p);
                    
                    %>
                    </td>
                </p>
                </tr>
                <tr>
                <p class="first">
                    <td><label for="tipoAtividade">Tipo de Atividade </label></td>
                   <!-- <td><input name="tipoAtividade" type="text" id="tipoAtividade" size="70" maxlength="60" /> -->
                <td>
                <%  TipoAtividadeDAO t = new TipoAtividadeDAO();
                    ArrayList<TipoAtividade> listaTipo = t.pesquisarTipo();
                    
                    String s = "<select name='tipoAtividade' id='tipoAtividade'>";
                    for(int i=0; i<listaTipo.size(); i++){
                        s += "<option value='"+ listaTipo.get(i).getIdTipo()+"'>"+listaTipo.get(i).getDescricaoTipo()+"</option>";
                    }
                    
                    s+= "</select>";
                    out.print(s);
                    
                    %>
                </td>    
            </p>
                </tr>
                <tr>
                    <p>
                        <td><label for="professor">Professor </label></td>
                        <td>
                    <%  ProfessorDAO q = new ProfessorDAO();
                    ArrayList<Professor> listaProf = q.pesquisarTipo();
                    
                    String f = "<select name='professor' id='professor'>";
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
                    <p>
                        <td><label for="horasRequisitadas">Horas Requisitadas </label></td>
                        <td>
                            <input type="text" name="horasRequisitadas" id="horasRequisitadas" size="20" />
                        </td>
                    </p>
                 </tr>                  
                <tr>
                    <td colspan="2"><p>
                            <input name="cadastrar" type="submit" id="cadastrar" value="Cadastrar"  />
                            <input name="limpar" type="reset" id="limpar" value="Limpar dados" />
                            <input type="hidden" name="cmd" value='trataCadastroAtividade'>
                    </td>
                </tr>
           
            </table>
            </fieldset>            
        </form>
    </body>
</html>

