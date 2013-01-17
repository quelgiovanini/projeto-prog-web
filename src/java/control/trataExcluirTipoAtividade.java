/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.AtividadeDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Quele
 */
public class trataExcluirTipoAtividade extends Comando{
    
    @Override
    public void execute() throws ServletException, IOException, SQLException, ClassNotFoundException {
        getResponse().setContentType("text/html;charset=UTF-8");
        PrintWriter out = getResponse().getWriter();
  //      try {
            String codtip = getRequest().getParameter("codtip");
            
            HttpSession session = getRequest().getSession(false);        
        
            new AtividadeDAO().remover(codtip);
            
            getResponse().sendRedirect("FrontController?cmd=trataListaTipoAtividade");
        
 //       } catch(SQLException ex){
 //           throw new ServletException(ex);
        }
    }