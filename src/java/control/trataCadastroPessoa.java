/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.AlunoDAO;
import dao.AtividadeDAO;
import dao.FuncionarioDAO;
import dao.ProfessorDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import model.Aluno;
import model.Atividade;
import model.Funcionario;
import model.Professor;
import model.Usuario;

/**
 *
 * @author Quele
 */
public class trataCadastroPessoa extends Comando {
    
    @Override
    public void execute() throws ServletException, IOException, SQLException, ClassNotFoundException {
        getResponse().setContentType("text/html;charset=UTF-8");
        PrintWriter out = getResponse().getWriter();
        try {
            getResponse().setContentType("text/html");
           
            String nome    = getRequest().getParameter("nome");
            String rg      = getRequest().getParameter("rg");       
            int tipoPessoa = Integer.parseInt(getRequest().getParameter("tipoPessoa")); 

            if (tipoPessoa == 1) {//funcionario
                int setor  = Integer.parseInt(getRequest().getParameter("setor"));
                Funcionario fun = new Funcionario (nome, rg, tipoPessoa, setor);
                new FuncionarioDAO().inserir(fun);
            }
            if (tipoPessoa == 2) {//aluno
                String matricula      = getRequest().getParameter("matricula");
            //  Date dataIngresso =  getRequest().getParameter("");                
                Aluno al = new Aluno(nome, rg, tipoPessoa, matricula);
                new AlunoDAO().inserir(al);   
            }            
            if (tipoPessoa == 3) {//professor
                int area   = Integer.parseInt(getRequest().getParameter("area"));
                Professor pro = new Professor(nome, rg, tipoPessoa, area);
                new ProfessorDAO().inserir(pro);
            } 
            
            HttpSession session = getRequest().getSession(false);        
            Usuario value = (Usuario) session.getAttribute("usuario");
            
            getResponse().sendRedirect("index.jsp");
        
        } catch(SQLException ex){
            throw new ServletException(ex);
        } catch (NullPointerException npe){
            getResponse().sendRedirect("erroNpe.jsp");      
        }
    }
}
