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
import java.util.List;
import model.Atividade;
import model.TipoAtividade;
import util.PropertiesManager;

/**
 *
 * @author Quele
 */
public class TipoAtividadeDAO implements InterfaceDAO {
    

    private HashMap dados;
    
    public TipoAtividadeDAO() throws IOException{
        
        dados = new PropertiesManager("sql.properties").readPropertiesFile();
        
    }    
    
    @Override
    public void inserir (Object obj) throws SQLException {
        TipoAtividade tipos = (TipoAtividade) obj;        
                     
        Connection conexao = DBConnection.getInstance();
        String sql = (String) dados.get("Insert.Tipo");
        PreparedStatement pstmt = conexao.prepareStatement(sql);
   //     pstmt.setString(1, atividades.getIdAtividade());
       // pstmt.setInt(1, tipos.getIdTipo());
        pstmt.setString(1, tipos.getDescricaoTipo());
        pstmt.setDouble(2, tipos.getProporcao());
        pstmt.setInt(3, tipos.getMaximoPermitido());
        pstmt.execute();
        pstmt.close();
    }

    @Override
    public void excluir(Object obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public String remover(String codtp) throws SQLException {
        String retorno = "erro";                 

        Connection conexao = DBConnection.getInstance();
        try{
            String sql = (String) dados.get("Delete.Tipo");
            PreparedStatement pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1, codtp);
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
      ArrayList tipoList = new ArrayList();
      Connection conexao = DBConnection.getInstance();
      String sql = (String) dados.get("SelectAll.Tipo");
      PreparedStatement pstmt = conexao.prepareStatement(sql) ;
      ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

          TipoAtividade tipos = new TipoAtividade(); 

          tipos.setDescricaoTipo(rs.getString(1));
          tipos.setProporcao(rs.getDouble(2));
          tipos.setMaximoPermitido(rs.getInt(3));
          tipos.setIdTipo(rs.getInt(4));
          tipoList.add(tipos);
      }
       pstmt.close();
       return tipoList;
    } 
    
    public TipoAtividade pesquisarCod(String cod) throws SQLException {
      //ArrayList ativList = new ArrayList();
        int codTp = Integer.valueOf(cod);
      Connection conexao = DBConnection.getInstance();
        TipoAtividade tpAtiv = null;
        String sql = (String) dados.get("SelectById.Tipo");
        PreparedStatement pstmt = conexao.prepareStatement(sql);
        pstmt.setInt(1, codTp);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            tpAtiv = new TipoAtividade(); 
            tpAtiv.setIdTipo(rs.getInt(1));
            tpAtiv.setDescricaoTipo(rs.getString(2));
            tpAtiv.setProporcao(rs.getDouble(3));
            tpAtiv.setMaximoPermitido(rs.getInt(4));
        }
        pstmt.close();
        return tpAtiv;
    }    

    @Override
    public Object pesquisarChave(int chave) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void editar(Object obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public String editar(TipoAtividade tpAtiv) throws SQLException {
        String retorno = "erro";                 
        
        Connection conexao = DBConnection.getInstance();
        try{
            String sql = (String) dados.get("Update.Tipo");
            PreparedStatement pstmt = conexao.prepareStatement(sql);
             
            pstmt.setString(1, tpAtiv.getDescricaoTipo());
            pstmt.setDouble(2, tpAtiv.getProporcao());
            pstmt.setInt(3, tpAtiv.getMaximoPermitido());
            pstmt.setInt(4, tpAtiv.getIdTipo());
            
            pstmt.execute();
            retorno = "sucesso";
            
            pstmt.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return retorno;
    }
    
    public ArrayList pesquisarTipo() throws SQLException {
      ArrayList tipoList = new ArrayList();
      Connection conexao = DBConnection.getInstance();
      String sql = (String) dados.get("SelectTipo.Tipo");
      PreparedStatement pstmt = conexao.prepareStatement(sql) ;
      ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
            TipoAtividade tipo = new TipoAtividade();
            tipo.setIdTipo(rs.getInt(1));
            tipo.setDescricaoTipo(rs.getString(2));
            tipoList.add(tipo);
      }
       pstmt.close();
       return tipoList;
    
    }
    
}
