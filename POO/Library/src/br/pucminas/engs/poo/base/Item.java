/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pucminas.engs.poo.base;

import br.pucminas.engs.poo.main.Formats;

/**
 *
 * @author Breno
 */
public class Item {

    private int id_item;
    private int ano;
    private String nome;
    private Editora editora_item;
    private int edicao;
    private double preco;
    private double tamanhoL;
    private double tamanhoA;
    private double tamanhoP;
    private double peso;
    private int numero_paginas;
    private TipoItem tipo_item;

    /**
     * @return the id_item
     */
    public int getId_item() {
        return id_item;
    }

    /**
     * @param id_item the id_item to set
     */
    public void setId_item(int id_item) {
        this.id_item = id_item;
    }

    /**
     * @return the ano
     */
    public int getAno() {
        return ano;
    }

    /**
     * @param ano the ano to set
     */
    public void setAno(int ano) {
        this.ano = ano;
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

    /**
     * @return the editora_item
     */
    public Editora getEditora_item() {
        return editora_item;
    }

    /**
     * @param editora_item the editora_item to set
     */
    public void setEditora_item(Editora editora_item) {
        this.editora_item = editora_item;
    }

    /**
     * @return the edicao
     */
    public int getEdicao() {
        return edicao;
    }

    /**
     * @param edicao the edicao to set
     */
    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    /**
     * @return the preco
     */
    public double getPreco() {
        return preco;
    }

    /**
     * @return the preco formated in BR format
     */
    public String getPrecoBR() {
        return Formats.BR_CURRENCY.format(preco);
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

    /**
     * @return the tamanhoL
     */
    public double getTamanhoL() {
        return tamanhoL;
    }

    /**
     * @param tamanhoL the tamanhoL to set
     */
    public void setTamanhoL(double tamanhoL) {
        this.tamanhoL = tamanhoL;
    }

    /**
     * @return the tamanhoA
     */
    public double getTamanhoA() {
        return tamanhoA;
    }

    /**
     * @param tamanhoA the tamanhoA to set
     */
    public void setTamanhoA(double tamanhoA) {
        this.tamanhoA = tamanhoA;
    }

    /**
     * @return the tamanhoP
     */
    public double getTamanhoP() {
        return tamanhoP;
    }

    /**
     * @param tamanhoP the tamanhoP to set
     */
    public void setTamanhoP(double tamanhoP) {
        this.tamanhoP = tamanhoP;
    }

    /**
     * @return the peso
     */
    public double getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     * @return the numero_paginas
     */
    public int getNumero_paginas() {
        return numero_paginas;
    }

    /**
     * @param numero_paginas the numero_paginas to set
     */
    public void setNumero_paginas(int numero_paginas) {
        this.numero_paginas = numero_paginas;
    }

    /**
     * @return the tipo_item
     */
    public TipoItem getTipo_item() {
        return tipo_item;
    }

    /**
     * @param tipo_item the tipo_item to set
     */
    public void setTipo_item(TipoItem tipo_item) {
        this.tipo_item = tipo_item;
    }

    public void setTipo_item(String tipo_item) {
        this.tipo_item = TipoItem.valueOf(tipo_item);
    }

}
