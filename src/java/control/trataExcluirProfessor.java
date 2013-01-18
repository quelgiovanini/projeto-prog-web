/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.AtividadeDAO;
import dao.ProfessorDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Quele
 */
public class trataExcluirProfessor extends Comando {
    
    @Override
    public void execute() throws ServletException, IOException, SQLException, ClassNotFoundException {
        getResponse().setContentType("text/html;charset=UTF-8");
        PrintWriter out = getResponse().getWriter();
  //      try {
            String codpro = getRequest().getParameter("codPessoa");
            
            HttpSession session = getRequest().getSession(false);        
        
            new ProfessorDAO().remover(codpro);
            
            getResponse().sendRedirect("FrontController?cmd=trataListaProfessor");
        
 //       } catch(SQLException ex){
 //           throw new ServletException(ex);
        }
    }
