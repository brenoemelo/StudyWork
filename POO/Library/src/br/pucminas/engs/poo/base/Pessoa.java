/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pucminas.engs.poo.base;

import br.pucminas.engs.poo.main.Formats;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Breno
 */
public class Pessoa {

    private int id_pessoa;
    private String nome;
    private String cpf;
    private String identidade;
    private Date data_nascimeto;
    private String email;

    /**
     * @return the id_pessoa
     */
    public int getId_pessoa() {
        return id_pessoa;
    }

    /**
     * @param id_pessoa the id_pessoa to set
     */
    public void setId_pessoa(int id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the identidade
     */
    public String getIdentidade() {
        return identidade;
    }

    /**
     * @param identidade the identidade to set
     */
    public void setIdentidade(String identidade) {
        this.identidade = identidade;
    }

    /**
     * @return the data_nascimeto
     */
    public Date getData_nascimeto() {
        return data_nascimeto;
    }

    /**
     * @return the data_nascimeto
     */
    public String getData_nascimetoFormated() {
        return Formats.DATE_SYSTEM.format(data_nascimeto);
    }

    /**
     * @param data_nascimeto the data_nascimeto to set
     */
    public void setData_nascimeto(Date data_nascimeto) {
        this.data_nascimeto = data_nascimeto;
    }

    /**
     * @param data_nascimeto the data_nascimeto to set
     */
    public void setData_nascimeto(String data_nascimeto) {
        try {
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            this.data_nascimeto = df.parse(data_nascimeto);
        } catch (ParseException ex) {
            Logger.getLogger(Pessoa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

}
