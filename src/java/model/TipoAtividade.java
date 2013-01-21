/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Quele
 */
public class TipoAtividade implements Serializable {
    private int idTipo;
    public String descricaoTipo;
    private double proporcao; //relacao de uma hora normal para quantidade de horas aceitas
    private int maximoPermitido;

    public TipoAtividade() {
        
    }
    
    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }
    
    public TipoAtividade(String descricao, double proporcao, int maximoPermido){
        this.setDescricaoTipo(descricao);
        this.setProporcao(proporcao);
        this.setMaximoPermitido(maximoPermido);
    }
    
    public TipoAtividade(int idTipo, String descricao){
        this.setIdTipo(idTipo);
        this.setDescricaoTipo(descricao);
    }    
    
    public TipoAtividade(int idTipo, String descricao, double proporcao, int maximoPermido){
        this.setIdTipo(idTipo);
        this.setDescricaoTipo(descricao);
        this.setProporcao(proporcao);
        this.setMaximoPermitido(maximoPermido);
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

    public int getMaximoPermitido() {
        return maximoPermitido;
    }

    public void setMaximoPermitido(int maximoPermitido) {
        this.maximoPermitido = maximoPermitido;
    }
    
}
