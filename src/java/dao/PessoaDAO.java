package dao;

import database.DBConnection;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import model.Pessoa;
import util.PropertiesManager;

/**
 *
 * @author Prado
 */
public class PessoaDAO implements InterfaceDAO {
  
  private HashMap dados;
  
  public PessoaDAO() throws IOException{
    dados = new PropertiesManager("sql.properties").readPropertiesFile();
  }

  @Override
  public void inserir(Object obj) throws SQLException {
    Pessoa pessoa = (Pessoa) obj;
    
    Connection conexao = DBConnection.getInstance();    
    String sql = (String) dados.get("Pessoa.Inserir");
        
    PreparedStatement stmt = conexao.prepareStatement(sql);    
    stmt.setString(1, pessoa.getNomePessoa());
    stmt.setString(2, pessoa.getRg());
    //stmt.setString(3, pessoa.getDataNascimento()); // a data está hard coded por enquanto até usarmos alguma maneira de validar antes se a data foi digitada corretamente
    stmt.execute();
   // conexao.close(); //se fechar a conexao for fechada, nao é possível usar novamente
            
  }

  @Override
  public void excluir(Object obj) throws SQLException {
    throw new UnsupportedOperationException("Not supported yet.");
  }
  
  public int getCodPessoaPorObjeto(Pessoa pessoa) throws SQLException{
    int rv_codPessoa = 0;
    Connection conexao = DBConnection.getInstance();    
    String sql = (String) dados.get("Pessoa.PesquisarCodPessoaPorRG");
    
    PreparedStatement stmt = conexao.prepareStatement(sql);
    //stmt.setString(1, pessoa.getNomePessoa());
    stmt.setString(1, pessoa.getRg());
    ResultSet rs = stmt.executeQuery();
    
    while (rs.next()){
      rv_codPessoa = 1;
      rv_codPessoa = rs.getInt(1);
    }  
    //conexao.close();
    return rv_codPessoa;
  }
  
  @Override
  public ArrayList pesquisarTudo() throws SQLException {
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
  
}
