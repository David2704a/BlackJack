/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blackjack_estruc;

import java.util.Stack;

/**
 *
 * @author AGSalud
 */
public class HistorialCartas {

    private Stack<Carta> pila = new Stack<>();

    public void agregar(Carta carta) {
        pila.push(carta);
    }

    public void mostrarHistorial() {
        for (Carta c : pila) {
            System.out.println(c);
        }
    }
}
