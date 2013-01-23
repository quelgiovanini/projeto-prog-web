/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.AlunoDAO;
import dao.AtividadeDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import model.Aluno;
import model.Area;
import model.Atividade;
import model.Professor;
import model.TipoAtividade;
import model.Usuario;

/**
 * @author Quele
 */

public class trataAnalisarAtividade extends Comando {
    
    @Override
    public void execute() throws ServletException, IOException, SQLException, ClassNotFoundException {
        try {
        getResponse().setContentType("text/html;charset=UTF-8");
        PrintWriter out = getResponse().getWriter();     
        
        Integer codati   = Integer.parseInt(getRequest().getParameter("codati"));
        Integer aluno    = Integer.parseInt(getRequest().getParameter("aluno"));
        Integer tipoAtividade     = Integer.parseInt(getRequest().getParameter("tipoAtividade"));
        Integer professor     = Integer.parseInt(getRequest().getParameter("professor"));
        Integer horas    = Integer.parseInt(getRequest().getParameter("horas"));
        String status   = getRequest().getParameter("status");
        
       // if (status ){ // verificar se status é igual a 'A'
       //verificar se addHoras(horas) é > = que o maximo permitido 
        
            Aluno al = new Aluno(aluno, horas);
            new AlunoDAO().editarhora(al);
        
        Atividade atividades = new Atividade(codati, aluno, tipoAtividade, professor, horas, status);
        new AtividadeDAO().analisar(atividades);
        
        getResponse().sendRedirect("FrontController?cmd=trataExibirAtividade");       
    } catch (SQLException ex) {
            throw new ServletException(ex);
        } catch (NullPointerException npe){
            getResponse().sendRedirect("erroNpe.jsp");      
        }
    }
}
