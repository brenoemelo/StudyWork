/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pucminas.engs.poo.main.tableModel.tables;

import br.pucminas.engs.poo.base.Autor;
import br.pucminas.engs.poo.base.Livro;
import br.pucminas.engs.poo.base.control.ItemControl;
import br.pucminas.engs.poo.main.Formats;
import br.pucminas.engs.poo.main.tableModel.LivrosTableModel;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Breno
 */
public class TableLivros extends JTable implements BaseTable<Livro> {

    private LivrosTableModel model;
    private ItemControl control;
    ArrayList<Livro> listaDados;

    public TableLivros() {
        if (model == null) {
            model = new LivrosTableModel();
        }
        this.setModel(model);
    }

    @Override
    public void addData(ArrayList<Livro> lista) {
        ArrayList dados = new ArrayList();
        listaDados = new ArrayList();
        if (lista != null) {
            lista.stream().forEach((livro) -> {
                listaDados.add(livro);
                String autores = "";
                if (livro.getAutores() != null) {
                    for (Autor aut : livro.getAutores()) {
                        autores = autores + aut.getNome();
                    }
                }
                dados.add(new String[]{
                    String.valueOf(livro.getId_item()),
                    livro.getNome(),
                    autores,
                    livro.getEditora_item().getNome(),
                    livro.getIsbn(),
                    Formats.BR_CURRENCY.format(livro.getPreco()),
                    livro.getTipo_capa().getNome()
                });
            });
            model = new LivrosTableModel(dados, listaDados);
            this.setModel(model);
        }
    }

    @Override
    public void doSearch(Livro filter) {
        if (control == null) {
            control = new ItemControl();
        }
        String query = "";
        if (filter == null) {
            System.out.println("p null");
            addData(control.listLivros(""));
        } else {
            if (filter.getIsbn() != null) {
                query = "AND ISBN LIKE '%" + filter.getIsbn() + "%'";
            }
        }
    }

    @Override
    public ArrayList<Livro> getData() {
        return listaDados;
    }

    @Override
    public Livro getData(int posicao) {
        return listaDados.get(posicao);
    }

    @Override
    public Livro getSelecionado() {
        if (this.getSelectedRow() != -1) {
            return listaDados.get(this.getSelectedRow());
        } else {
            return null;
        }
    }
}
