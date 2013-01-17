/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Quele
 */
public class Funcionario implements Serializable {
     private int codPessoa;
     private String nome;
     private String rg;
     private int tipoPessoa;
     private int codSetor;
     private Curso curso = new Curso();

     public Funcionario () {}

     public Funcionario(int codPessoa, String nome, String rg, int tipoPessoa, int codSetor) {
        this.setCodPessoa(codPessoa);
        this.setNome(nome);
        this.setRg(rg);
        this.setTipoPessoa(tipoPessoa);
        this.setCodSetor(codSetor);
    }    

     public Funcionario(int codPessoa, String nome, String rg, int tipoPessoa) {
        this.setCodPessoa(codPessoa);
        this.setNome(nome);
        this.setRg(rg);
        this.setTipoPessoa(tipoPessoa);
     //   this.setCodSetor(codSetor);
    }             
     
     public Funcionario(String nome, String rg, int tipoPessoa, int codSetor) {
     //   this.setCodPessoa(codPessoa);
        this.setNome(nome);
        this.setRg(rg);
        this.setTipoPessoa(tipoPessoa);
        this.setCodSetor(codSetor);
    }       
     
     public Funcionario(String nome, String rg, int tipoPessoa) {
     //   this.setCodPessoa(codPessoa);
        this.setNome(nome);
        this.setRg(rg);
        this.setTipoPessoa(tipoPessoa);
       // this.setCodSetor(codSetor);
    }           
     
     public Funcionario (int codPessoa) {
         this.setCodPessoa(codPessoa);
     }
     
     public Funcionario getFuncionario() {
         return this;
     }
     
    public void setFuncionario(Funcionario funcionarios) {
        this.setCodPessoa(funcionarios.getCodPessoa());
        this.setNome(funcionarios.getNome());
        this.setRg(funcionarios.getRg());
        this.setTipoPessoa(funcionarios.getTipoPessoa());
        this.setCodSetor(funcionarios.getCodSetor());
    }     
          
     
    public int getCodPessoa() {
        return codPessoa;
    }

    public void setCodPessoa(int codPessoa) {
        this.codPessoa = codPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public int getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(int tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public int getCodSetor() {
        return codSetor;
    }

    public void setCodSetor(int codSetor) {
        this.codSetor = codSetor;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public boolean testeSenha(String senha){
       // if(senha == getSenha()){
      if (senha != ""){
            return true;
        }else
            return false;
    }
    
    @Override
    public String toString() {
        return (super.toString() + 
                "\nFuncionario: " + getNome());
    }  
    
}
