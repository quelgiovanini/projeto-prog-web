/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.AtividadeDAO;
import dao.FuncionarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Quele
 */
public class trataExcluirFuncionario extends Comando {
    
    @Override
    public void execute() throws ServletException, IOException, SQLException, ClassNotFoundException {
        getResponse().setContentType("text/html;charset=UTF-8");
        PrintWriter out = getResponse().getWriter();
  //      try {
            String codfun = getRequest().getParameter("codfun");
            
            HttpSession session = getRequest().getSession(false);        
        
            new FuncionarioDAO().remover(codfun);
            
            getResponse().sendRedirect("FrontController?cmd=trataListaFuncionario");
        
 //       } catch(SQLException ex){
 //           throw new ServletException(ex);
        }
    }
