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
public enum TipoCapa {

    CAPA_DURA("Dura"),
    CAPA_FLEXIVEL("Flexível");

    private final String nome;

    private TipoCapa(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

}
