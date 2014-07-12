/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pucminas.engs.poo.main;

import br.pucminas.engs.poo.base.Item;
import br.pucminas.engs.poo.view.item.ViewSelecionaItem;
import javax.swing.JTextField;

/**
 *
 * @author Breno/Bianca
 * Campo de texto que fornece um dialog para seleção de um item cadastrado no sistema
 */
public class SelecionaItemTextField extends JTextField {

    private Item itemSelecionado;
    private ViewSelecionaItem sel;

    /**
     * Componente de Texto para seleção de um Item Abre uma janela com a
     * listagem de itens quando é acionado
     */
    public SelecionaItemTextField() {
//        setIcon(new ImageIcon("/br/pucminas/engs/resources/search-icon-hi.png"));
        this.setEnabled(false);
        this.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SelecionaItemTextFieldMouseClicked(evt);
            }
        });
    }

    /**
     * Abre a janela de busca
     *
     * @param evt
     */
    private void SelecionaItemTextFieldMouseClicked(java.awt.event.MouseEvent evt) {
        openSearch();
    }

    /**
     *
     */
    private void openSearch() {
        if (sel == null) {
            sel = new ViewSelecionaItem(null, true);
        }
        sel.setVisible(true);
        if (sel.getRetorno() != null) {
            this.setText(sel.getRetorno().getId_item() + " - " + sel.getRetorno().getNome());
        }
    }

    public Item getSelecionado() {
        if (sel != null) {
            return sel.getRetorno();
        } else {
            return null;
        }
    }

}
