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

public class TrataAnaliseAtividade extends Comando {
    
    @Override
    public void execute()
            throws ServletException, IOException, SQLException {
     //   getResponse().setContentType("text/html;charset=UTF-8");
        PrintWriter out = getResponse().getWriter();
        String codigo   = getRequest().getParameter("codati");
        String aluno    = getRequest().getParameter("aluno");
        String tipo     = getRequest().getParameter("tipo");
        String prof     = getRequest().getParameter("prof");
        String status   = getRequest().getParameter("status");
        
        Atividade atividade = new Atividade();
        atividade.setIdAtividade(codigo);
        atividade.getAluno().setNomePessoa(aluno);
        atividade.getTipoAtividade().setDescricaoTipo(tipo);
        atividade.getProfessorResponsavel().setNomePessoa(prof);
        atividade.setStatus(status);
        
        AtividadeDAO dao = new AtividadeDAO();
        String retorno = dao.editar(atividade);
        if (retorno.equals("sucesso")) {
            getResponse().sendRedirect("index.jsp");
        }
            out.println();
            out.println("<html><head><title> .:: SIATICO ::. </head></title>");
            out.println("<body>");
            out.println("<h1> Análise não realizada </h1>");
            out.println("<br>");
            out.println("<a href='index.jsp'> Voltar </a>");
            out.println("</body>");
            out.println("</html>");
            
    }
}
