/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pucminas.engs.poo.main;

import br.pucminas.engs.poo.base.Editora;
import br.pucminas.engs.poo.base.Livraria;
import br.pucminas.engs.poo.base.control.EditoraControl;
import br.pucminas.engs.poo.base.control.LivrariaControl;
import br.pucminas.engs.poo.login.SystemLogin;
import javax.swing.JComboBox;

/**
 *
 * @author Breno
 */
public final class EditoraComboBox extends JComboBox<Editora> {

    private EditoraControl control;
    
    /**
     * Componente ComboBox com as livrarias cadastradas no sistema
     */
    public EditoraComboBox() {
        if(SystemLogin.USUARIO_LOGADO != null){
            loadValues();
        }
    }
    /**
     * Carrega os valores do componente
     */
    public void loadValues() {
        if (control == null) {
            control = new EditoraControl();
        }

        control.listAll().stream().forEach((Editora object) -> {
            this.addItem(object);
        });
    }

}
