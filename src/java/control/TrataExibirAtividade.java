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
import javax.servlet.ServletException;
import model.Atividade;

/**
 *
 * @author Quele
 */
public class TrataExibirAtividade  extends Comando {
    
    @Override
   public void execute() throws ServletException, IOException, SQLException, ClassNotFoundException {
        getResponse().setContentType("text/html;charset=UTF-8");
        PrintWriter out = getResponse().getWriter();
        try {
            ArrayList lista = new AtividadeDAO().pesquisarTudo();
            out.println("<html>");
            out.println("<head>");
            out.println("<title> .:: SIATICO ::. </title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<table>");
            Iterator it = lista.iterator();
            while (it.hasNext()) {
                Atividade ativ = (Atividade) it.next();
                
                out.println("<TR>");
                out.println("<TD> Aluno :" + ativ.getAluno() + " </TD>");
                out.println("<TD> Tipo Atividade :" + ativ.getTipoAtividade() + " </TD>");
                out.println("<TD> Professor :" + ativ.getProfessorResponsavel() + " </TD>");
                out.println("<TD> Status:" + ativ.getStatus() + " </TD>");
                out.println("</TR>"); 
            }
            out.println("</table>");
            out.println("<P><a href='index.jsp'> Voltar  </a></P>");
            out.println("</body>");
            out.println("</html>");
        } catch (IOException ioex) {
            throw new ServletException(ioex);
        } catch(SQLException sqlex){
              throw new ServletException (sqlex);
        }
    }

}
