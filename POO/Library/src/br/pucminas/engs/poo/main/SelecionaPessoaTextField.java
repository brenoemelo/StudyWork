/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pucminas.engs.poo.main;

import br.pucminas.engs.poo.base.Pessoa;
import br.pucminas.engs.poo.view.pessoa.ViewSelecionaPessoa;
import javax.swing.JTextField;

/**
 *
 * @author Breno
 */
public class SelecionaPessoaTextField extends JTextField {

    private Pessoa pesssoaSelecionada;
    private ViewSelecionaPessoa sel;

    public SelecionaPessoaTextField() {
//        setIcon(new ImageIcon("/br/pucminas/engs/resources/search-icon-hi.png"));
        this.setEnabled(false);
        this.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SelecionaPessoaTextFieldMouseClicked(evt);
            }
        });
    }

    private void SelecionaPessoaTextFieldMouseClicked(java.awt.event.MouseEvent evt) {
        openSearch();
    }

    private void openSearch() {
        if (sel == null) {
            sel = new ViewSelecionaPessoa(null, true);
        }
        sel.setVisible(true);
        if (sel.getRetorno() != null) {
            this.setText(sel.getRetorno().getId_pessoa() + " - " + sel.getRetorno().getNome());
        }
    }

    public Pessoa getSelecionado() {
        if (sel == null) {
            return null;
        }
        return sel.getRetorno();
    }

}
