/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pucminas.engs.poo.start;

import br.pucminas.engs.poo.database.ConnectionFactory;
import br.pucminas.engs.poo.login.SystemLogin;
import br.pucminas.engs.poo.view.main.telaPrincipal;
import br.pucminas.engs.pooview.login.splashScreen;
import br.pucminas.engs.pooview.login.viewLogin;
import java.sql.Connection;

/**
 *
 * @author Breno
 */
public class Inicializa {

    public static void main(String[] args) {
        Inicializa ini = new Inicializa();
        ini.startApp();
    }

    Thread executeLogin;

    public void startApp() {
        inicializaLookAndFeel();
        this.executeLogin = new Thread(() -> {
            splashScreen sp = new splashScreen();
            sp.setVisible(true);
            initDatabase();
            viewLogin login = new viewLogin();
            login.setModal(true);
            login.setVisible(true);
            login.dispose();
            if (SystemLogin.USUARIO_LOGADO != null) {
                login.setVisible(false);
                sp.setVisible(false);
                sp.dispose();
                telaPrincipal tp = new telaPrincipal();
                tp.setVisible(true);
            } else {
                System.exit(0);
            }
        });
        executeLogin.start();

    }
    
    private void initDatabase(){
        ConnectionFactory co = new ConnectionFactory();
        Connection con = co.getConnection();
        System.out.println(con);
        if(con == null){
            System.exit(0);
        }
    }

    private void inicializaLookAndFeel() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(viewLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
    }
}
