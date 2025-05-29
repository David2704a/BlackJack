/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blackjack_estruc;

/**
 *
 * @author Johan
 */
public class Baraja {

    Carta inicio;
    String[] valores = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    String[] palos = {"Corazones", "Diamantes", "Tréboles", "Picas"};

    public Baraja() {
        for (String palo : palos) {
            for (String valor : valores) {
                agregarCarta(new Carta(valor, palo));
            }
        }
    }

    void agregarCarta(Carta nueva) {
        nueva.siguiente = inicio;
        inicio = nueva;
    }

    public void mezclar() {
        Carta[] cartas = new Carta[52];
        int i = 0;
        while (inicio != null) {
            cartas[i++] = robar();
        }
        for (int j = cartas.length - 1; j > 0; j--) {
            int k = (int) (Math.random() * (j + 1));
            Carta temp = cartas[j];
            cartas[j] = cartas[k];
            cartas[k] = temp;
        }
        for (Carta c : cartas) {
            agregarCarta(c);
        }
    }

    public Carta robar() {
        if (inicio == null) {
            return null;
        }
        Carta temp = inicio;
        inicio = inicio.siguiente;
        return temp;
    }
}
