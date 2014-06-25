/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pucminas.engs.poo.main.tableModel;

import br.pucminas.engs.poo.base.Item;
import java.util.ArrayList;

/**
 *
 * @author Breno
 */
public class LivrosTableModel extends BaseTableModel<Item>{

    public LivrosTableModel() {
        initColumns();
    }

    public LivrosTableModel(ArrayList dadosTabela, ArrayList listaObjetos) {
        initColumns();
        this.setDadosTabela(dadosTabela);
        this.setListaObjetos(listaObjetos);
    }

    private void initColumns() {
        setColunas(new String[]{
            "Identificação",
            "Nome",
            "Autor",
            "Editora",
            "ISBN",
            "Preço",
            "Tipo de Capa"

        });
    }
    
    
}
