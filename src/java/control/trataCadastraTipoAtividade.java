/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.TipoAtividadeDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import model.TipoAtividade;

/**
 * @author Quele
 */
public class trataCadastraTipoAtividade extends Comando{

    @Override
   public void execute() throws ServletException, IOException, SQLException, ClassNotFoundException {
        getResponse().setContentType("text/html;charset=UTF-8");
        PrintWriter out = getResponse().getWriter();
        try {
            getResponse().setContentType("text/html");
         
            String descricaoTipo     = getRequest().getParameter("descricaoTipo");
            double proporcao         = Double.parseDouble(getRequest().getParameter("proporcao"));
            int maximoPermitido      = Integer.parseInt(getRequest().getParameter("maximoPermitido"));

            TipoAtividade tipo = new TipoAtividade(descricaoTipo, proporcao, maximoPermitido);   
            
            new TipoAtividadeDAO().inserir(tipo);
            
            getResponse().sendRedirect("index.jsp");
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }  catch (NullPointerException npe){
            getResponse().sendRedirect("erroNpe.jsp");      
        }
    }

}