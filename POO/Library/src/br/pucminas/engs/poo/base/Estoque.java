/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pucminas.engs.poo.base;

import java.util.Date;

/**
 *
 * @author Breno
 */
public class Estoque {

    private int id_estoque;
    private Livraria livraria_estoque;
    private Date data_entrada;
    private Item item_estoque;
    private boolean disponivel;

    /**
     * @return the id_estoque
     */
    public int getId_estoque() {
        return id_estoque;
    }

    /**
     * @param id_estoque the id_estoque to set
     */
    public void setId_estoque(int id_estoque) {
        this.id_estoque = id_estoque;
    }

    /**
     * @return the livraria_estoque
     */
    public Livraria getLivraria_estoque() {
        return livraria_estoque;
    }

    /**
     * @param livraria_estoque the livraria_estoque to set
     */
    public void setLivraria_estoque(Livraria livraria_estoque) {
        this.livraria_estoque = livraria_estoque;
    }

    /**
     * @return the data_entrada
     */
    public Date getData_entrada() {
        return data_entrada;
    }

    /**
     * @param data_entrada the data_entrada to set
     */
    public void setData_entrada(Date data_entrada) {
        this.data_entrada = data_entrada;
    }

    /**
     * @return the item_estoque
     */
    public Item getItem_estoque() {
        return item_estoque;
    }

    /**
     * @param item_estoque the item_estoque to set
     */
    public void setItem_estoque(Item item_estoque) {
        this.item_estoque = item_estoque;
    }

    /**
     * @return the disponivel
     */
    public boolean isDisponivel() {
        return disponivel;
    }

    /**
     * @param disponivel the disponivel to set
     */
    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + this.id_estoque;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Estoque other = (Estoque) obj;
        return this.id_estoque == other.id_estoque;
    }

}
