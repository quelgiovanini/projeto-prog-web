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
        </ul>  
        </div>    

        <div id="divFuncionario">
          <ul>
              <li><a href="cadastraPessoa.jsp"> Cadastrar Pessoas </a><br/></li>
              <li><a href="cadastraAtividade.jsp"> Cadastrar Atividade </a><br/></li>
              <li><a href="cadastraTipoAtividade.jsp"> Cadastrar Tipo Atividade </a><br/></li>
              <li><a href="listaTipoAtividade.jsp"> Listar Tipos de Atividade </a><br/></li>
              <li><a href="cadastraCurso.jsp"> Cadastrar Cursos </a><br/></li>
              <li><a href="listaCurso.jsp"> Listar Cursos </a><br/></li>              
              
          </ul>
          
          <form action="FrontController" method="POST">
              <input type="hidden" name="cmd" value="listaPessoas" />
              <input type="submit" value="Listar pessoas" />
          </form>
        </div>
    </body>
</html>
