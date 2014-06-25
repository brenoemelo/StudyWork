/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pucminas.engs.poo.base.control;

import br.pucminas.engs.poo.base.Gerente;
import br.pucminas.engs.poo.base.Livraria;
import br.pucminas.engs.poo.database.ConnectionFactory;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Breno
 */
public class LivrariaControl implements Controlable<Livraria> {

    private ConnectionFactory conf;

    public LivrariaControl() {
        if (conf == null) {
            conf = new ConnectionFactory();
        }
    }

    @Override
    public boolean insert(Livraria inserted) {
        String sql = "INSERT INTO livraria "
                + "(filial, endereco, id_gerente, descricao) "
                + "VALUES (?, ?, ?, ?)";
        String[] dados = new String[4];
        dados[0] = inserted.isFilial() ? "1" : "0";
        dados[1] = inserted.getEndereco();
        //dados[2] = String.valueOf(inserted.getGerenteResponsavel().getId_pessoa());
        dados[2] = "1";
        dados[3] = inserted.getDescricao();
        boolean retorno;
        try {
            conf.insert(sql, dados);
            retorno = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString(), "Erro ao inserir livraria", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(LivrariaControl.class.getName()).log(Level.SEVERE, null, ex);
            retorno = false;
        }
        return retorno;
    }

    @Override
    public boolean remove(Livraria removed) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Livraria updated) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Livraria> listAll() {
        ArrayList<Livraria> retorno = new ArrayList<>();
        try {
            Livraria liv;
            ResultSet res = conf.select("Select * from livraria");
            while (res.next()) {
                liv = new Livraria(res.getInt("id_livraria"), res.getBoolean("filial"), res.getString("endereco"), new Gerente(), res.getString("descricao"));
                retorno.add(liv);
            }
            conf.closeStatement();
        } catch (SQLException ex) {
            Logger.getLogger(LivrariaControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    @Override
    public Livraria listById(int id) {
        Livraria liv = null;
        try {
            String[] dados = new String[1];
            dados[0] = String.valueOf(id);
            ResultSet res = conf.select("Select * from livraria where id_livraria = ?", dados);
            while (res.next()) {
                liv = new Livraria(res.getInt("id_livraria"), res.getBoolean("filial"), res.getString("endereco"), new Gerente(), res.getString("descricao"));
            }
            conf.closeStatement();
        } catch (SQLException ex) {
            Logger.getLogger(LivrariaControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return liv;
    }

    @Override
    public ArrayList<Livraria> customList(String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
