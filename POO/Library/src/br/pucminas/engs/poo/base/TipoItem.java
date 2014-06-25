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
public enum TipoItem {

    LIVRO("Livro"),
    PERIODICO("Periódico"),
    JORNAL("Jornal");

    private final String nome;

    private TipoItem(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public static TipoItem getTipo(String tipo) {
        if (tipo.toUpperCase().equals(TipoItem.LIVRO.getNome().toUpperCase())) {
            return TipoItem.LIVRO;
        } else if (tipo.toUpperCase().equals(TipoItem.PERIODICO.getNome().toUpperCase())) {
            return TipoItem.PERIODICO;
        } else if (tipo.toUpperCase().equals(TipoItem.JORNAL.getNome().toUpperCase())) {
            return TipoItem.PERIODICO;
        }
        return null;
    }
}
