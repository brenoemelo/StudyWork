/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pucminas.engs.poo.main.tableModel.tables;

import br.pucminas.engs.poo.base.Item;
import br.pucminas.engs.poo.base.control.ItemControl;
import br.pucminas.engs.poo.main.tableModel.ItemTableModel;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Breno
 */
public class TableItens extends JTable implements BaseTable<Item>{

    private ItemTableModel model;
    private ItemControl control;

    public TableItens() {
        if (model == null) {
            model = new ItemTableModel();
        }
        this.setModel(model);
        initColumns();
    }

    private void initColumns() {
        this.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.getColumnModel().getColumn(1).setPreferredWidth(40);
        this.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.getColumnModel().getColumn(3).setPreferredWidth(30);
        this.getColumnModel().getColumn(4).setPreferredWidth(40);
    }

    @Override
    public void addData(ArrayList<Item> lista) {
        System.out.println("add data");
        ArrayList dados = new ArrayList();
        ArrayList<Item> listaDados = new ArrayList();
        if (lista != null) {
            lista.stream().forEach((item) -> {
                listaDados.add(item);
                dados.add(new String[]{
                    String.valueOf(item.getId_item()),
                    item.getNome(),
                    item.getEditora_item().getNome(),
                    item.getPrecoBR(),
                    item.getTipo_item().getNome(),
                    "",
                    String.valueOf(item.getEdicao())
                });
            });
            model = new ItemTableModel(dados, listaDados);
            this.setModel(model);
        } else {
            System.out.println("teste");
        }
    }

    @Override
    public Item getSelecionado() {
        if (this.getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Selecione um cliente!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            return null;
        }

        return model.getObject(this.getSelectedRow());
    }

    @Override
    public void doSearch(Item filter) {
        System.out.println("searching");
        if (control == null) {
            control = new ItemControl();
        }
        String query = "";

        if (filter == null) {
            addData(control.listAll());
        } else {
            if (filter.getNome() != null) {
                query = "AND nome LIKE '%" + filter.getNome() + "%'";
            }
            if (filter.getTipo_item() != null) {
                query = query + "AND tipo_tem = " + filter.getTipo_item().getNome() + "";
            }
            addData(control.customList(query));
        }
    }

    @Override
    public ArrayList<Item> getData() {
        return model.getListaObjetos();
    }

    @Override
    public Item getData(int posicao) {
        if (this.getSelectedRow() != -1) {
            return model.getListaObjetos().get(this.getSelectedRow());
        } else {
            return null;
        }
    }
}
