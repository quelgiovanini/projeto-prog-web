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
    Aluno aluno = (Aluno) obj;
    PreparedStatement stmt;
    
    Connection conexao = DBConnection.getInstance();    
    String sql = (String) dados.get("Aluno.Inserir");
    stmt = conexao.prepareStatement(sql);
    stmt.setInt(1,aluno.getCodPessoa());
    //stmt.setString(1, pessoa.getNomePessoa());
    //stmt.setString(2, pessoa.getRg());
    //stmt.setString(3, pessoa.getDataNascimento()); // a data está hard coded por enquanto até usarmos alguma maneira de validar antes se a data foi digitada corretamente
   
    stmt.execute();
    //conexao.close();
        
  }

  @Override
  public void excluir(Object obj) throws SQLException {
    throw new UnsupportedOperationException("Not supported yet.");
  }  
 
  @Override
  public ArrayList pesquisarTudo() throws SQLException {
    throw new UnsupportedOperationException("Not supported yet.");
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
          aluno.setIngresso(rs.getString(2));
          aluno.setNumMatricula(rs.getString(3));
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
            pro.setNomePessoa(rs.getString(2));
            profList.add(pro);
      }
       pstmt.close();
       return profList;
    }  
  
  @Override
  public void editar(Object obj) throws SQLException {
        Aluno newAluno = (Aluno) obj;   
        Aluno oldAluno = (Aluno) pesquisarChave(newAluno.getCodPessoa()); 
                     
        Connection conexao = DBConnection.getInstance();
        String sql = (String) dados.get("Aluno.Editar");
        PreparedStatement pstmt = conexao.prepareStatement(sql);
        pstmt.setString(1, newAluno.getIngresso());
        pstmt.setString(2, newAluno.getNumMatricula());
        pstmt.setInt(3, oldAluno.getCodPessoa());        
        pstmt.execute();
        pstmt.close();
  }
  
}
