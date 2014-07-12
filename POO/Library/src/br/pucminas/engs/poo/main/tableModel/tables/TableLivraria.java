/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pucminas.engs.poo.main.tableModel.tables;

import br.pucminas.engs.poo.base.Livraria;
import br.pucminas.engs.poo.base.control.LivrariaControl;
import br.pucminas.engs.poo.main.tableModel.LivrariaTableModel;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Breno/Bianca
 */
public class TableLivraria extends JTable implements BaseTable<Livraria>{

    private LivrariaTableModel model;
    private LivrariaControl control;

    public TableLivraria() {
        if (model == null) {
            model = new LivrariaTableModel();
        }
        this.setModel(model);
        initColumns();
    }

    private void initColumns() {
        this.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.getColumnModel().getColumn(1).setPreferredWidth(40);
        this.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.getColumnModel().getColumn(3).setPreferredWidth(30);
//        this.getColumnModel().getColumn(4).setPreferredWidth(40);
    }

    @Override
    public void addData(ArrayList<Livraria> lista) {
        System.out.println("add data");
        ArrayList dados = new ArrayList();
        ArrayList<Livraria> listaDados = new ArrayList();
        if (lista != null) {
            lista.stream().forEach((Livraria) -> {
                listaDados.add(Livraria);
                dados.add(new String[]{
                    String.valueOf(Livraria.getId_livraria()),
                    Livraria.getDescricao(),
                    Livraria.getEndereco(),
                    Livraria.getGerenteResponsavel().getNome()
                });
            });
            model = new LivrariaTableModel(dados, listaDados);
            this.setModel(model);
        } else {
            System.out.println("teste");
        }
    }

    @Override
    public Livraria getSelecionado() {
        if (this.getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Selecione uma Livraria!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            return null;
        }

        return model.getObject(this.getSelectedRow());
    }

    @Override
    public void doSearch(Livraria filter) {
        System.out.println("searching");
        if (control == null) {
            control = new LivrariaControl();
        }
        String query = "";

        if (filter == null) {
            System.out.println("p null");
            addData(control.listAll());
        } else {
            if (filter.getDescricao()!= null) {
                query = "AND descricao LIKE '%" + filter.getDescricao()+ "%'";
            }
            if (filter.getEndereco()!= null) {
                query = query + "AND endereco LIKE '%" + filter.getEndereco()+ "%'";
            }
            addData(control.customList(query));
        }
    }

    @Override
    public ArrayList<Livraria> getData() {
        return model.getListaObjetos();
    }

    @Override
    public Livraria getData(int posicao) {
        if (this.getSelectedRow() != -1) {
            return model.getListaObjetos().get(this.getSelectedRow());
        } else {
            return null;
        }
    }
}
