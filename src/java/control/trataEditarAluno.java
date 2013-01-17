/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.AlunoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import model.Aluno;
import model.Usuario;

/**
 *
 * @author Quele
 */
public class trataEditarAluno extends Comando{
    
    @Override
     public void execute() throws ServletException, IOException, SQLException, ClassNotFoundException {
        getResponse().setContentType("text/html;charset=UTF-8");
        PrintWriter out = getResponse().getWriter();
        try {
            int codPessoa = Integer.parseInt(getRequest().getParameter("codPessoa"));
            String nome     = getRequest().getParameter("nome");
            String rg         = getRequest().getParameter("rg");
            int tipopessoa      = Integer.parseInt(getRequest().getParameter("tipopessoa"));
            String nummatricula     = getRequest().getParameter("nummatricula");
            
        
            HttpSession session = getRequest().getSession(false);        
            Usuario value = (Usuario) session.getAttribute("usuario");
        
            Aluno aluno = new Aluno(codPessoa, nome, rg, tipopessoa, nummatricula);
            new AlunoDAO().editar(aluno);
            getResponse().sendRedirect("FrontController?cmd=trataListaAluno");
        
        } catch(SQLException ex){
            throw new ServletException(ex);
        } catch (NullPointerException npe){
            getResponse().sendRedirect("erroNpe.jsp");      
        }
  }
}
