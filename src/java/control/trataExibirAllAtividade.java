/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.AtividadeDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import model.Atividade;
import model.Usuario;

/**
 * @author Quele
 */

public class trataExibirAllAtividade  extends Comando {
    
    
    @Override
    public void execute() throws ServletException, IOException, SQLException, ClassNotFoundException {
        getResponse().setContentType("text/html;charset=UTF-8");
        PrintWriter out = getResponse().getWriter();
        try{
            HttpSession session = getRequest().getSession(false);        
            Usuario user = (Usuario) session.getAttribute("usuario");
            Integer us = user.getId();
            
            ArrayList atividades = new AtividadeDAO().listaAllAtividade(us);
            
            getRequest().setAttribute("dados", atividades);
            
            RequestDispatcher dispatcher = getRequest().getRequestDispatcher("exibirAllAtividade.jsp");
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
