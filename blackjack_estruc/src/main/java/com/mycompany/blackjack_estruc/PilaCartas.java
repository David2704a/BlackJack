/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blackjack_estruc;

/**
 *
 * @author Johan
 */
public class PilaCartas {

    private Carta cima;

    public void push(Carta carta) {
        carta.siguiente = cima;
        cima = carta;
    }

    public Carta pop() {
        if (cima == null) {
            return null;
        }
        Carta temp = cima;
        cima = cima.siguiente;
        return temp;
    }

    public boolean estaVacia() {
        return cima == null;
    }

    public void mostrarCartas() {
        System.out.println("Historial de cartas jugadas:");
        Carta actual = cima;
        while (actual != null) {
            System.out.println(" - " + actual);
            actual = actual.siguiente;
        }
    }
}
