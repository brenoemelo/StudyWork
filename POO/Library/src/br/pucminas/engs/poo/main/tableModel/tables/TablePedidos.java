/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pucminas.engs.poo.main.tableModel.tables;

import br.pucminas.engs.poo.base.Pedido;
import br.pucminas.engs.poo.base.control.PedidoControl;
import br.pucminas.engs.poo.main.Formats;
import br.pucminas.engs.poo.main.tableModel.PedidoTableModel;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Breno
 */
public class TablePedidos extends JTable implements BaseTable<Pedido> {

    private PedidoTableModel model;
    private PedidoControl control;

    public TablePedidos() {
        if (model == null) {
            model = new PedidoTableModel();
        }
        this.setModel(model);
    }

    @Override
    public void addData(ArrayList<Pedido> lista) {
        ArrayList dados = new ArrayList();
        ArrayList<Pedido> listaDados = new ArrayList();
        if (lista != null) {
            lista.stream().forEach((item) -> {
                listaDados.add(item);
                dados.add(new String[]{
                    String.valueOf(item.getIdPedido()),
                    item.getCliente().getNome(),
                    item.getFilial().getDescricao(),
                    Formats.DATE_SYSTEM.format(item.getData())
                });
            });
            model = new PedidoTableModel(dados, listaDados);
            this.setModel(model);
        } else {
            System.out.println("teste");
        }
    }

    @Override
    public Pedido getSelecionado() {
        if (this.getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Selecione um cliente!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            return null;
        }

        return model.getObject(this.getSelectedRow());
    }

    @Override
    public void doSearch(Pedido filter) {
        System.out.println("searching");
        if (control == null) {
            control = new PedidoControl();
        }
        String query = "";

        if (filter == null) {
            addData(control.listAll());
        }
    }

    @Override
    public ArrayList<Pedido> getData() {
        return model.getListaObjetos();
    }

    @Override
    public Pedido getData(int posicao) {
        if (this.getSelectedRow() != -1) {
            return model.getListaObjetos().get(this.getSelectedRow());
        } else {
            return null;
        }
    }
}
