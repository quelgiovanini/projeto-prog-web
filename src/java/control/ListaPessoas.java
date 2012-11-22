/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Usuario;
import dao.PessoaDAO;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author paddock
 */
public class ListaPessoas extends Comando {

    @Override
    public void execute() throws ServletException, IOException, SQLException, ClassNotFoundException {
        getResponse().setContentType("text/html;charset=UTF-8");
        PrintWriter out = getResponse().getWriter();
        try{
            HttpSession session = getRequest().getSession(false);        
            Usuario value = (Usuario) session.getAttribute("usuario");
            
            ArrayList pessoas = new PessoaDAO().pesquisarTudo();
            
            getRequest().setAttribute("data", pessoas);
            RequestDispatcher dispatcher = getRequest().getRequestDispatcher("listaPessoa.jsp");
            if (dispatcher != null){
                dispatcher.forward(getRequest(), getResponse());
            } 

        }catch(SQLException ex){
            throw new ServletException(ex);
        }
    }

}
