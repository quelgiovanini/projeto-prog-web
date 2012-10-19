/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.AtividadeDAO;
import DAO.UsuarioDAO;
import Database.DBConnection;
import Model.Aluno;
import Model.Area;
import Model.Atividade;
import Model.Professor;
import Model.TipoAtividade;
import Model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Quele
 */

@WebServlet(name = "trataAnaliseAtividade", urlPatterns = {"/trataAnaliseAtividade"})
public class trataAnaliseAtividade extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException{
        super.init(config);
        
        //Recupera o contexto da aplicação para inicializar o banco de dados
        try {
        ServletContext context = getServletContext();
        String user = (String) context.getInitParameter("user");
        String senha = (String) context.getInitParameter("senha");
        String driver = (String) context.getInitParameter("driver");
        String url = (String) context.getInitParameter("url");
        
        new DBConnection(user, senha, driver, url);
        
//        conexao = DriverManager.getConnection(url, user, senha);
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
        String aluno = request.getParameter("aluno");
        String tp = request.getParameter("tipo");
        String prof = request.getParameter("prof");
        String status = request.getParameter("sta");
        
        HttpSession session = request.getSession(false);
        
        Usuario value = (Usuario) session.getAttribute("usuario");
        
        Atividade ativ = new Atividade(new Aluno(aluno,"teste","0120","2012"), new TipoAtividade(tp), new Professor(prof,"teste","0012",Area.INFORMATICA), status);
        new AtividadeDAO().inserir(ativ);
            
            out.println();
            out.println("<html><head><title> .:: SIATICO ::. </head></title>");
            out.println("<body>");
            out.println("<h1> Atividade em analise </h1>");
            out.println("<a href='index.jsp'> Voltar </a>");
            out.println("</body>");
            out.println("</html>");
            
        } catch(SQLException ex){
            throw new ServletException(ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
