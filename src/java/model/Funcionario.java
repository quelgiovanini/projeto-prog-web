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
    private int codCargo;
    private int codSetor;
    private int codTipoFuncionario;

    public Funcionario(int codPessoa, String nome, String email, String matricula, int tipoFuncionario, int cargo, int setor){
        super(nome, email, matricula);
        this.setCargo(cargo);
        this.setSetor(setor);
        this.setTipoFuncionario(tipoFuncionario);
    }
  
   public Funcionario getFuncionario() {
        return this;
    }

    public void setNoticia(Funcionario funcionarios){
        this.setPessoa(this);
        this.setCargo(funcionarios.getCargo());
        this.setSetor(funcionarios.getSetor());
    }    
    
    public int getCargo() {
        return codCargo;
    }
    
    public void setTipoFuncionario(int tipoFuncionario){
      this.codTipoFuncionario = tipoFuncionario;
    }
    
    public int getCodTipoFuncionario(){
      return codTipoFuncionario;
    }

    public void setCargo(int cargo) {
        this.codCargo = cargo;
    }

    public int getSetor() {
        return codSetor;
    }

    public void setSetor(int setor) {
        this.codSetor = setor;
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
