/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blackjack_estruc;

/**
 *
 * @author AGSalud
 */
public class ColaTurnos {

    NodoJugador frente, fin;

    public void agregar(Jugador jugador) {
        NodoJugador nuevo = new NodoJugador(jugador);
        if (fin != null) {
            fin.siguiente = nuevo;
        } else {
            frente = nuevo;
        }
        fin = nuevo;
    }

    public Jugador remover() {
        if (frente == null) {
            return null;
        }
        Jugador j = frente.jugador;
        frente = frente.siguiente;
        if (frente == null) {
            fin = null;
        }
        return j;
    }

    public boolean estaVacia() {
        return frente == null;
    }
}
