/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pucminas.engs.poo.base.control;

import br.pucminas.engs.poo.base.Livro;
import br.pucminas.engs.poo.database.ConnectionFactory;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Breno/Bianca
 */
public class LivroControl implements Controlable<Livro> {

    private ConnectionFactory conf;

    public LivroControl() {
        if (conf == null) {
            conf = new ConnectionFactory();
        }
    }

    @Override
    public boolean insert(Livro inserted) {
        ItemControl iControl = new ItemControl();
        if (iControl.insert(inserted)) {
            return update(inserted);
        } else {
            return false;
        }
    }

    @Override
    public boolean remove(Livro removed) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Livro updated) {
        String sql = "UPDATE item SET isbn = ?, tipo_capa = ? WHERE id_item = ?";
        String[] dados = new String[3];
        dados[0] = updated.getIsbn();
        dados[1] = updated.getTipo_capa().toString();
        dados[2] = String.valueOf(updated.getId_item());

        boolean retorno;
        try {
            conf.update(sql, dados);
            retorno = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString(), "Erro ao inserir livraria", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(LivrariaControl.class.getName()).log(Level.SEVERE, null, ex);
            retorno = false;
        }
        return retorno;
    }

    @Override
    public ArrayList<Livro> listAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Livro> customList(String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Livro listById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
