/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import database.DBConnection;
import model.*;
import util.PropertiesManager;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Quele
 */

public class AtividadeDAO implements InterfaceDAO {

    private HashMap dados;
    
    public AtividadeDAO() throws IOException{
        
        dados = new PropertiesManager("sql.properties").readPropertiesFile();
        
    }    
    
    @Override
    public void inserir (Object obj) throws SQLException {
        Atividade atividades = (Atividade) obj;        
                     
        Connection conexao = DBConnection.getInstance();
        String sql = (String) dados.get("Insert.Atividade");
        PreparedStatement pstmt = conexao.prepareStatement(sql);
   //     pstmt.setInt(1, atividades.getIdAtividade());
        pstmt.setInt(1, atividades.getCodAluno());
        pstmt.setInt(2, atividades.getCodTipoAtividade());
        pstmt.setInt(3, atividades.getCodProfessor());
        pstmt.setInt(4, atividades.getCodFuncionario());
        pstmt.setInt(5, atividades.getHorasRequisitadas());
        pstmt.setString(6, atividades.getStatus());
        
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
    
    public String remover(String codati) throws SQLException {
        String retorno = "erro";                 

        Connection conexao = DBConnection.getInstance();
        try{
            String sql = (String) dados.get("Delete.Atividade");
            PreparedStatement pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1, codati);
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
      ArrayList ativList = new ArrayList();
      Connection conexao = DBConnection.getInstance();
      String sql = (String) dados.get("SelectAll.Atividade");
      PreparedStatement pstmt = conexao.prepareStatement(sql) ;
      ResultSet rs = pstmt.executeQuery();
      
      while (rs.next()) {

          Atividade atividade = new Atividade(); 
          atividade.getAluno().setCodPessoa(rs.getInt(1));
          atividade.getTipoAtividade().setIdTipo(rs.getInt(2));
          atividade.getProfessorResponsavel().setCodPessoa(rs.getInt(3));
          atividade.setStatus(rs.getString(4));
          atividade.setIdAtividade(rs.getInt(5));

          ativList.add(atividade);
      }
       pstmt.close();
       return ativList;
    } 
    
    public Atividade pesquisarCod(String cod) throws SQLException {
      //ArrayList ativList = new ArrayList();
      Connection conexao = DBConnection.getInstance();
        Atividade ativ = null;
        String sql = (String) dados.get("SelectById.Atividade");
        PreparedStatement pstmt = conexao.prepareStatement(sql);
        pstmt.setString(1, cod);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            ativ = new Atividade(); 
            ativ.setIdAtividade(rs.getInt(1));
            ativ.getAluno().setCodPessoa(rs.getInt(2));
            ativ.getAluno().setNome(rs.getString(3));
            ativ.getTipoAtividade().setIdTipo(rs.getInt(4));
            ativ.getTipoAtividade().setDescricaoTipo(rs.getString(5));
            ativ.getProfessorResponsavel().setCodPessoa(rs.getInt(6));
            ativ.getProfessorResponsavel().setNome(rs.getString(7));
            ativ.setStatus(rs.getString(8));
            ativ.setHorasAceitas(rs.getInt(9));
        }
        return ativ;
    }    

    @Override
    public Object pesquisarChave(int chave) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void editar(Object obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public String editar(Atividade atividade) throws SQLException {
        String retorno = "erro";                 
        
        Connection conexao = DBConnection.getInstance();
        try{
            String sql = (String) dados.get("Update.Atividade");
            PreparedStatement pstmt = conexao.prepareStatement(sql);
            
            pstmt.setInt(1, atividade.getAluno().getCodPessoa());
            pstmt.setInt(2, atividade.getTipoAtividade().getIdTipo());
            pstmt.setInt(3, atividade.getProfessorResponsavel().getCodPessoa());
            pstmt.setString(4, atividade.getStatus());
            pstmt.setInt(5, atividade.getIdAtividade());
            pstmt.execute();
            retorno = "sucesso";
            pstmt.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return retorno;
    }
    
    public ArrayList listaTudo() throws SQLException {
      ArrayList ativList = new ArrayList();
      Connection conexao = DBConnection.getInstance();
      String sql = (String) dados.get("Lista.Atividade");
      PreparedStatement pstmt = conexao.prepareStatement(sql) ;
      ResultSet rs = pstmt.executeQuery();
      
      while (rs.next()) {

          Atividade atividade = new Atividade(); 
          atividade.getAluno().setNome(rs.getString(1));
          atividade.getTipoAtividade().setDescricaoTipo(rs.getString(2));
          atividade.getProfessorResponsavel().setNome(rs.getString(3));
          atividade.setStatus(rs.getString(4));
          atividade.setIdAtividade(rs.getInt(5));

          ativList.add(atividade);
      }
       pstmt.close();
       return ativList;
    } 
    
    public ArrayList listaAllAtividade() throws SQLException {
      ArrayList ativList = new ArrayList();
      Connection conexao = DBConnection.getInstance();
      String sql = (String) dados.get("ListaAllAtividade.Atividade");
      PreparedStatement pstmt = conexao.prepareStatement(sql) ;
      ResultSet rs = pstmt.executeQuery();
      
      while (rs.next()) {

          Atividade atividade = new Atividade(); 
          atividade.getAluno().setNome(rs.getString(1));
          atividade.getTipoAtividade().setDescricaoTipo(rs.getString(2));
          atividade.getProfessorResponsavel().setNome(rs.getString(3));
          atividade.setStatus(rs.getString(4));
          atividade.setIdAtividade(rs.getInt(5));

          ativList.add(atividade);
      }
       pstmt.close();
       return ativList;
    }    
    
    public ArrayList listaAll() throws SQLException {
      ArrayList ativList = new ArrayList();
      Connection conexao = DBConnection.getInstance();
      String sql = (String) dados.get("ListaAll.Atividade");
      PreparedStatement pstmt = conexao.prepareStatement(sql) ;
      ResultSet rs = pstmt.executeQuery();
      
      while (rs.next()) {

          Atividade atividade = new Atividade(); 
          atividade.getAluno().setCodPessoa(rs.getInt(1));
          atividade.getAluno().setNome(rs.getString(2));
          atividade.getTipoAtividade().setIdTipo(rs.getInt(3));
          atividade.getTipoAtividade().setDescricaoTipo(rs.getString(4));
          atividade.getProfessorResponsavel().setCodPessoa(rs.getInt(5));
          atividade.getProfessorResponsavel().setNome(rs.getString(6));
          atividade.setStatus(rs.getString(7));
          atividade.setHorasAceitas(rs.getInt(8));
          atividade.setIdAtividade(rs.getInt(9));

          ativList.add(atividade);
      }
       pstmt.close();
       return ativList;
    }     

    public ArrayList listaAluno() throws SQLException {
      ArrayList ativList = new ArrayList();
      Connection conexao = DBConnection.getInstance();
      String sql = (String) dados.get("Relat.AtividadeAluno");
      PreparedStatement pstmt = conexao.prepareStatement(sql) ;
      ResultSet rs = pstmt.executeQuery();
      
      while (rs.next()) {

          Atividade atividade = new Atividade(); 
          atividade.getAluno().setNome(rs.getString(1));
          atividade.getTipoAtividade().setDescricaoTipo(rs.getString(2));
          atividade.getProfessorResponsavel().setNome(rs.getString(3));
          atividade.setStatus(rs.getString(4));
          atividade.setHorasAceitas(rs.getInt(5));
          atividade.setIdAtividade(rs.getInt(6));
          ativList.add(atividade);
      }
       pstmt.close();
       return ativList;
    }       
    
    public String analisar(Atividade atividade) throws SQLException {
        String retorno = "erro";                 
        
        Connection conexao = DBConnection.getInstance();
        try{
            String sql = (String) dados.get("Analisar.Atividade");
            PreparedStatement pstmt = conexao.prepareStatement(sql);
            
            pstmt.setInt(1, atividade.getCodAluno());
            pstmt.setInt(2, atividade.getIdAtividade());
            pstmt.setInt(3, atividade.getCodProfessor());
            pstmt.setString(4, atividade.getStatus());
            pstmt.setInt(5, atividade.getHorasAceitas());
            pstmt.setInt(6, atividade.getIdAtividade());
            pstmt.execute();
            retorno = "sucesso";
            pstmt.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return retorno;
    }     
    
}
