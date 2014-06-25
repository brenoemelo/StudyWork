/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pucminas.engs.poo.base;

/**
 * @version 0.1b
 * @author Breno Esta clase armazena as peridiciocidades possiveis para
 * publicação dos materias cadastrados no sistema Para adicionar novas
 * possiblidades, será necessário somente adicionar a esta classe. O construtor
 * recebe o intervalo contado em dias
 */
public enum Peridiciocidade {

    DIARIO(1, "Diário"),
    SEMANAL(7, "Semanal"),
    QUINZENAL(15, "Quinzenal"),
    MENSAL(30, "Mensal"),
    TRIMESTRAL(90, "Trimestral"),
    SEMESTRAL(180, "Semestral"),
    ANUAL(360, "Anual"),
    NAO_DEFINIDO(0, "Não Definido"); //Por convenção, não há intervalo de dias

    private final int intervalo; //em Dias
    private final String nome;

    /**
     *
     * @return Intervalo entre as publicações contado em dias
     */
    public int intervalo() {
        return intervalo;
    }

    /**
     *
     * @param intervalo Intervalo entre as publicações contado em dias
     */
    private Peridiciocidade(int intervalo, String nome) {
        this.intervalo = intervalo;
        this.nome = nome;
    }

    /**
     * @return O nome do tipo, para visualização
     */
    public String getNome() {
        return nome;
    }

}
