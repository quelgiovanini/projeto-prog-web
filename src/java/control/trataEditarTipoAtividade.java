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
import javax.servlet.http.HttpSession;
import model.TipoAtividade;
import model.Usuario;

/**
 *
 * @author Quele
 */
public class trataEditarTipoAtividade extends Comando {
   
    public void execute() throws ServletException, IOException, SQLException, ClassNotFoundException {
        getResponse().setContentType("text/html;charset=UTF-8");
        PrintWriter out = getResponse().getWriter();
  //      try {
            
            Integer codtip = Integer.parseInt(getRequest().getParameter("codtip"));
            String descricaoTipo = getRequest().getParameter("descricaoTipo");
            Double proporcao         = Double.parseDouble(getRequest().getParameter("proporcao"));
            Integer maximoPermitido = Integer.parseInt(getRequest().getParameter("maximoPermitido"));
        
            HttpSession session = getRequest().getSession(false);        
            Usuario value = (Usuario) session.getAttribute("usuario");
        
            TipoAtividade tpAtiv = new TipoAtividade(codtip, descricaoTipo, proporcao, maximoPermitido);
            new TipoAtividadeDAO().editar(tpAtiv);
            getResponse().sendRedirect("FrontController?cmd=trataListaTipoAtividade");
        
 //       } catch(SQLException ex){
 //           throw new ServletException(ex);
        }
 }
