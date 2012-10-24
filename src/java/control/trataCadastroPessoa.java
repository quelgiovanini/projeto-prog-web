/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.AlunoDAO;
import dao.PessoaDAO;
import dao.FuncionarioDAO;
import database.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Aluno;
import model.Pessoa;
import model.Curriculo;
import model.Funcionario;

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String nome    = request.getParameter("nome");
        String rg      = request.getParameter("rg");
        String dtNasc  = request.getParameter("datanasc");
        String email   = request.getParameter("email");
        String matricula = request.getParameter("matricula");
        String ingresso  = request.getParameter("ingresso");
        int tipoPessoa = Integer.parseInt(request.getParameter("tipopessoa")); 
        Pessoa pessoa = new Pessoa(nome, rg, dtNasc);
        pessoa.setNomePessoa(nome);       
        
        try {          
          new PessoaDAO().inserir(pessoa);
        } catch (SQLException ex) {            
            throw new ServletException("Erro ao tentar inserir pessoa: "+ex);
        }
        
        int codPessoa = new PessoaDAO().getCodPessoaPorObjeto(pessoa);
        
        if (tipoPessoa == 1){
          Aluno aluno = new Aluno(codPessoa,nome, email, matricula, ingresso);          
          try{
            new AlunoDAO().inserir(aluno);
          } catch (SQLException ex) {            
              throw new ServletException("Erro ao tentar inserir aluno "+": "+ex);
          }
        }else{
          int tipoFunc = 0;
          if (tipoPessoa == 2){
            tipoFunc = 1;
          }else if(tipoPessoa == 3){
            tipoFunc = 2;
          }
          Funcionario func = new Funcionario(codPessoa, nome, email, matricula, tipoFunc, 1, 1);
          try{
            new FuncionarioDAO().inserir(func);
          } catch (SQLException ex) {            
              throw new ServletException("Erro ao tentar inserir funcionario "+codPessoa+": "+ex);
          }
        }
        
        /* TODO output your page here. You may use following sample code. */
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Cadastro realizado</title>");            
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Pessoa cadastrada com sucesso</h1>");
        out.println("</body>");
        out.println("</html>");            
        
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(trataCadastroPessoa.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(trataCadastroPessoa.class.getName()).log(Level.SEVERE, null, ex);
        }
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
