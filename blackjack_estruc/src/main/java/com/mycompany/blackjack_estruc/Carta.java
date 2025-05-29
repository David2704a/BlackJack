/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blackjack_estruc;

/**
 *
 * @author Johan
 */
public class Carta {

    String valor;
    String palo;
    Carta siguiente;

    public Carta(String valor, String palo) {
        this.valor = valor;
        this.palo = palo;
        this.siguiente = null;
    }

    public int obtenerValorNumerico() {
        switch (valor) {
            case "A":
                return 11;
            case "J":
            case "Q":
            case "K":
                return 10;
            default:
                return Integer.parseInt(valor);
        }
    }

    public String toString() {
        return valor + " de " + palo;
    }
}
