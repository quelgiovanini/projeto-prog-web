/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.UsuarioDAO;
import Database.DBConnection;
import Model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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

@WebServlet(name = "trataLogin", urlPatterns = {"/trataLogin"})
public class trataLogin extends HttpServlet {


    private Connection conexao;
    
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
        out.println();
        String login = request.getParameter("Login");
        String senha = request.getParameter("Senha");
        try {
            Usuario user = new UsuarioDAO().pesquisarLogin(login);
            if (user != null && user.getSenha().equals(senha)){
                //cria objeto de sessão que identifica o usuario
                HttpSession session = request.getSession(true);
                session.setAttribute("usuario",user);
                //Redireciona para outra página
                response.sendRedirect("analiseHoras.html");
            } else {
                out.println("<h1> Falha durante a execução </h1>");
                response.sendRedirect("login.tml");
            }
            out.close();
        } catch (Exception ex) {
            throw new ServletException (ex);
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
