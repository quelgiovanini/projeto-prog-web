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

public class TrataCadastroCurriculo extends Comando {
    
    @Override
    public void execute()
            throws ServletException, IOException {
        getResponse().setContentType("text/html;charset=UTF-8");
        PrintWriter out = getResponse().getWriter();
        try {
            String curso           = getRequest().getParameter("curso");            
            String semestreInicio  = getRequest().getParameter("semestreInicio");
            
        HttpSession session = getRequest().getSession(false);
        
        Usuario value = (Usuario) session.getAttribute("usuario");
        
        
        
            
        //getResponse().sendRedirect("");
            
        } catch(SQLException ex){
            throw new ServletException(ex);
        }
    }

    
}
