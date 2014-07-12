/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pucminas.engs.poo.login;

import br.pucminas.engs.poo.base.Usuario;
import br.pucminas.engs.poo.base.control.UsuarioControl;

/**
 *
 * @author Breno/Bianca
 */
public class SystemLogin {
 
    private String message;
    public static Usuario USUARIO_LOGADO;

    /**
     * Efetua a tentativa de login no sistema validando login e senha. O
     * atributo <b>message</b> retorna uma mensagem para o usuário informando o
     * resultado da operação.
     *
     * @param login Login a ser verificado
     * @param senha Senha a ser verificada
     * @return Retorna Usuario logado. Se retornar null, login e senha são
     * inválidas.
     */
    public boolean doLogin(String login, char[] senha) {
        if (login.length() == 0) {
            setMessage("Informe um Login válido!");
            return false;
        }
        if (senha == null) {
            setMessage("Informe sua senha!");
            return false;
        }

        if (senha.length < 6) {
            setMessage("A senha deve conter no mínimo 6 caracteres!");
            return false;
        }
        String pass = new String(senha);
        UsuarioControl control = new UsuarioControl();
        Usuario retorno = control.validatePass(login, pass);
        if (retorno != null) {
            message = "Login efetuado com sucesso!";
            USUARIO_LOGADO = retorno;
            USUARIO_LOGADO.setLogin("breno");
        } else {
            setMessage("Não foi possível efetuar o Login com os dados informados.");
            return false;
        }
        pass = null;
        for (int i = 0; i < senha.length; i++) {
            senha[i] = '0';
        }
        return USUARIO_LOGADO != null;
    }

    /**
     * @return Mensagem de retorno para o usuário.
     */
    public String getMessage() {
        if (message == null) {
            return "";
        } else {
            return message;
        }
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = "* " + message;

    }
}
