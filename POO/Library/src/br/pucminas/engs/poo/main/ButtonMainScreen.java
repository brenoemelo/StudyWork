/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pucminas.engs.poo.main;

import java.awt.Font;
import javax.swing.JLabel;

/**
 *
 * @author Breno
 * Implementa um botão padrão na tela inicial do sistema.
 * Fonte, cores e listeners padrões.
 * Implementa listener para simular um evento 'hover', destacando o botão quando o mouse esta sobre o botão.
 */
public class ButtonMainScreen extends JLabel {

    public ButtonMainScreen() {
        super();
        this.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        this.setForeground(new java.awt.Color(107, 180, 224));

        this.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                setFont(new java.awt.Font("Verdana", Font.BOLD, 11)); // NOI18N
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                setFont(new java.awt.Font("Verdana", Font.PLAIN, 11)); // NOI18N
            }
        }
        );
    }
}
