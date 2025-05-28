/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blackjack_estruc;

/**
 *
 * @author AGSalud
 */
public class Carta {

    private String valor;
    private String palo;

    public Carta(String valor, String palo) {
        this.valor = valor;
        this.palo = palo;
    }

    public int obtenerValorNumerico() {
        if (valor.equals("A")) return 11;
        if (valor.equals("K") || valor.equals("Q") || valor.equals("J")) return 10;
        return Integer.parseInt(valor);
    }

    @Override
    public String toString() {
        return valor + " de " + palo;
    }
}
