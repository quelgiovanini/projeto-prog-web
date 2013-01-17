/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.CursoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Quele
 */
public class trataExcluirCurso extends Comando{
    
    @Override
    public void execute() throws ServletException, IOException, SQLException, ClassNotFoundException {
        getResponse().setContentType("text/html;charset=UTF-8");
        PrintWriter out = getResponse().getWriter();
  //      try {
            String codCurso = getRequest().getParameter("codCurso");
            
            HttpSession session = getRequest().getSession(false);        
        
            new CursoDAO().remover(codCurso);
            
            getResponse().sendRedirect("FrontController?cmd=trataListaCurso");
        
 //       } catch(SQLException ex){
 //           throw new ServletException(ex);
        }
    }
