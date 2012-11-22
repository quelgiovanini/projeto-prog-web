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
import model.Aluno;
import model.Area;
import model.Atividade;
import model.Professor;
import model.TipoAtividade;
import model.Usuario;

/**
 *
 * @author Quele
 */

public class TrataCadastroAtividade extends Comando {

    
    @Override
    public void execute() throws ServletException, IOException, SQLException, ClassNotFoundException {
        getResponse().setContentType("text/html;charset=UTF-8");
        PrintWriter out = getResponse().getWriter();
        try {
            String cod    = getRequest().getParameter("cod");            
            String aluno  = getRequest().getParameter("aluno");
            String tp     = getRequest().getParameter("tipo");
            String prof   = getRequest().getParameter("prof");
            String status = getRequest().getParameter("sta");
        
            HttpSession session = getRequest().getSession(false);        
            Usuario value = (Usuario) session.getAttribute("usuario");
        
            Atividade ativ = new Atividade(cod,new Aluno(aluno,"teste","0120","2012"), new TipoAtividade(tp), new Professor(prof,"teste","0012",Area.INFORMATICA), status);
            new AtividadeDAO().inserir(ativ);
            getResponse().sendRedirect("atividadeCadastrada.jsp");
        
        } catch(SQLException ex){
            throw new ServletException(ex);
        }
    }
}