/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pucminas.engs.poo.base.control;

import br.pucminas.engs.poo.base.Autor;
import br.pucminas.engs.poo.base.Editora;
import br.pucminas.engs.poo.database.ConnectionFactory;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Breno
 */
public class EditoraControl implements Controlable<Editora> {

    private ConnectionFactory conf;

    public EditoraControl() {
        if (conf == null) {
            conf = new ConnectionFactory();
        }
    }

    @Override
    public boolean insert(Editora inserted) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remove(Editora removed) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Editora updated) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Editora> listAll() {
        ArrayList<Editora> retorno = new ArrayList<>();
        Editora ed;
        try {
            String sql = "SELECT * FROM editora";

            ResultSet rs = conf.select(sql);
            if (rs.next()) {
                ed = new Editora();
                ed.setNome(rs.getString("nome"));
                ed.setId_editora(rs.getInt("id_editora"));
                retorno.add(ed);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AutorControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    @Override
    public ArrayList<Editora> customList(String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Editora listById(int id) {
        Editora retorno = null;
        try {
            String sql = "SELECT * FROM editora WHERE id_editora = ?";
            String[] dados = new String[1];
            dados[0] = String.valueOf(id);

            ResultSet rs = conf.select(sql, dados);
            if (rs.next()) {
                retorno = new Editora();
                retorno.setNome(rs.getString("nome"));
                retorno.setId_editora(rs.getInt("id_editora"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AutorControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

}
