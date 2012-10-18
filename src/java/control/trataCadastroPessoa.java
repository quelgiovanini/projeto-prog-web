/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import database.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Pessoa;

/**
 *
 * @author 0163090
 */
@WebServlet(name = "trataCadastroPessoa", urlPatterns = {"/trataCadastroPessoa"})
public class trataCadastroPessoa extends HttpServlet {
    
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        
        try {
            ServletContext context = getServletContext();
            String user = (String) context.getInitParameter("user");
            String senha = (String) context.getInitParameter("senha");
            String driver = (String) context.getInitParameter("driver");
            String url = (String) context.getInitParameter("url");
          
            new DBConnection(user, senha, driver, url);
            
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String nome   = request.getParameter("nome");
            String rg     = request.getParameter("rg");
            String dtNasc = request.getParameter("datanasc");           

            Pessoa value = new Pessoa();
            value.setDataNascimento(dtNasc);
            value.setRg(rg);
            value.setNomePessoa(nome);
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Cadastro realizado</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet trataCadastroPessoa at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
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
