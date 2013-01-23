<%-- 
    Document   : index
    Created on : 18/10/2012, 21:57:53
    Author     : Quele
--%>

<%@page import="model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%

    Usuario usuario = (Usuario) session.getAttribute("usuario");
    if (usuario == null) {
%>        
    <jsp:forward page="/login.jsp" />
<% 
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> .:: SIATICO ::. </title>
        <script type="text/javascript">
            function displayResult(){
		//var option=document.getElementById("tipoPessoa");
                <% int tipo = usuario.getTipoPessoa();%>
		var x = <%=tipo%>;
		switch(x){
			case 0: //nenhum
			 document.getElementById('divFuncionario').style.display="none";
			 document.getElementById('divAluno').style.display="none";
			 document.getElementById('divProfessor').style.display="none";
			 break;
			case 1: //Funcionario
			 document.getElementById('divFuncionario').style.display="block";
			 document.getElementById('divAluno').style.display="none";
			 document.getElementById('divProfessor').style.display="none";
			 break;
			case 2: //Aluno
			 document.getElementById('divFuncionario').style.display="none";
			 document.getElementById('divAluno').style.display="block";
			 document.getElementById('divProfessor').style.display="none";
			 break;
			case 3: //Professor
			 document.getElementById('divFuncionario').style.display="none";
			 document.getElementById('divAluno').style.display="none";
			 document.getElementById('divProfessor').style.display="block";
			break;
			}
	}
        </script>
    </head>
    <body onLoad="displayResult();">
        <h1> Controle de Atividades Complementares </h1>
        <div id="divProfessor">
        <ul>
            <li><a href="FrontController?cmd=trataExibirAtividade"> Verificar atividades </a></li>
            <li><a href="FrontController?cmd=trataExibirAllAtividade"> Relatório Atividades </a></li>
        </ul>  
        </div>    
        <br />
        <div id="divFuncionario">
          <ul>
              <li><a href="cadastraAtividade.jsp"> Cadastrar Atividade </a><br/></li><br />
              <li><a href="cadastraPessoa.jsp"> Cadastrar Pessoas </a><br/></li>            
              <li><a href="cadastraTipoAtividade.jsp"> Cadastrar Tipo Atividade </a><br/></li>
              <li><a href="cadastraCurso.jsp"> Cadastrar Cursos </a><br/></li>
              <br />
              <li><a href="FrontController?cmd=trataListaTipoAtividade"> Listar Tipos de Atividade </a><br/></li>
              <li><a href="FrontController?cmd=trataListaCurso"> Listar Cursos </a><br/></li>              
              <li><a href="FrontController?cmd=trataListaAluno">Listar Alunos</a></li>
              <li><a href="FrontController?cmd=trataListaProfessor">Listar Professores</a></li>
              <li><a href="FrontController?cmd=trataListaFuncionario"> Listar Funcionários </a><br/></li>   
              
              
          </ul>
        </div>
        <div id="divAluno">
          <ul>
              <li><a href="FrontController?cmd=trataExibirAtividadeAluno"> Status de Atividades </a></li>

          </ul>
          
        </div>        
    </body>
</html>
