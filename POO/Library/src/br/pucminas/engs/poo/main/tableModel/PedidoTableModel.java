/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pucminas.engs.poo.main.tableModel;

import br.pucminas.engs.poo.base.Pedido;
import br.pucminas.engs.poo.base.Pessoa;
import java.util.ArrayList;

/**
 *
 * @author Breno/Bianca
 */
public class PedidoTableModel extends BaseTableModel<Pedido> {

    public PedidoTableModel() {
        initColumns();
    }

    public PedidoTableModel(ArrayList dadosTabela, ArrayList listaObjetos) {
        initColumns();
        this.setDadosTabela(dadosTabela);
        this.setListaObjetos(listaObjetos);
    }

    private void initColumns() {
        setColunas(new String[]{
            "Número do Pedido",
            "Cliente",
            "Livraria",
            "Data"
        });
    }

}
