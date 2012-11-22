/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.AtividadeDAO;
import dao.PessoaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Aluno;
import model.Area;
import model.Atividade;
import model.Pessoa;
import model.Professor;
import model.TipoAtividade;
import model.Usuario;

public class TrataEditaPessoa extends Comando {

    @Override
    public void execute() throws ServletException, IOException, SQLException, ClassNotFoundException {
        getResponse().setContentType("text/html;charset=UTF-8");
        PrintWriter out = getResponse().getWriter();
        try {
            int cod = Integer.parseInt(getRequest().getParameter("codPessoa"));
            String nome     = getRequest().getParameter("nome");
            String rg       = getRequest().getParameter("rg");
            String dataNasc = getRequest().getParameter("datanasc");
            
        
            HttpSession session = getRequest().getSession(false);        
            Usuario value = (Usuario) session.getAttribute("usuario");
        
            Pessoa pessoa;
            pessoa = new Pessoa(cod, nome, rg, dataNasc);
            new PessoaDAO().editar(pessoa);
            getResponse().sendRedirect("index.jsp");
        
        } catch(SQLException ex){
            throw new ServletException(ex);
        }
    }


}
