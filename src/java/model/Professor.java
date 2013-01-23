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
     private int codArea;
     private Area area = new Area();


     public Professor () {}

     public Professor(int _codPessoa, String _nome, String _rg, int _tipoPessoa, int _codArea) {
        this.setCodPessoa(_codPessoa);
        this.setNome(_nome);
        this.setRg(_rg);
        this.setTipoPessoa(_tipoPessoa);
        this.setCodArea(_codArea);
    }    

     public Professor(int codPessoa, String nome, String rg, int tipoPessoa, Area area) {
        this.setCodPessoa(codPessoa);
        this.setNome(nome);
        this.setRg(rg);
        this.setTipoPessoa(tipoPessoa);
        this.setArea(area);
    }             
     
     public Professor(String nome, String rg, int tipoPessoa, int codArea) {
     //   this.setCodPessoa(codPessoa);
        this.setNome(nome);
        this.setRg(rg);
        this.setTipoPessoa(tipoPessoa);
        this.setCodArea(codArea);
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
    
    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
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

    public int getCodArea() {
        return codArea;
    }

    public void setCodArea(int area) {
        this.codArea = area;
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
