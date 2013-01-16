package model;

import database.DBConnection;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class Pessoa implements Serializable {
    
    private int codPessoa;
    private String nomePessoa;
    private String rg;
    private String dataNascimento;
    private String email;

    public Pessoa() {
        
    }
    
    public Pessoa(String nomePessoa, String rg, String dataNascimento) {        
        this.nomePessoa = nomePessoa;
        this.rg = rg;
        this.dataNascimento = dataNascimento;
    }
    
    public Pessoa(String nomePessoa) {        
        this.nomePessoa = nomePessoa;
    }
    
    public Pessoa(int codPessoa, String nomePessoa, String rg, String dataNascimento) {
        this.codPessoa = codPessoa;
        this.nomePessoa = nomePessoa;
        this.rg = rg;
        this.dataNascimento = dataNascimento;
    }

    public int getCodPessoa() throws SQLException {
      if(this.codPessoa == 0){
        Connection conexao = DBConnection.getInstance();
      }
      return this.codPessoa;
    }
    
    public void setCodPessoa(int codPessoa) {
        this.codPessoa = codPessoa;
    }

    public String getNomePessoa() {      
        return nomePessoa;
    }
    
    public String getEmail(){
        return email;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    public void setPessoa(Object pessoa){
      
    }

    @Override
    public String toString() {
        return "Pessoa{" + "codPessoa=" + codPessoa + ", nomePessoa=" + nomePessoa + ", rg=" + rg + ", dataNascimento=" + dataNascimento + '}';
    }    
    
}
