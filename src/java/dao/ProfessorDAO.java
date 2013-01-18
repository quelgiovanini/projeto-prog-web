/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import database.DBConnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import model.Aluno;
import model.Funcionario;
import model.Professor;
import util.PropertiesManager;

/**
 *
 * @author Quele
 */
public class ProfessorDAO implements InterfaceDAO{
     
  private HashMap dados;
  
  public ProfessorDAO() throws IOException{
    dados = new PropertiesManager("sql.properties").readPropertiesFile();
  }

  @Override
  public void inserir(Object obj) throws SQLException {
    Professor prof = (Professor) obj;
    
    Connection conexao = DBConnection.getInstance();    
    String sql = (String) dados.get("Professor.Inserir");
    PreparedStatement pstmt = conexao.prepareStatement(sql);
  //  pstmt.setInt(1,func.getCodPessoa());
    pstmt.setString(1, prof.getNome());
    pstmt.setString(2, prof.getRg());
    pstmt.setInt(3, prof.getTipoPessoa());
    pstmt.setInt(4, prof.getArea());
   
    try {
            pstmt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        pstmt.close();
    }

  @Override
  public void excluir(Object obj) throws SQLException {
    throw new UnsupportedOperationException("Not supported yet.");
  }  
 
        public String remover(String codpr) throws SQLException {
        String retorno = "erro";                 

        Connection conexao = DBConnection.getInstance();
        try{
            String sql = (String) dados.get("Delete.Professor");
            PreparedStatement pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1, codpr);
            pstmt.execute();
            retorno = "sucesso";
            pstmt.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return retorno;
        
    }  
  
  @Override
    public ArrayList pesquisarTudo() throws SQLException {
      ArrayList profList = new ArrayList();
      Connection conexao = DBConnection.getInstance();
      String sql = (String) dados.get("SelectAll.Professor");
      PreparedStatement pstmt = conexao.prepareStatement(sql) ;
      ResultSet rs = pstmt.executeQuery();
      
      while (rs.next()) {

          Professor professor = new Professor(); 
          professor.setNome(rs.getString(1));
          professor.setRg(rs.getString(2));
          professor.setTipoPessoa(rs.getInt(3));
          professor.setArea(rs.getInt(4));
          professor.setCodPessoa(rs.getInt(5));

          profList.add(professor);
      }
       pstmt.close();
       return profList;
    } 

  @Override
  public Object pesquisarChave(int chave) throws SQLException {
      Aluno aluno = null;
      
      Connection conexao = DBConnection.getInstance();
      String sql = (String) dados.get("Aluno.BuscaPorCod");
      PreparedStatement pstmt = conexao.prepareStatement(sql);
      pstmt.setInt(1, chave);
      ResultSet rs = pstmt.executeQuery();
      if(rs.next()){
          aluno.setCodPessoa(rs.getInt(1));
      //    aluno.setIngresso(rs.getString(2));
      //    aluno.setNumMatricula(rs.getString(3));
      }
      return aluno;
  }

     public ArrayList pesquisarTipo() throws SQLException {
      ArrayList profList = new ArrayList();
      Connection conexao = DBConnection.getInstance();
      String sql = (String) dados.get("SelectUser.Professor");
      PreparedStatement pstmt = conexao.prepareStatement(sql) ;
      ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
            Professor pro = new Professor();
            pro.setCodPessoa(rs.getInt(1));
            pro.setNome(rs.getString(2));
            profList.add(pro);
      }
       pstmt.close();
       return profList;
    }  
     
     public Professor pesquisarCod(String codPro) throws SQLException {
      //ArrayList ativList = new ArrayList();
      Connection conexao = DBConnection.getInstance();
        Professor pro = null;
        String sql = (String) dados.get("SelectById.Professor");
        PreparedStatement pstmt = conexao.prepareStatement(sql);
        pstmt.setString(1, codPro);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            pro = new Professor(); 
            pro.setCodPessoa(rs.getInt(1));
            pro.setNome(rs.getString(2));
            pro.setRg(rs.getString(3));
            pro.setTipoPessoa(rs.getInt(4));
            pro.setArea(rs.getInt(5));   
        }
        pstmt.close();
        return pro;
    }
     
   public String editar(Professor professor) throws SQLException {
        String retorno = "erro";                 
        
        Connection conexao = DBConnection.getInstance();
        try{
            String sql = (String) dados.get("Update.Professor");
            PreparedStatement pstmt = conexao.prepareStatement(sql);
            
            pstmt.setString(1, professor.getNome());
            pstmt.setString(2, professor.getRg());
            pstmt.setInt(3, professor.getTipoPessoa());
            pstmt.setInt(4, professor.getArea());
            pstmt.setInt(5, professor.getCodPessoa());            

            pstmt.execute();
            retorno = "sucesso";

            pstmt.close();
        }catch(Exception ex){
            ex.printStackTrace();
            
        }
        return retorno;

    }     
  
  @Override
  public void editar(Object obj) throws SQLException {
       throw new UnsupportedOperationException("Not supported yet.");
  }
  
}
