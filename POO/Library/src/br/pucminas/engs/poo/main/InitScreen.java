/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pucminas.engs.poo.main;

import br.pucminas.engs.poo.view.cadastros.viewCadastroItem;
import br.pucminas.engs.poo.view.estoque.viewEstoqueLista;
import br.pucminas.engs.poo.view.estoque.viewEstoqueNovo;
import br.pucminas.engs.poo.view.pessoa.ViewCadastroPessoa;
import br.pucminas.engs.poo.view.livraria.viewCadastroLivraria;
import br.pucminas.engs.poo.view.livraria.viewLivrariaLista;
import br.pucminas.engs.poo.view.pedidos.viewAdicionaItem;
import br.pucminas.engs.poo.view.pedidos.viewAdicionaItemSimples;
import br.pucminas.engs.poo.view.pedidos.viewPedidoLista;
import br.pucminas.engs.poo.view.pedidos.viewPedidoNovo;

/**
 *
 * @author Breno/Bianca
 * Esta classe tem como objetivo manter uma instancia estatica de cada tela dos sistema
 * A fins de melhorar o desempenho durante o uso e manter os dados salvos caso o usuário saia da tela para 
 * efetuar outra consulta
 */
public class InitScreen {

    private static viewEstoqueLista oViewEstoqueLista;
    private static viewPedidoLista oViewPedidoLista;
    private static viewPedidoNovo oViewPedidoNovo;
    private static viewAdicionaItem oViewAdicionaItem;
    private static viewCadastroLivraria oViewCadastroLivraria;
    private static ViewCadastroPessoa oViewCadastroPessoa;
    private static viewLivrariaLista oViewListaLivraria;
    private static viewEstoqueNovo oViewEstoqueNovo;
    private static viewCadastroItem oViewCadastroItem;
    private static viewAdicionaItemSimples oViewAdicionaItemSimples;

    public static void initViewEstoqueLista() {
        if (oViewEstoqueLista == null) {
            oViewEstoqueLista = new viewEstoqueLista(null, true);
        }
        oViewEstoqueLista.setVisible(true);
    }

    public static void initViewPedidoLista() {
        if (oViewPedidoLista == null) {
            oViewPedidoLista = new viewPedidoLista(null, true);
        }
        oViewPedidoLista.setVisible(true);
    }

    public static void initViewPedidoNovo() {
        if (oViewPedidoNovo == null) {
            oViewPedidoNovo = new viewPedidoNovo(null, true);
        }
        oViewPedidoNovo.setVisible(true);
    }

    public static void initNovoPedidoItem() {
        if (oViewAdicionaItem == null) {
            oViewAdicionaItem = new viewAdicionaItem(null, true);
        }
        oViewAdicionaItem.setVisible(true);
    }

    public static void initoCadastroLivraria() {
        if (oViewCadastroLivraria == null) {
            oViewCadastroLivraria = new viewCadastroLivraria(null, true);
        }
        oViewCadastroLivraria.setVisible(true);
    }

    public static void initNovaPessoa() {
        if (oViewCadastroPessoa == null) {
            oViewCadastroPessoa = new ViewCadastroPessoa(null, true);
        }
        oViewCadastroPessoa.setVisible(true);
    }

    public static void initViewListaLivrarias() {
        if (oViewListaLivraria == null) {
            oViewListaLivraria = new viewLivrariaLista(null, true);
        }
        oViewListaLivraria.setVisible(true);
    }

    public static void initViewEntradEstoque() {
        if (oViewEstoqueNovo == null) {
            oViewEstoqueNovo = new viewEstoqueNovo(null, true);
        }
        oViewEstoqueNovo.setVisible(true);
    }

    public static void initViewCadastroItem() {
        if (oViewCadastroItem == null) {
            oViewCadastroItem = new viewCadastroItem(null, true);
        }
        oViewCadastroItem.setVisible(true);
    }

    public static void initViewAdicionaItemSimples() {
        if (oViewAdicionaItemSimples == null) {
            oViewAdicionaItemSimples = new viewAdicionaItemSimples(null, true);
        }
        oViewAdicionaItemSimples.setVisible(true);
    }

}
