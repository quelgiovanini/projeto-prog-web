package control;

import dao.AlunoDAO;
import dao.FuncionarioDAO;
import dao.PessoaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import model.Aluno;
import model.Funcionario;
import model.Pessoa;

/**
 *
 * @author 0163090
 */

public class TrataCadastroPessoas extends Comando {    
         
    @Override
    public void execute()
            throws ServletException, IOException, SQLException {
        getResponse().setContentType("text/html;charset=UTF-8");
        PrintWriter out = getResponse().getWriter();
        String nome    = getRequest().getParameter("nome");
        String rg      = getRequest().getParameter("rg");
        String dtNasc  = getRequest().getParameter("datanasc");
        String email   = getRequest().getParameter("email");
        String matricula = getRequest().getParameter("matricula");
        String ingresso  = getRequest().getParameter("ingresso");
        int tipoPessoa = Integer.parseInt(getRequest().getParameter("tipopessoa")); 
        Pessoa pessoa = new Pessoa(nome, rg, dtNasc);
        pessoa.setNomePessoa(nome);       
        
        /*try {          
          new PessoaDAO().inserir(pessoa);
        } catch (SQLException ex) {            
            throw new ServletException("Erro ao tentar inserir pessoa: "+ex);
        }*/
        
        int codPessoa = new PessoaDAO().getCodPessoaPorObjeto(pessoa);
        
        if (tipoPessoa == 1){
          Aluno aluno = new Aluno(codPessoa,nome, email, matricula, ingresso);          
          try{
            new AlunoDAO().inserir(aluno);
          } catch (SQLException ex) {            
              throw new ServletException("Erro ao tentar inserir aluno "+": "+ex);
          }
        }else{
          int tipoFunc = 0;
          if (tipoPessoa == 2){
            tipoFunc = 1;
          }else if(tipoPessoa == 3){
            tipoFunc = 2;
          }
          Funcionario func = new Funcionario(codPessoa, nome, email, matricula, tipoFunc, 1, 1);
          /*try{
            new FuncionarioDAO().inserir(func);
          } catch (SQLException ex) {            
              throw new ServletException("Erro ao tentar inserir funcionario "+codPessoa+": "+ex);
          }*/
        }       
        getResponse().sendRedirect("listaPessoa.jsp");
        
    }

}
