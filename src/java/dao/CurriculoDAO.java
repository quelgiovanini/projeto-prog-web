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

public class CurriculoDAO implements InterfaceDAO {

    private HashMap dados;
    
    public CurriculoDAO() throws IOException{
        
        dados = new PropertiesManager("sql.properties").readPropertiesFile();
        
    }    
    
    @Override
    public void inserir (Object obj) throws SQLException {
        Curriculo curriculo = (Curriculo) obj;        
                     
        Connection conexao = DBConnection.getInstance();
        String sql = (String) dados.get("Curriculo.Inserir");
        PreparedStatement pstmt = conexao.prepareStatement(sql);
        pstmt.setInt(1, curriculo.getCurso().getCodCurso());
        pstmt.setString(2, curriculo.getNomeCurriculo());
        pstmt.execute();
        pstmt.close();
    }

    @Override
    public void excluir(Object obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList pesquisarTudo() throws SQLException {
      ArrayList ativList = new ArrayList();
      Connection conexao = DBConnection.getInstance();
      String sql = (String) dados.get("SelectALL.Atividade");
      PreparedStatement pstmt = conexao.prepareStatement(sql);
      ResultSet rs = pstmt.executeQuery();
      
      while (rs.next()) {

          Atividade atividade = new Atividade(); 
          atividade.setIdAtividade(rs.getString(1));
          atividade.getAluno().setNomePessoa(rs.getString(1));
          atividade.getTipoAtividade().setDescricaoTipo(rs.getString(2));
          atividade.getProfessorResponsavel().setNomePessoa(rs.getString(3));
          atividade.setStatus(rs.getString(4));
          ativList.add(rs);
      }
       pstmt.close();
       return ativList;
    }
    
    public Object pesquisarCod(String cod) throws SQLException {
       Connection conexao = DBConnection.getInstance();
        Atividade ativ = null;
        String sql = (String) dados.get("SelectById.Atividade");
        PreparedStatement pstmt = conexao.prepareStatement(sql);
        pstmt.setString(1, cod);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            ativ = new Atividade(); 
            ativ.setIdAtividade(rs.getString(1));
            ativ.getAluno().setNomePessoa(rs.getString(2));
            ativ.getTipoAtividade().setDescricaoTipo(rs.getString(3));
            ativ.getProfessorResponsavel().setNomePessoa(rs.getString(4));
            ativ.setStatus(rs.getString(5));
        }
        pstmt.close();
        return ativ;
    }    

    @Override
    public Object pesquisarChave(int chave) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void editar(Object newObj) throws SQLException {
        Atividade newAtiv = (Atividade) newObj;   
        Atividade oldAtiv = null;
  //      oldAtiv = pesquisarCod(newAtiv.getAtividade().getIdAtividade());
  
                     
        Connection conexao = DBConnection.getInstance();
        String sql = (String) dados.get("Update.Atividade");
        PreparedStatement pstmt = conexao.prepareStatement(sql);
        pstmt.setString(1, newAtiv.getIdAtividade());
        pstmt.setString(2, newAtiv.getAluno().getNomePessoa());
        pstmt.setString(3, newAtiv.getTipoAtividade().getDescricaoTipo());
        pstmt.setString(4, newAtiv.getProfessorResponsavel().getNomePessoa());
        pstmt.setString(5, newAtiv.getStatus());
        pstmt.execute();
        pstmt.close();  
    }
    
    /*
     * this methos gets the max number used for curso and semester
     * in case it is necessary to create more than one
     */
    public int getMaxNrSeqNumber(int codCurso, String semestreCurriculo) throws SQLException{
        int nrSeqNumber = 0;
                     
        Connection conexao = DBConnection.getInstance();
        String sql = (String) dados.get("SelectById.Atividade");
        PreparedStatement pstmt = conexao.prepareStatement(sql);
        pstmt.setInt(1, codCurso);
        pstmt.setString(2, semestreCurriculo);
        ResultSet rs = pstmt.executeQuery();
        
        if(rs.next()){
            nrSeqNumber = rs.getInt(1);
        }
        
        return nrSeqNumber;
    }
    
}
