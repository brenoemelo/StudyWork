/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pucminas.engs.poo.base;

import java.util.ArrayList;

/**
 *
 * @author Breno
 */
public class Livro extends Item {

    private String isbn;
    private TipoCapa tipo_capa;
    private ArrayList<Autor> autores;

    /**
     * @return the isbn
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * @param isbn the isbn to set
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * @return the tipo_capa
     */
    public TipoCapa getTipo_capa() {
        return tipo_capa;
    }

    /**
     * @param tipo_capa the tipo_capa to set
     */
    public void setTipo_capa(TipoCapa tipo_capa) {
        this.tipo_capa = tipo_capa;
    }

    public void setTipo_capa(String tipo_capa) {
        this.tipo_capa = TipoCapa.valueOf(tipo_capa);
    }

    /**
     * @return the autores
     */
    public ArrayList<Autor> getAutores() {
        return autores;
    }

    /**
     * @param autores the autores to set
     */
    public void setAutores(ArrayList<Autor> autores) {
        this.autores = autores;
    }
}
