/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pucminas.engs.poo.base.control;

import br.pucminas.engs.poo.base.Autor;
import br.pucminas.engs.poo.database.ConnectionFactory;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Breno/Bianca
 */
public class AutorControl implements Controlable<Autor> {

    private ConnectionFactory conf;

    public AutorControl() {
        if (conf == null) {
            conf = new ConnectionFactory();
        }
    }

    @Override
    public boolean insert(Autor inserted) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remove(Autor removed) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Autor updated) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Autor> listAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Autor> customList(String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Autor listById(int id) {
        Autor retorno = null;
        try {
            String sql = "SELECT * FROM autor WHERE id_autor = ?";
            String[] dados = new String[1];
            dados[0] = String.valueOf(id);

            ResultSet rs = conf.select(sql, dados);
            if (rs.next()) {
                retorno = new Autor();
                retorno.setDescricao(rs.getString("descricao"));
                retorno.setNome(rs.getString("nome"));
                retorno.setId_autor(rs.getInt("id_autor"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AutorControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    public ArrayList<Autor> listByItem(int id_item) {
        ArrayList<Autor> retorno = new ArrayList<>();
        try {

            String sql = "SELECT * FROM autor_livro WHERE livro = ?";
            String[] dados = new String[1];
            dados[0] = String.valueOf(id_item);
            ResultSet rs = conf.select(sql, dados);
            while (rs.next()) {
                retorno.add(listById(rs.getInt("autor")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

}
