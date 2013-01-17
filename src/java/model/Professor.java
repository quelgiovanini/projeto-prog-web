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
public class Professor implements Serializable {
     private int codPessoa;
     private String nome;
     private String rg;
     private int tipoPessoa;
     private int area;


     public Professor () {}

     public Professor(int codPessoa, String nome, String rg, int tipoPessoa, int codArea) {
        this.setCodPessoa(codPessoa);
        this.setNome(nome);
        this.setRg(rg);
        this.setTipoPessoa(tipoPessoa);
        this.setArea(codArea);
    }    

     public Professor(int codPessoa, String nome, String rg, int tipoPessoa) {
        this.setCodPessoa(codPessoa);
        this.setNome(nome);
        this.setRg(rg);
        this.setTipoPessoa(tipoPessoa);
    }             
     
     public Professor(String nome, String rg, int tipoPessoa, int codArea) {
     //   this.setCodPessoa(codPessoa);
        this.setNome(nome);
        this.setRg(rg);
        this.setTipoPessoa(tipoPessoa);
        this.setArea(codArea);
    }       
     
     public Professor(String nome, String rg, int tipoPessoa) {
     //   this.setCodPessoa(codPessoa);
        this.setNome(nome);
        this.setRg(rg);
        this.setTipoPessoa(tipoPessoa);
       // this.setCodSetor(codSetor);
    }           
     
     public Professor (int codPessoa) {
         this.setCodPessoa(codPessoa);
     }
     
     public Professor getProfessor() {
         return this;
     }
     
    public void setProfessor(Professor professores) {
        this.setCodPessoa(professores.getCodPessoa());
        this.setNome(professores.getNome());
        this.setRg(professores.getRg());
        this.setTipoPessoa(professores.getTipoPessoa());
        this.setArea(professores.getArea());
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

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
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
                "\nProfessor: " + getNome());
    }  
    
}
