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
public class Editora {

    private int id_editora;
    private String nome;

    @Override
    public String toString() {
        return id_editora + nome;
    }

    /**
     * @return the id_editora
     */
    public int getId_editora() {
        return id_editora;
    }

    /**
     * @param id_editora the id_editora to set
     */
    public void setId_editora(int id_editora) {
        this.id_editora = id_editora;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

}
