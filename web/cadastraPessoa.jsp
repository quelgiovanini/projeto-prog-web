<%-- 
    Document   : cadastraPessoas
    Created on : 10/01/2013, 01:19:18
    Author     : Quele
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>  ..:: SIATICO ::.. </title>
        
<!--<script scr="arquivo.js" type="text/javascript"></script>       -->
<script type="text/javascript">
   function displayResult(){
		var option=document.getElementById("forms");
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
          <form action="FrontController" method="POST" onload="displayResult()">    

        <fieldset><legend>  Controle de Atividades Complementares - Cadastro de Pessoas </legend>      
<tr>
                    <p class="first">
                        <td><label for="nome">Nome </label></td>
                        <td><input type="text" name="nome" id="nome" size="70" maxlength="60" /></td>
                    </p>
                    </tr>
                    <tr>
                    <p>
                        <td><label for="rg">RG </label></td>
                        <td><input type="text" name="rg" id="rg" size="30" /></td>
                    </p>
                    </tr>
                    <tr>
                      <p>
                        <td><label for="tipoPessoa">Tipo Pessoa </label></td>
                        <td>
                          <select name="tipoPessoa">
                              <option value="0">Selecionar</option>
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
                        <td><input type="text" name="setor" id="setor" size="30" /></td>
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
                        <td><input type="text" name="area" id="area" size="30" /></td>
                      </p>
                    </tr>    
                    </div>
                    <tr>
                    <td colspan="2"><p>
                            <input name="cadastrar" type="submit" id="cadastrar" value="Cadastrar"  />
                            <input name="limpar" type="reset" id="limpar" value="Limpar dados" />
                            <input type="hidden" name="cmd" value='trataCadastroPessoas'>
                    </td>
                </tr>
           
            </table>
            </fieldset>            
        </form>
    </body>
</html>

