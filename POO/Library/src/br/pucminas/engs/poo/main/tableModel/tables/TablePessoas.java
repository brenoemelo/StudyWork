/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pucminas.engs.poo.main.tableModel.tables;

import br.pucminas.engs.poo.base.Pessoa;
import br.pucminas.engs.poo.base.control.PessoaControl;
import br.pucminas.engs.poo.main.tableModel.PessoaTableModel;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Breno/Bianca
 */
public class TablePessoas extends JTable implements BaseTable<Pessoa>{

    private PessoaTableModel model;
    private PessoaControl control;

    public TablePessoas() {
        if (model == null) {
            model = new PessoaTableModel();
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
    public void addData(ArrayList<Pessoa> lista) {
        System.out.println("add data");
        ArrayList dados = new ArrayList();
        ArrayList<Pessoa> listaDados = new ArrayList();
        if (lista != null) {
            lista.stream().forEach((pessoa) -> {
                listaDados.add(pessoa);
                dados.add(new String[]{
                    String.valueOf(pessoa.getId_pessoa()),
                    pessoa.getNome(),
                    pessoa.getCpf(),
                    pessoa.getIdentidade(),
                    pessoa.getEmail(),
                    pessoa.getData_nascimetoFormated()
                });
            });
            model = new PessoaTableModel(dados, listaDados);
            this.setModel(model);
        } else {
            System.out.println("teste");
        }
    }

    @Override
    public Pessoa getSelecionado() {
        if (this.getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Selecione um cliente!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            return null;
        }

        return model.getObject(this.getSelectedRow());
    }

    @Override
    public void doSearch(Pessoa filter) {
        System.out.println("searching");
        if (control == null) {
            control = new PessoaControl();
        }
        String query = "";

        if (filter == null) {
            System.out.println("p null");
            addData(control.listAll());
        } else {
            if (filter.getNome() != null) {
                query = "AND nome LIKE '%" + filter.getNome() + "%'";
            }
            if (filter.getCpf() != null) {
                query = query + "AND cpf LIKE '%" + filter.getCpf() + "%'";
            }

            if (filter.getEmail() != null) {
                query = query + "AND email LIKE '%" + filter.getEmail() + "%'";
            }
            addData(control.customList(query));
        }
    }

    @Override
    public ArrayList<Pessoa> getData() {
        return model.getListaObjetos();
    }

    @Override
    public Pessoa getData(int posicao) {
        if (this.getSelectedRow() != -1) {
            return model.getListaObjetos().get(this.getSelectedRow());
        } else {
            return null;
        }
    }
}
