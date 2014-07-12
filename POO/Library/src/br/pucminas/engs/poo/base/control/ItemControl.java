/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pucminas.engs.poo.base.control;

import br.pucminas.engs.poo.base.Item;
import br.pucminas.engs.poo.base.Livro;
import br.pucminas.engs.poo.base.TipoItem;
import br.pucminas.engs.poo.database.ConnectionFactory;
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
public class ItemControl implements Controlable<Item> {

    private ConnectionFactory conf;

    public ItemControl() {
        if (conf == null) {
            conf = new ConnectionFactory();
        }
    }

    @Override
    public boolean insert(Item inserted) {
        String sql = "INSERT INTO `item`"
                + "(`ano`, `nome`, `editora_item`, `edicao`, `preco`, `tamanhoL`, `tamanhoA`, `tamanhoP`, `peso`, `numero_paginas`, "
                + "`tipo_item`, `issn`, `isbn`, `tipo_capa`, `numero_cadernos`) VALUES "
                + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String[] dados = new String[15];
        dados[0] = String.valueOf(inserted.getAno());
        dados[1] = inserted.getNome();
        dados[2] = String.valueOf(inserted.getEditora_item().getId_editora());
        dados[3] = String.valueOf(inserted.getEdicao());
        dados[4] = String.valueOf(inserted.getPreco());
        dados[5] = String.valueOf(inserted.getTamanhoL());
        dados[6] = String.valueOf(inserted.getTamanhoA());
        dados[7] = String.valueOf(inserted.getTamanhoP());
        dados[8] = String.valueOf(inserted.getPeso());
        dados[9] = String.valueOf(inserted.getNumero_paginas());
        dados[10] = inserted.getTipo_item().getNome();
        dados[11] = "";
        dados[12] = "";
        dados[13] = "";
        dados[14] = "";

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
    public boolean remove(Item removed) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Item updated) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Item> listAll() {
        ArrayList<Item> retorno = new ArrayList<>();
        AutorControl aControl = new AutorControl();
        EditoraControl eControl = new EditoraControl();
        try {
            Item liv;
            ResultSet res = conf.select("select * from item");
            while (res.next()) {
                liv = new Livro();
                liv.setAno(res.getInt("ano"));
                liv.setEdicao(res.getInt("edicao"));
//                liv.setAutores(aControl.listByItem(res.getInt("id_item")));
                liv.setEditora_item(eControl.listById(res.getInt("editora_item")));
                liv.setId_item(res.getInt("id_item"));
//                liv.setIsbn(res.getString("isbn"));
                liv.setNome(res.getString("nome"));
                liv.setNumero_paginas(res.getInt("numero_paginas"));
                liv.setPeso(res.getFloat("peso"));
                liv.setPreco(res.getFloat("preco"));
                liv.setTamanhoA(res.getFloat("tamanhoA"));
                liv.setTamanhoL(res.getFloat("tamanhoL"));
                liv.setTamanhoP(res.getFloat("tamanhoP"));
                liv.setTipo_item(TipoItem.getTipo(res.getString("tipo_item")));
//                liv.setTipo_capa(res.getString("tipo_capa"));
                retorno.add(liv);
            }
            conf.closeStatement();
        } catch (SQLException ex) {
            Logger.getLogger(LivrariaControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    @Override
    public ArrayList<Item> customList(String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Item listById(int id) {
        Item retorno = null;
        EditoraControl edControl = new EditoraControl();
        try {
            String[] dados = new String[1];
            dados[0] = String.valueOf(id);
            ResultSet res = conf.select("Select * from item where id_item = ?", dados);
            while (res.next()) {
                retorno = new Item();
                retorno.setAno(res.getInt("ano"));
                retorno.setEdicao(res.getInt("edicao"));
                retorno.setEditora_item(edControl.listById(res.getInt("editora_item")));
                retorno.setId_item(res.getInt("id_item"));
                retorno.setNome(res.getString("nome"));
                retorno.setNumero_paginas(res.getInt("numero_paginas"));
                retorno.setPeso(res.getDouble("peso"));
                retorno.setPreco(res.getDouble("preco"));
                retorno.setTamanhoA(res.getDouble("tamanhoA"));
                retorno.setTamanhoL(res.getDouble("tamanhoL"));
                retorno.setTamanhoP(res.getDouble("tamanhoP"));
                retorno.setTipo_item(res.getString("tipo_item"));
            }
            conf.closeStatement();
        } catch (SQLException ex) {
            Logger.getLogger(LivrariaControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    public ArrayList<Livro> listLivros(String query) {

        ArrayList<Livro> retorno = new ArrayList<>();
        AutorControl aControl = new AutorControl();
        EditoraControl eControl = new EditoraControl();
        try {
            Livro liv;
            ResultSet res = conf.select("select * from item where tipo_item = 'LIVRO' " + query);
            while (res.next()) {
                liv = new Livro();
                liv.setAno(res.getInt("ano"));
                liv.setEdicao(res.getInt("edicao"));
                liv.setAutores(aControl.listByItem(res.getInt("id_item")));
                liv.setEditora_item(eControl.listById(res.getInt("editora_item")));
                liv.setId_item(res.getInt("id_item"));
                liv.setIsbn(res.getString("isbn"));
                liv.setNome(res.getString("nome"));
                liv.setNumero_paginas(res.getInt("numero_paginas"));
                liv.setPeso(res.getFloat("peso"));
                liv.setPreco(res.getFloat("preco"));
                liv.setTamanhoA(res.getFloat("tamanhoA"));
                liv.setTamanhoL(res.getFloat("tamanhoL"));
                liv.setTamanhoP(res.getFloat("tamanhoP"));
                liv.setTipo_capa(res.getString("tipo_capa"));
                retorno.add(liv);
            }
            conf.closeStatement();
        } catch (SQLException ex) {
            Logger.getLogger(LivrariaControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

}
