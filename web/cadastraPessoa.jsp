<%-- 
    Document   : cadastraPessoa
    Created on : 10/01/2013, 01:19:18
    Author     : Quele
--%>

<%@page import="model.Area"%>
<%@page import="dao.AreaDAO"%>
<%@page import="model.Setor"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.SetorDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/cadastra.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>  ..:: SIATICO ::.. </title>
        
<!--<script scr="arquivo.js" type="text/javascript"></script>       -->
<script type="text/javascript">
   function displayResult(){
		var option=document.getElementById("tipoPessoa");
		var x = option.options[option.selectedIndex].value;
		switch(x){
			case  '0': //nenhum
			 document.getElementById('divFuncionario').style.display="none";
			 document.getElementById('divAluno').style.display="none";
			 document.getElementById('divProfessor').style.display="none";
			 break;
			case  '1': //Funcionario
			 document.getElementById('divFuncionario').style.display="block";
			 document.getElementById('divAluno').style.display="none";
			 document.getElementById('divProfessor').style.display="none";
			 break;
			case '2': //Aluno
			 document.getElementById('divFuncionario').style.display="none";
			 document.getElementById('divAluno').style.display="block";
			 document.getElementById('divProfessor').style.display="none";
			 break;
			case '3': //Professor
			 document.getElementById('divFuncionario').style.display="none";
			 document.getElementById('divAluno').style.display="none";
			 document.getElementById('divProfessor').style.display="block";
			break;
			}
	}
</script>
      </head>
      <body onLoad ="displayResult();">
          <form action="FrontController" method="POST"  >    

        <fieldset><legend>  Controle de Atividades Complementares - Cadastro de Pessoas </legend>   
            
                    <tr>
                    <p class="first">
                        <td><label for="nome">Nome </label></td>
                        <td><input type="text" name="nome" id="nome" size="50" maxlength="60" /></td>
                    </p>
                    </tr>
                    <tr>
                    <p class="first">
                    <td><label for="rg">RG </label></td>
                    <td><input type="text" name="rg" id="rg" size="50" /></td>
                    </p>
                    </tr>
                    <tr>
                      <p>
                        <td><label for="tipoPessoa">Tipo Pessoa </label></td>
                        <td>
                          <select name="tipoPessoa" id="tipoPessoa" onchange="displayResult(this)">
                              <option value="0" selected="selected">Selecionar</option>
                            <option value="1">Funcionario</option>
                            <option value="2">Aluno</option>
                            <option value="3">Professor </option>
                          </select>
                        </td>
                     </p>
                    </tr>
                    <div id="divFuncionario">
                        <tr>
                    <p>
                        <td><label for="setor">Setor </label></td>
                        <td>
                    <%  SetorDAO a = new SetorDAO();
                    ArrayList<Setor> listaSetor = a.pesquisarTipo();
                    
                    String p = "<select name='setor' id='setor'>";
                    for(int i=0; i<listaSetor.size(); i++){
                        p += "<option value='"+ listaSetor.get(i).getCodSetor()+"'>"+listaSetor.get(i).getNomeSetor()+"</option>";
                    }
                    
                    p+= "</select>";
                    out.print(p);
                    
                    %>
                        </td>
                    </p>
                    </tr>
                    </div>
                    
                    <div id="divAluno">
                    <tr>
                      <p>
                        <td><label for="matricula">Número de matricula </label></td>
                        <td><input type="text" name="matricula" id="matricula" size="30" /></td>
                      </p>
                    </tr>                             
                    <tr>
                      <p>
                        <td><label for="dataingresso">Data de ingresso </label></td>
                        <td><input type="text" name="dataingresso" id="dataingresso" size="30" /></td>
                      </p>
                    </tr>
                    </div>
                    
                    <div id="divProfessor">
                    <tr>
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
                    </div>
                    <tr>
                    <td colspan="2"><p>
                            <input name="cadastrar" type="submit" id="cadastrar" value="Cadastrar"  />
                            <input name="limpar" type="reset" id="limpar" value="Limpar dados" />
                            <input type="hidden" name="cmd" value='trataCadastroPessoa'>
                    </td>
                </tr>
           
            </table>
            </fieldset>            
        </form>
    </body>
</html>

