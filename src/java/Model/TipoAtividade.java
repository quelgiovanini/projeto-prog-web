/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Quele
 */
public class TipoAtividade {
    private int idTipo;
    public String descricaoTipo;
    private double proporcao; //relacao de uma hora normal para quantidade de horas aceitas
    private Curso curso;
    private int maximoPermitido;

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }
    
    public TipoAtividade(String descricao, double proporcao, Curso curso, int maximoPermido){
        this.setDescricaoTipo(descricaoTipo);
        this.setProporcao(proporcao);
        this.setCurso(curso);
        this.setMaximoPermitido(maximoPermitido);
    }
    
    public TipoAtividade(int idTipo, String descricao, double proporcao, Curso curso, int maximoPermido){
        this.setIdTipo(idTipo);
        this.setDescricaoTipo(descricaoTipo);
        this.setProporcao(proporcao);
        this.setCurso(curso);
        this.setMaximoPermitido(maximoPermitido);
    }    
    
    public TipoAtividade(String descricaoTipo){
        this.setDescricaoTipo(descricaoTipo);
        //this.setMaximoPermitido(maximoPermitido);
    }    
    
    public TipoAtividade getTipoAtividade() {
        return this;
    }

    public void setTipoAtividade(TipoAtividade tipos){
        this.setDescricaoTipo(tipos.getDescricaoTipo());
        this.setProporcao(tipos.getProporcao());
        this.setCurso(tipos.getCurso());
        this.setMaximoPermitido(tipos.getMaximoPermitido());
    }    

    public java.lang.String getDescricaoTipo() {
        return descricaoTipo;
    }

    public void setDescricaoTipo(java.lang.String descricaoTipo) {
        this.descricaoTipo = descricaoTipo;
    }

    public double getProporcao() {
        return proporcao;
    }

    public void setProporcao(double proporcao) {
        this.proporcao = proporcao;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public int getMaximoPermitido() {
        return maximoPermitido;
    }

    public void setMaximoPermitido(int maximoPermitido) {
        this.maximoPermitido = maximoPermitido;
    }
    
}
