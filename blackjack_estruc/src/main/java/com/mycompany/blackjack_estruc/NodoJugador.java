/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blackjack_estruc;

/**
 *
 * @author AGSalud
 */
public class NodoJugador {

    Jugador jugador;
    NodoJugador siguiente;

    public NodoJugador(Jugador jugador) {
        this.jugador = jugador;
        this.siguiente = null;
    }
}
