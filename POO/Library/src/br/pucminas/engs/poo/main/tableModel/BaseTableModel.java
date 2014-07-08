/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pucminas.engs.poo.main.tableModel;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Breno
 * @param <T>
 * Table Model Padrão utilizada no sistema para exibição de informações em tabelas
 */
public class BaseTableModel<T> extends AbstractTableModel {

    private ArrayList<String[]> dadosTabela;//Em String
    private ArrayList<T> listaObjetos;
    private String[] colunas;

    public BaseTableModel() {
        if (dadosTabela == null) {
            dadosTabela = new ArrayList<>();
        }
        if (listaObjetos == null) {
            listaObjetos = new ArrayList<>();
        }
    }

    /**
     * 
     * @param dadosTabela lista de objetos a serem listados na tabela
     * @param colunas lista de colunas da tabela
     * @param listaObjetos lista de objetos a serem listados na tabela
     */
    public BaseTableModel(ArrayList dadosTabela, String[] colunas, ArrayList listaObjetos) {
        this.dadosTabela = dadosTabela;
        this.colunas = colunas;
        this.listaObjetos = listaObjetos;
    }

    /**
     * 
     * @param row linha do objeto a ser retornado 
     * @return Objeto na posição @row
     */
    public T getObject(int row) {
        return listaObjetos.get(row);
    }

    @Override
    public int getRowCount() {
        return getDadosTabela().size();
    }

    @Override
    public int getColumnCount() {
        return getColunas().length;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String[] linha = (String[]) getDadosTabela().get(rowIndex);
        return linha[columnIndex];
    }

    /**
     * @return the dados
     */
    public ArrayList<String[]> getDadosTabela() {
        return dadosTabela;
    }

    /**
     * @param dados the dados to set
     */
    public void setDadosTabela(ArrayList<String[]> dados) {
        this.dadosTabela = dados;
    }

    /**
     * @return the colunas
     */
    public String[] getColunas() {
        return colunas;
    }

    /**
     * @param colunas the colunas to set
     */
    public void setColunas(String[] colunas) {
        this.colunas = colunas;
    }

    /**
     * @return the listaDados
     */
    public ArrayList<T> getListaObjetos() {
        return listaObjetos;
    }

    /**
     * @param listaDados the listaDados to set
     */
    public void setListaObjetos(ArrayList<T> listaDados) {
        this.listaObjetos = listaDados;
    }

}
