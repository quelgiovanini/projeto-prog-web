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
import model.Setor;
import model.TipoAtividade;
import util.PropertiesManager;

/**
 *
 * @author Quele
 */
public class SetorDAO implements InterfaceDAO {
    

    private HashMap dados;
    
    public SetorDAO() throws IOException{
        
        dados = new PropertiesManager("sql.properties").readPropertiesFile();
        
    }    
    
    @Override
    public void inserir (Object obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void excluir(Object obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public String remover(String codtp) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");        
    }    

    @Override
    public ArrayList pesquisarTudo() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    } 
    
    public TipoAtividade pesquisarCod(int codTp) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
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
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public ArrayList pesquisarTipo() throws SQLException {
      ArrayList setorList = new ArrayList();
      Connection conexao = DBConnection.getInstance();
      String sql = (String) dados.get("SelectSetor.Setor");
      PreparedStatement pstmt = conexao.prepareStatement(sql) ;
      ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
            Setor set = new Setor();
            set.setCodSetor(rs.getInt(1));
            set.setNomeSetor(rs.getString(2));
            setorList.add(set);
      }
       pstmt.close();
       return setorList;
    
    }
    
}
