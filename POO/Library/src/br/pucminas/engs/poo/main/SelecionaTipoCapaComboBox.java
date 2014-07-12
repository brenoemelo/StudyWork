/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.pucminas.engs.poo.main;

import br.pucminas.engs.poo.base.TipoCapa;
import javax.swing.JComboBox;

/**
 *
 * @author Breno/Bianca
 */
public class SelecionaTipoCapaComboBox extends JComboBox<String>{
    
    public SelecionaTipoCapaComboBox() {
        for (TipoCapa tipoCapa : TipoCapa.values()) {
            this.addItem(tipoCapa.getNome());
        }
    }
    
    public TipoCapa getSelecionado(){
        return TipoCapa.valueOf(this.getSelectedItem().toString());
    }
    
}
