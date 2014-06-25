/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pucminas.engs.poo.main.tableModel;

import br.pucminas.engs.poo.base.Estoque;
import br.pucminas.engs.poo.base.Item;
import java.util.ArrayList;

/**
 *
 * @author Breno
 */
public class EstoqueListaTableModel extends BaseTableModel<Estoque>{

    public EstoqueListaTableModel() {
        initColumns();
    }

    public EstoqueListaTableModel(ArrayList dadosTabela, ArrayList listaObjetos) {
        initColumns();
        this.setDadosTabela(dadosTabela);
        this.setListaObjetos(listaObjetos);
    }

    private void initColumns() {
        setColunas(new String[]{
            "Identificação",
            "Tipo Item",
            "Nome",
            "Edição",
            "Editora",
            "Preço",
            "Data Entrada",
            "Livaria"
        });
    }
    
    
}
