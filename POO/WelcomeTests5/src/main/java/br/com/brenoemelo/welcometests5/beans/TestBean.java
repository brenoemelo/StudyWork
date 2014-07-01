/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.brenoemelo.welcometests5.beans;

import java.io.Serializable;
import javax.annotation.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author b.melo
 */
@ManagedBean
@ViewScoped
public class TestBean implements Serializable {

    private String nome;

    public String getNome() {
        return "Olá " + nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
