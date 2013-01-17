/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.CursoDAO;
import dao.TipoAtividadeDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import model.Curso;
import model.TipoAtividade;

/**
 *
 * @author Quele
 */
public class trataCadastraCurso extends Comando {
   public void execute() throws ServletException, IOException, SQLException, ClassNotFoundException {
        getResponse().setContentType("text/html;charset=UTF-8");
        PrintWriter out = getResponse().getWriter();
        try {
            getResponse().setContentType("text/html");
         
            String nomeCurso     = getRequest().getParameter("nomeCurso");
            int coordenador         = Integer.parseInt(getRequest().getParameter("coordenador"));
            int codArea      = Integer.parseInt(getRequest().getParameter("codArea"));

            Curso curso = new Curso(nomeCurso, coordenador, codArea);   
            
            new CursoDAO().inserir(curso);
            
            getResponse().sendRedirect("index.jsp");
        } catch (SQLException ex) {
            throw new ServletException(ex);
        } 
    }

}