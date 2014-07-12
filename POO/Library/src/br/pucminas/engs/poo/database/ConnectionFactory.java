/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pucminas.engs.poo.database;

import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Breno/Bianca
 */
public class ConnectionFactory {

    private static Connection con;
    private PreparedStatement stmt;
    /**
     * 
     * @return Nova conexão com o banco de dados
     */
    public Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost/engspoo", "root", "");
        } catch(CommunicationsException e){
             JOptionPane.showMessageDialog(null, "Não é possível iniciar o sistema, o banco de dados está Offline:\r\n"+e.toString(),"Erro Crítico",JOptionPane.ERROR_MESSAGE);
             throw new RuntimeException(e);
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Inicia uma conexão com o Banco
     */
    private void startConnection() {

        if (con == null) {
            con = new ConnectionFactory().getConnection();
        }
    }

    /**
     * 
     * @param sql SQL para inserção
     * @param dados Lista de dados com as informações a serem inseridas
     * @return True caso obtenha sucesso, False canho o processo falhe
     * @throws SQLException Excessão durante a inserção
     */
    public boolean insert(String sql, String[] dados) throws SQLException {
        boolean retorno;
        startConnection();
        // cria um preparedStatement
        try (PreparedStatement estm = con.prepareStatement(sql)) {
            // preenche os valores
            for (int i = 0; i < dados.length; i++) {
                estm.setString(i + 1, dados[i]);
            }   // executa
            retorno = estm.execute();
        }
        return retorno;
    }
    
    /**
     * 
     * @param sql SQL para atualização
     * @param dados Lista de dados com as informações a serem atualizadas
     * @return True caso obtenha sucesso, False canho o processo falhe
     * @throws SQLException Excessão durante a inserção
     */
    public boolean update(String sql, String[] dados) throws SQLException {
        boolean retorno;
        startConnection();
        // cria um preparedStatement
        try (PreparedStatement estm = con.prepareStatement(sql)) {
            // preenche os valores
            for (int i = 0; i < dados.length; i++) {
                estm.setString(i + 1, dados[i]);
            }   // executa
            retorno = estm.execute();
        }
        return retorno;
    }
    
    /**
     * 
     * @param sql Query de busca
     * @return ResultSet com os resultados
     * @throws SQLException Excessão durante a inserção
     */
    public ResultSet select(String sql) throws SQLException {
        startConnection();
        ResultSet rs;
        stmt = con.prepareStatement(sql);
        rs = stmt.executeQuery();
        return rs;
    }
    /**
     * 
     * @param sql Query de busca
     * @param dados Lista de dados para inserção
     * @return ResultSet com os resultados
     * @throws SQLException Excessão durante a inserção
     */
     public ResultSet select(String sql, String[] dados) throws SQLException {
        startConnection();
        ResultSet rs;
        stmt = con.prepareStatement(sql);
         for (int i = 0; i < dados.length; i++) {
             stmt.setString(i + 1, dados[i]);
         }
        
        rs = stmt.executeQuery();
        return rs;
    }
    
     /**
      * Fecha o Statement utilizado
      */
    public void closeStatement(){
        try {
            if (!stmt.isClosed()) {
                stmt.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
