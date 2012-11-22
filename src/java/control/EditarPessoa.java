/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.PessoaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Pessoa;
import model.Usuario;

public class EditarPessoa extends Comando {

    @Override
    public void execute() throws ServletException, IOException, SQLException, ClassNotFoundException {
        getResponse().setContentType("text/html;charset=UTF-8");
        PrintWriter out = getResponse().getWriter();
        try{
            HttpSession session = getRequest().getSession(false);        
            Usuario value = (Usuario) session.getAttribute("usuario");
            
            Pessoa pessoa = (Pessoa) new PessoaDAO().pesquisarChave(1);
            
            getRequest().setAttribute("data", pessoa);
            RequestDispatcher dispatcher = getRequest().getRequestDispatcher("editaPessoa.jsp");
            if (dispatcher != null){
                dispatcher.forward(getRequest(), getResponse());
            } 

        }catch(SQLException ex){
            throw new ServletException(ex);
        }
        
    }

   
   
}
