/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.FuncionarioDAO;
import dao.ProfessorDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import model.Usuario;

/**
 *
 * @author Quele
 */
public class trataListaProfessor extends Comando {
        
    @Override
    public void execute() throws ServletException, IOException, SQLException, ClassNotFoundException {
        getResponse().setContentType("text/html;charset=UTF-8");
        PrintWriter out = getResponse().getWriter();
        try{
            HttpSession session = getRequest().getSession(false);        
            Usuario value = (Usuario) session.getAttribute("usuario");
            
            ArrayList professores = new ProfessorDAO().pesquisarTudo();
            
            getRequest().setAttribute("dados", professores);
            
            RequestDispatcher dispatcher = getRequest().getRequestDispatcher("listaProfessor.jsp");
            if (dispatcher != null){
                
                dispatcher.forward(getRequest(), getResponse());
            }

        }catch(SQLException ex){
            throw new ServletException(ex);
        } catch (NullPointerException npe){
            getResponse().sendRedirect("erroNpe.jsp");      
        }
    }

}
