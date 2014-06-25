/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pucminas.engs.poo.base;

/**
 *
 * @author Breno
 */
public class Livraria {

    private int id_livraria;
    private boolean filial;
    private String endereco;
    private Gerente gerenteResponsavel;
    private String descricao;

    public Livraria(int id_livraria, boolean filial, String endereco, Gerente gerenteResponsavel, String descricao) {
        this.id_livraria = id_livraria;
        this.filial = filial;
        this.endereco = endereco;
        this.gerenteResponsavel = gerenteResponsavel;
        this.descricao = descricao;
    }

    public Livraria(boolean filial, String endereco, Gerente gerente, String descricao) {
        this.filial = filial;
        this.endereco = endereco;
        this.gerenteResponsavel = gerente;
        this.descricao = descricao;
    }

    public Livraria() {
    }

    @Override
    public String toString() {
        return this.getId_livraria() + " - " + this.getDescricao();
    }

    /**
     * @return the id_livraria
     */
    public int getId_livraria() {
        return id_livraria;
    }

    /**
     * @param id_livraria the id_livraria to set
     */
    public void setId_livraria(int id_livraria) {
        this.id_livraria = id_livraria;
    }

    /**
     * @return the filial
     */
    public boolean isFilial() {
        return filial;
    }

    /**
     * @param filial the filial to set
     */
    public void setFilial(boolean filial) {
        this.filial = filial;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the gerenteResponsavel
     */
    public Gerente getGerenteResponsavel() {
        return gerenteResponsavel;
    }

    /**
     * @param gerenteResponsavel the gerenteResponsavel to set
     */
    public void setGerenteResponsavel(Gerente gerenteResponsavel) {
        this.gerenteResponsavel = gerenteResponsavel;
    }
}
