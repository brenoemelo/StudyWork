/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pucminas.engs.poo.base.control;

import br.pucminas.engs.poo.base.Pessoa;
import br.pucminas.engs.poo.database.ConnectionFactory;
import br.pucminas.engs.poo.main.Formats;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Breno/Bianca
 */
public class PessoaControl implements Controlable<Pessoa> {

    private ConnectionFactory conf;

    public PessoaControl() {
        if (conf == null) {
            conf = new ConnectionFactory();
        }
    }

    @Override
    public boolean insert(Pessoa inserted) {

        String sql = "INSERT INTO pessoa (nome, cpf, identidade, data_nascimento, email) values(?,?,?,?,?)";
        String[] dados = new String[5];
        dados[0] = inserted.getNome();
        dados[1] = inserted.getCpf();
        dados[2] = inserted.getIdentidade();
        dados[3] = Formats.DATE_MY_SQL.format(inserted.getData_nascimeto());
        dados[4] = inserted.getEmail();
        boolean retorno;
        try {
            conf.insert(sql, dados);
            retorno = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString(), "Erro ao inserir livraria", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(PessoaControl.class.getName()).log(Level.SEVERE, null, ex);
            retorno = false;
        }
        return retorno;
    }

    @Override
    public boolean remove(Pessoa removed) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Pessoa updated) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Pessoa> listAll() {
        try {
            ArrayList<Pessoa> lista = new ArrayList<>();
            String sql = "SELECT * FROM PESSOA";
            ResultSet rs = conf.select(sql);
            while (rs.next()) {
                System.out.println("Adding line rs");
                Pessoa p = new Pessoa();
                p.setCpf(rs.getString("cpf"));
                p.setData_nascimeto(rs.getDate("data_nascimento"));
                p.setEmail(rs.getString("email"));
                p.setId_pessoa(rs.getInt("id_pessoa"));
                p.setIdentidade(rs.getString("identidade"));
                p.setNome(rs.getString("nome"));
                lista.add(p);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(PessoaControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Pessoa listById(int id) {
        try {
            Pessoa p = new Pessoa();
            String sql = "SELECT * FROM PESSOA WHERE id_pessoa = " + id;
            ResultSet rs = conf.select(sql);
            while (rs.next()) {
                p.setCpf(rs.getString("cpf"));
                p.setData_nascimeto(rs.getDate("data_nascimento"));
                p.setEmail(rs.getString("email"));
                p.setId_pessoa(rs.getInt("id_pessoa"));
                p.setIdentidade(rs.getString("identidade"));
                p.setNome(rs.getString("nome"));
            }
            return p;
        } catch (SQLException ex) {
            Logger.getLogger(PessoaControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<Pessoa> customList(String query) {
        try {
            ArrayList<Pessoa> lista = new ArrayList<>();
            Pessoa p;
            if (query.startsWith("AND")) {
                query = "WHERE " + query.substring(3, query.length());
                System.out.println(query);
            }

            String sql = "SELECT * FROM PESSOA " + query;
            ResultSet rs = conf.select(sql);
            while (rs.next()) {
                p = new Pessoa();
                p.setCpf(rs.getString("cpf"));
                p.setData_nascimeto(rs.getDate("data_nascimento"));
                p.setEmail(rs.getString("email"));
                p.setId_pessoa(rs.getInt("id_pessoa"));
                p.setIdentidade(rs.getString("identidade"));
                p.setNome(rs.getString("nome"));
                lista.add(p);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(PessoaControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
