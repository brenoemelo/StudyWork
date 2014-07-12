/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pucminas.engs.poo.base.control;

import br.pucminas.engs.poo.base.Estoque;
import br.pucminas.engs.poo.base.Pedido;
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
public class PedidoControl implements Controlable<Pedido> {

    private ConnectionFactory conf;

    public PedidoControl() {
        if (conf == null) {
            conf = new ConnectionFactory();
        }
    }

    @Override
    public boolean insert(Pedido inserted) {
        String sql = "INSERT INTO pedido "
                + "(cliente_pedido, livraria_pedido, usuario_pedido, data_pedido) "
                + "values( ?, ?, ?, ?)";
        String[] dados = new String[4];
        dados[0] = String.valueOf(inserted.getCliente().getId_pessoa());
        dados[1] = String.valueOf(inserted.getFilial().getId_livraria());
        dados[2] = String.valueOf(inserted.getUsuario().getId_usuario());
        dados[3] = Formats.DATE_MY_SQL.format(inserted.getData());
        boolean retorno;
        try {
            conf.insert(sql, dados);
            inserted.setIdPedido(getMaxId(inserted));
            insertItens(inserted);
            retorno = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString(), "Erro ao inserir pedido", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(PessoaControl.class.getName()).log(Level.SEVERE, null, ex);
            retorno = false;
        }
        return retorno;
    }

    private boolean insertItens(Pedido inserted) {
        String sql = "INSERT INTO pedido_itens "
                + "(id_pedido, id_estoque)"
                + "values(?, ?)";
        String[] dados = new String[2];
        dados[0] = String.valueOf(inserted.getIdPedido());
        boolean retorno = false;
        for (Estoque estoque : inserted.getItems()) {
            dados[1] = String.valueOf(estoque.getId_estoque());
            try {
                conf.insert(sql, dados);
                retorno = true;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.toString(), "Erro ao inserir item do pedido", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(PessoaControl.class.getName()).log(Level.SEVERE, null, ex);
                retorno = false;
            }
        }
        return retorno;
    }

    private int getMaxId(Pedido inserted) {
        int retorno = 0;
        try {
            String sql = "SELECT MAX(id_pedido) as last FROM pedido WHERE data_pedido = ?";
            String[] dados = new String[1];
            dados[0] = String.valueOf(Formats.DATE_MY_SQL.format(inserted.getData()));
            ResultSet rs = conf.select(sql, dados);
            while (rs.next()) {
                retorno = rs.getInt("last");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PedidoControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    @Override
    public boolean remove(Pedido removed) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Pedido updated) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Pedido> listAll() {
        ArrayList<Pedido> retorno = new ArrayList<>();
        LivrariaControl lControl = new LivrariaControl();
        EstoqueControl eControl = new EstoqueControl();
        PessoaControl pControl = new PessoaControl();
        try {
            String SQL = "SELECT * FROM pedido";
            ResultSet rs = conf.select(SQL);
            ResultSet rsItens;
            Pedido p = new Pedido();
            while (rs.next()) {
                p.setIdPedido(rs.getInt("id_pedido"));
                p.setData(rs.getDate("data_pedido"));
                p.setFilial(lControl.listById(rs.getInt("livraria_pedido")));
                p.setCliente(pControl.listById(rs.getInt("cliente_pedido")));
                p.setUsuario(null);
                p.setItems(new ArrayList<>());
                rsItens = conf.select("SELECT * FROM pedido_itens WHERE id_pedido = " + p.getIdPedido());
                while (rsItens.next()) {
                    p.getItems().add(eControl.listById(rsItens.getInt("id_estoque")));
                }
                retorno.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PedidoControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    public ArrayList<Pedido> listByFilial() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pedido listById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Pedido> customList(String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
