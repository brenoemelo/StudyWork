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
public class Gerente extends Pessoa {

    private Livraria livrariaResponsabilidade;

    /**
     * @return the livrariaResponsabilidade
     */
    public Livraria getLivrariaResponsabilidade() {
        return livrariaResponsabilidade;
    }

    /**
     * @param livrariaResponsabilidade the livrariaResponsabilidade to set
     */
    public void setLivrariaResponsabilidade(Livraria livrariaResponsabilidade) {
        this.livrariaResponsabilidade = livrariaResponsabilidade;
    }

}
