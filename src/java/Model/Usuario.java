/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 * Classe criada conforme o padrão JavaBean
 * 
 * @author Quele
 */
public class Usuario {
    private int id;
    private String login;
    private String nome;
    private String senha;
    private String dataCriacao;
    
    public Usuario() { }

    public Usuario(String login, String nome, String senha, String dataCriacao) {
        this.login = login;
        this.nome = nome;
        this.senha = senha;
        this.dataCriacao = dataCriacao;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public java.lang.String getLogin() {
        return login;
    }

    public void setLogin(java.lang.String login) {
        this.login = login;
    }

    public java.lang.String getNome() {
        return nome;
    }

    public void setNome(java.lang.String nome) {
        this.nome = nome;
    }

    public java.lang.String getSenha() {
        return senha;
    }

    public void setSenha(java.lang.String senha) {
        this.senha = senha;
    }
    
     public String getDataCriacao() {
        return dataCriacao;
    }
     
    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
    
    @Override
    public String toString(){
        return ("Id = " + id + "\nNome = " + nome + "\n Login = " + login + "\n Senha = " + senha);
    }
}
