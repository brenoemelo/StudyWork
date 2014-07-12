/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pucminas.engs.poo.main.tableModel.tables;

import br.pucminas.engs.poo.base.Estoque;
import br.pucminas.engs.poo.base.control.EstoqueControl;
import br.pucminas.engs.poo.main.Formats;
import br.pucminas.engs.poo.main.tableModel.EstoqueListaTableModel;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Breno/Bianca
 */
public class TableItensPedido extends JTable implements BaseTable<Estoque> {

    private EstoqueListaTableModel model;
//    private EstoqueControl control;

    public TableItensPedido() {
        if (model == null) {
            model = new EstoqueListaTableModel();
        }
        this.setModel(model);
        this.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    }

    @Override
    public void addData(ArrayList<Estoque> lista) {
        ArrayList dados = new ArrayList();
        ArrayList<Estoque> listaDados = new ArrayList();
        if (lista != null) {
            lista.stream().forEach((estoque) -> {
                listaDados.add(estoque);
                dados.add(new String[]{
                    String.valueOf(estoque.getId_estoque()),
                    estoque.getItem_estoque().getTipo_item().getNome(),
                    estoque.getItem_estoque().getNome(),
                    String.valueOf(estoque.getItem_estoque().getEdicao()),
                    estoque.getItem_estoque().getEditora_item().getNome(),
                    estoque.getItem_estoque().getPrecoBR(),
                    Formats.DATE_SYSTEM.format(estoque.getData_entrada()),
                    estoque.getLivraria_estoque().getDescricao()
                });
            });
            model = new EstoqueListaTableModel(dados, listaDados);
            this.setModel(model);
        }
    }

    @Override
    public void doSearch(Estoque filter) {
    }

    @Override
    public ArrayList<Estoque> getData() {
        return model.getListaObjetos();

    }

    @Override
    public Estoque getData(int posicao) {
//        System.out.println(model.getListaObjetos().get(posicao));
        return model.getListaObjetos().get(posicao);
    }

    public ArrayList<Estoque> getData(int[] posicao) {
        ArrayList<Estoque> retorno = new ArrayList<>();
        for (int i : posicao) {
            System.out.println("teste" + i);
            retorno.add(this.getData(i));
        }
        return retorno;
    }

    @Override
    public Estoque getSelecionado() {
        if (this.getSelectedRow() != -1) {
            return model.getListaObjetos().get(this.getSelectedRow());
        } else {
            return null;
        }
    }

    public ArrayList<Estoque> getSelecionados() {
        return getData(this.getSelectedRows());
    }
}
