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

public class TrataAnalisarAtividade extends Comando {
    
    @Override
    public void execute()
            throws ServletException, IOException, SQLException {
     //   getResponse().setContentType("text/html;charset=UTF-8");
        PrintWriter out = getResponse().getWriter();
        Integer codigo   = Integer.parseInt(getRequest().getParameter("codati"));
        Integer aluno    = Integer.parseInt(getRequest().getParameter("aluno"));
        Integer tipo     = Integer.parseInt(getRequest().getParameter("tipo"));
        Integer professor     = Integer.parseInt(getRequest().getParameter("professor"));
        String status   = getRequest().getParameter("status");
        
        Atividade atividade = new Atividade();
        atividade.setIdAtividade(codigo);
        atividade.getAluno().setCodPessoa(aluno);
        atividade.getTipoAtividade().setIdTipo(tipo);
        atividade.getProfessorResponsavel().setCodPessoa(professor);
        atividade.setStatus(status);
        
        Atividade atividades = new Atividade(aluno, tipo, professor, status);
        new AtividadeDAO().editar(atividades);
        getResponse().sendRedirect("FrontController?cmd=trataListaAtividade");       
    }
}
