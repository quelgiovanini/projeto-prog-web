/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.AtividadeDAO;
import dao.TipoAtividadeDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import model.Atividade;
import model.TipoAtividade;
import model.Usuario;

/**
 *
 * @author Quele
 */

public class trataCadastroAtividade extends Comando {

    
    @Override
    public void execute() throws ServletException, IOException, SQLException, ClassNotFoundException {
        getResponse().setContentType("text/html;charset=UTF-8");
        PrintWriter out = getResponse().getWriter();
    
        try {
            getResponse().setContentType("text/html");

            HttpSession session = getRequest().getSession(false);        
            Usuario value = (Usuario) session.getAttribute("usuario");
            

            
        //    Integer codAtiv    = Integer.parseInt(getRequest().getParameter("codAtiv"));            
            int aluno  = Integer.parseInt(getRequest().getParameter("aluno"));
            int tipoAtividade     = Integer.parseInt(getRequest().getParameter("tipoAtividade"));
            int professor   = Integer.parseInt(getRequest().getParameter("professor"));
            int user = value.getId();
            int horasRequisitadas = Integer.parseInt(getRequest().getParameter("horasRequisitadas"));
            String status = "E";

        
            Atividade ativ = new Atividade(aluno, tipoAtividade, professor, user, horasRequisitadas, status);
            new AtividadeDAO().inserir(ativ);
            
            getResponse().sendRedirect("index.jsp");

        } catch (NullPointerException npe){
            getResponse().sendRedirect("erroNpe.jsp"); 
        } 
  }
}