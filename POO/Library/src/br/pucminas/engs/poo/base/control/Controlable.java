/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.pucminas.engs.poo.base.control;

import br.pucminas.engs.poo.base.Livraria;
import br.pucminas.engs.poo.database.ConnectionFactory;
import java.util.ArrayList;

/**
 *
 * @author Breno, Bianca
 * @param <T> Recebe o tipo do objeto para ser utilizado na implementação
 */
public interface Controlable<T>{
    /**
     *
     * @param inserted Tipo <T> a ser inserido
     * @return True caso obtenha sucesso, falso caso o processo falhe
     */
    boolean insert(T inserted);
    /**
     * 
     * @param removed Tipo <T> a ser removido
     * @return True caso obtenha sucesso, falso caso o processo falhe
     */
    boolean remove(T removed);
    /**
     * 
     * @param updated Tipo <T> a ser inserido
     * @return True caso obtenha sucesso, falso caso o processo falhe
     */
    boolean update(T updated);
    /**
     * 
     * @return Lista com a pesquisa de todos os objetos tipo <T> registrados no banco
     */
    ArrayList<T> listAll();
    /**
     * 
     * @param query Query personalizada de listagem
     * @return Lista com o resultado da query
     */
    ArrayList<T> customList(String query);
    /**
     * 
     * @param id Lista um objeto tipo <T> especifíco com o ID passado
     * @return Objeto tipo <T> com o ID de parâmetro
     */
    T listById(int id);
    
    
}
