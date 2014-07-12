/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pucminas.engs.poo.base;

import java.util.Date;

/**
 *
 * @author Breno/Bianca
 */
public class Usuario {

    private int id_usuario;
    private Pessoa identificacao;
    private String login;
    private String senha;
    private Date ultimo_login;

    public Usuario() {
    }

    public Usuario(int id_usuario, Pessoa identificacao, String login, String senha, Date ultimo_login) {
        this.id_usuario = id_usuario;
        this.identificacao = identificacao;
        this.login = login;
        this.senha = senha;
        this.ultimo_login = ultimo_login;
    }

    /**
     * @return the id_usuario
     */
    public int getId_usuario() {
        return id_usuario;
    }

    /**
     * @param id_usuario the id_usuario to set
     */
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    /**
     * @return the identificacao
     */
    public Pessoa getIdentificacao() {
        return identificacao;
    }

    /**
     * @param identificacao the identificacao to set
     */
    public void setIdentificacao(Pessoa identificacao) {
        this.identificacao = identificacao;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the ultimo_login
     */
    public Date getUltimo_login() {
        return ultimo_login;
    }

    /**
     * @param ultimo_login the ultimo_login to set
     */
    public void setUltimo_login(Date ultimo_login) {
        this.ultimo_login = ultimo_login;
    }
}
