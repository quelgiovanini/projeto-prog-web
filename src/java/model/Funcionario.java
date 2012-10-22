/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Quele
 */
public class Funcionario extends Pessoa {
    private String cargo;
    private String setor;

    public Funcionario(String nome, String email, String matricula, String cargo, String setor){
        super(nome, email, matricula);
        this.setCargo(cargo);
        this.setSetor(setor);
    }
  
   public Funcionario getFuncionario() {
        return this;
    }

    public void setNoticia(Funcionario funcionarios){
        this.setPessoa(this);
        this.setCargo(funcionarios.getCargo());
        this.setSetor(funcionarios.getSetor());
    }    
    
    public java.lang.String getCargo() {
        return cargo;
    }

    public void setCargo(java.lang.String cargo) {
        this.cargo = cargo;
    }

    public java.lang.String getSetor() {
        return setor;
    }

    public void setSetor(java.lang.String setor) {
        this.setor = setor;
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
                "\nCargo: " + getCargo() +
                "\nSetor: " + getSetor());
    }  
    
}
