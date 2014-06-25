/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pucminas.engs.poo.base;

import java.awt.List;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Breno
 */
public class Pedido {

    private int idPedido;
    private Date data;
    private Pessoa cliente;
    private ArrayList<Estoque> items;
    private Livraria filial;
    private Usuario usuario;
    private boolean finalizado;
    private boolean concluido;
    private String notas;

    public Pedido() {
        items = new ArrayList<>();
    }

    public double getTotalPedido() {
        double total = 0;
        for (Estoque estoque : items) {
            total = total + estoque.getItem_estoque().getPreco();
        }
        return total;
    }

    /**
     * @return the idPedido
     */
    public int getIdPedido() {
        return idPedido;
    }

    /**
     * @param idPedido the idPedido to set
     */
    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * @return the cliente
     */
    public Pessoa getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Pessoa cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the items
     */
    public ArrayList<Estoque> getItems() {
        return items;
    }

    /**
     * @param items the items to set
     */
    public void setItems(ArrayList<Estoque> items) {
        this.items = items;
    }

    /**
     * @return the filial
     */
    public Livraria getFilial() {
        return filial;
    }

    /**
     * @param filial the filial to set
     */
    public void setFilial(Livraria filial) {
        this.filial = filial;
    }

    /**
     * @return the finalizado
     */
    public boolean isFinalizado() {
        return finalizado;
    }

    /**
     * @param finalizado the finalizado to set
     */
    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }

    /**
     * @return the concluido
     */
    public boolean isConcluido() {
        return concluido;
    }

    /**
     * @param concluido the concluido to set
     */
    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
    }

    /**
     * @return the notas
     */
    public String getNotas() {
        return notas;
    }

    /**
     * @param notas the notas to set
     */
    public void setNotas(String notas) {
        this.notas = notas;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
