/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blackjack_estruc;

/**
 *
 * @author AGSalud
 */
public class TablaHasJugadores {

    private final int TAM = 10;
    private Nodo[] tabla = new Nodo[TAM];

    private class Nodo {

        String clave;
        Jugador jugador;
        Nodo siguiente;

        Nodo(String clave, Jugador jugador) {
            this.clave = clave;
            this.jugador = jugador;
        }
    }

    private int hash(String clave) {
        return Math.abs(clave.hashCode()) % TAM;
    }

    public void agregarJugador(Jugador jugador) {
        int indice = hash(jugador.nombre);
        Nodo nuevo = new Nodo(jugador.nombre, jugador);
        nuevo.siguiente = tabla[indice];
        tabla[indice] = nuevo;
    }

    public Jugador obtenerJugador(String nombre) {
        int indice = hash(nombre);
        Nodo actual = tabla[indice];
        while (actual != null) {
            if (actual.clave.equals(nombre)) {
                return actual.jugador;
            }
            actual = actual.siguiente;
        }
        return null;
    }

    public void mostrarTabla() {
        for (int i = 0; i < TAM; i++) {
            Nodo actual = tabla[i];
            while (actual != null) {
                System.out.println("Jugador: " + actual.jugador.nombre + " | Puntaje: " + actual.jugador.obtenerPuntaje());
                actual = actual.siguiente;
            }
        }
    }
}
