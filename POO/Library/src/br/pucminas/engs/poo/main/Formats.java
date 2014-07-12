/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.pucminas.engs.poo.main;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author Breno/Bianca
 * Classe para definição de formatos específicos no sistema.
 */
public class Formats {
    public final static SimpleDateFormat DATE_MY_SQL = new SimpleDateFormat("yyyy-MM-dd");
    public final static SimpleDateFormat DATE_SYSTEM = new SimpleDateFormat("dd/MM/yyyy");
    public final static DecimalFormat BR_CURRENCY = new DecimalFormat("R$ #,##0.00");
    public final static DecimalFormat QUANTITY = new DecimalFormat("#,##0.00");
}
