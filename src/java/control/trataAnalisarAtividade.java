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
 * @author Quele
 */

public class trataAnalisarAtividade extends Comando {
    
    @Override
    public void execute() throws ServletException, IOException, SQLException {
        getResponse().setContentType("text/html;charset=UTF-8");
        PrintWriter out = getResponse().getWriter();
        
        Integer codati   = Integer.parseInt(getRequest().getParameter("codati"));
        Integer aluno    = Integer.parseInt(getRequest().getParameter("aluno"));
        Integer tipoAtividade     = Integer.parseInt(getRequest().getParameter("tipoAtividade"));
        Integer professor     = Integer.parseInt(getRequest().getParameter("professor"));
        String status   = getRequest().getParameter("status");
        
        Atividade atividades = new Atividade(codati, aluno, tipoAtividade, professor, status);
        new AtividadeDAO().editar(atividades);
        getResponse().sendRedirect("FrontController?cmd=trataExibirAtividade");       
    }
}
