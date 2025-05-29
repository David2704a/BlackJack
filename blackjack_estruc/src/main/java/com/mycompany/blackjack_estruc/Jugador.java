/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blackjack_estruc;

/**
 *
 * @author Johan
 */
public class Jugador {

    String nombre;
    Carta mano;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.mano = null;
    }

    public void recibirCarta(Carta nueva) {
        nueva.siguiente = mano;
        mano = nueva;
    }

    public void mostrarMano() {
        System.out.println(nombre + " tiene:");
        Carta actual = mano;
        while (actual != null) {
            System.out.println("  " + actual);
            actual = actual.siguiente;
        }
        System.out.println("Puntaje: " + obtenerPuntaje());
    }

    public int obtenerPuntaje() {
        int suma = 0;
        int ases = 0;
        Carta actual = mano;
        while (actual != null) {
            int val = actual.obtenerValorNumerico();
            suma += val;
            if (actual.valor.equals("A")) {
                ases++;
            }
            actual = actual.siguiente;
        }
        while (suma > 21 && ases > 0) {
            suma -= 10;
            ases--;
        }
        return suma;
    }
}
