/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.pucminas.engs.poo.main.tableModel.tables;

import br.pucminas.engs.poo.base.Estoque;
import java.util.ArrayList;

/**
 *
 * @author Breno
 * @param <T> Tipo de objeto listado na tabela
 * Interface padrão de uma tabela do sistema
 */
public interface BaseTable<T> {   
    
    public void addData(ArrayList<T> data);
    public void doSearch(T filter);
    public ArrayList<T> getData();
    public T getData(int posicao);
    public T getSelecionado();
}
