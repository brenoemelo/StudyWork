/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pucminas.engs.poo.main;

import br.pucminas.engs.poo.base.Livraria;
import br.pucminas.engs.poo.base.control.LivrariaControl;
import br.pucminas.engs.poo.login.SystemLogin;
import javax.swing.JComboBox;

/**
 *
 * @author Breno
 * Combo box listando todas as livrarias cadastradas no sistema
 */
public final class LivrariaComboBox extends JComboBox<Livraria> {

    private LivrariaControl control;
    
    /**
     * Componente ComboBox com as livrarias cadastradas no sistema
     */
    public LivrariaComboBox() {
        if(SystemLogin.USUARIO_LOGADO != null){
            loadValues();
        }
    }
    /**
     * Carrega os valores do componente
     */
    public void loadValues() {
        if (control == null) {
            control = new LivrariaControl();
        }

        control.listAll().stream().forEach((Livraria object) -> {
            this.addItem(object);
        });
    }

}
