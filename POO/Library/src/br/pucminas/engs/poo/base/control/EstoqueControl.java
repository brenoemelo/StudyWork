/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pucminas.engs.poo.base.control;

import br.pucminas.engs.poo.base.Estoque;
import br.pucminas.engs.poo.base.Gerente;
import br.pucminas.engs.poo.base.Livraria;
import br.pucminas.engs.poo.database.ConnectionFactory;
import br.pucminas.engs.poo.main.Formats;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Breno/Bianca
 */
public class EstoqueControl implements Controlable<Estoque> {

    private ConnectionFactory conf;

    public EstoqueControl() {
        if (conf == null) {
            conf = new ConnectionFactory();
        }
    }

    @Override
    public boolean insert(Estoque inserted) {
        String sql = "INSERT INTO estoque (livraria_estoque, data_entrada, item_estoque) values(?,?,?)";
        String[] dados = new String[3];
        dados[0] = String.valueOf(inserted.getLivraria_estoque().getId_livraria());
        dados[1] = Formats.DATE_MY_SQL.format(inserted.getData_entrada());
        dados[2] = String.valueOf(inserted.getItem_estoque().getId_item());
        boolean retorno;
        try {
            conf.insert(sql, dados);
            retorno = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString(), "Erro ao inserir estoque", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(PessoaControl.class.getName()).log(Level.SEVERE, null, ex);
            retorno = false;
        }
        return retorno;
    }

    @Override
    public boolean remove(Estoque removed) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Estoque updated) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Estoque> listAll() {
        ArrayList<Estoque> lista = new ArrayList<>();
        ItemControl iControl = new ItemControl();
        LivrariaControl lControl = new LivrariaControl();
        String sql = "SELECT * FROM estoque WHERE disponivel = 1 ORDER BY data_entrada ASC";
        try {
            Estoque stq;
            ResultSet res = conf.select(sql);
            while (res.next()) {
                stq = new Estoque();
                stq.setData_entrada(res.getDate("data_entrada"));
                stq.setDisponivel(res.getBoolean("disponivel"));
                stq.setId_estoque(res.getInt("id_estoque"));
                stq.setItem_estoque(iControl.listById(res.getInt("item_estoque")));
                stq.setLivraria_estoque(lControl.listById(res.getInt("livraria_estoque")));
                lista.add(stq);
            }
            conf.closeStatement();
        } catch (SQLException ex) {
            Logger.getLogger(LivrariaControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public ArrayList<Estoque> listByFilial() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<Estoque> listByItem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Estoque listById(int id) {
        Estoque stq = new Estoque();
        ItemControl iControl = new ItemControl();
        LivrariaControl lControl = new LivrariaControl();
        String sql = "SELECT * FROM estoque WHERE id_estoque = " + id;
        try {
            ResultSet res = conf.select(sql);
            while (res.next()) {
                stq = new Estoque();
                stq.setData_entrada(res.getDate("data_entrada"));
                stq.setDisponivel(res.getBoolean("disponivel"));
                stq.setId_estoque(res.getInt("id_estoque"));
                stq.setItem_estoque(iControl.listById(res.getInt("item_estoque")));
                stq.setLivraria_estoque(lControl.listById(res.getInt("livraria_estoque")));
            }
            conf.closeStatement();
        } catch (SQLException ex) {
            Logger.getLogger(LivrariaControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return stq;
    }

    @Override
    public ArrayList<Estoque> customList(String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
