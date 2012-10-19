/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.InterfaceDAO;
import Database.DBConnection;
import java.io.IOException;
import java.sql.*;
import java.util.*;
import Model.Usuario;
import Util.PropertiesManager;

/**
 *
 * @author Quele
 */

public class UsuarioDAO implements InterfaceDAO {
    
    private HashMap dados;
    
    public UsuarioDAO() throws IOException{
        
        dados = new PropertiesManager("sql.properties").readPropertiesFile();
        
    }
    
    @Override
    public void inserir(Object obj) throws SQLException {
        
        Usuario user = (Usuario) obj;
        Connection conexao = DBConnection.getInstance();
        
        String sql = (String) dados.get("Insert.Usuario");
        
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, user.getNome());
        stmt.setString(2, user.getLogin());
        stmt.setString(3, user.getSenha());
        stmt.execute();
        conexao.close();
        
    }
    
    @Override
    public void excluir(Object obj) {
        throw new UnsupportedOperationException("Sem suporte.");
    }
    
    @Override
  public ArrayList pesquisarTudo() throws SQLException {
      ArrayList userList = new ArrayList();
      Connection conexao = DBConnection.getInstance();
      String sql = (String) dados.get("SelectALL.Usuario");
      PreparedStatement pstmt = conexao.prepareStatement(sql);
      ResultSet rs = pstmt.executeQuery();
      
      while (rs.next()) {
          Usuario usuario = new Usuario();
          usuario.setId(rs.getInt(1));
          usuario.setNome(rs.getString(2));
          usuario.setLogin(rs.getString(3));
          usuario.setSenha(rs.getString(4));
          userList.add(usuario);
      }
       pstmt.close();
       return userList;
  }

    @Override
    public Object pesquisarChave(int chave) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public Usuario pesquisarLogin(String login) throws SQLException {
        Connection conexao = DBConnection.getInstance();
        Usuario usuario = null;
        String sql = (String) dados.get("SelectByLogin.Usuario");
        PreparedStatement pstmt = conexao.prepareStatement(sql);
        pstmt.setString(1, login);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            usuario = new Usuario();
            usuario.setId(rs.getInt(1));
            usuario.setNome(rs.getString(2));
            usuario.setLogin(rs.getString(3));
            usuario.setSenha(rs.getString(4));
        }
        pstmt.close();
        return usuario;
    }

    @Override
    public void editar(Object obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
       
}
