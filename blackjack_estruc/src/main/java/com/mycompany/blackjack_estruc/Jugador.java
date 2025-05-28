/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blackjack_estruc;

import java.util.ArrayList;

/**
 *
 * @author AGSalud
 */
public class Jugador {

    private String nombre;
    private ArrayList<Carta> mano = new ArrayList<>();

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    public void recibirCarta(Carta carta) {
        mano.add(carta);
    }

    public int calcularPuntaje() {
        int total = 0;
        int ases = 0;
        for (Carta c : mano) {
            int valor = c.obtenerValorNumerico();
            if (valor == 11) {
                ases++;
            }
            total += valor;
        }
        while (total > 21 && ases > 0) {
            total -= 10;
            ases--;
        }
        return total;
    }

    public void mostrarMano() {
        for (Carta c : mano) {
            System.out.println("  " + c);
        }
        System.out.println("Puntaje: " + calcularPuntaje());
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Carta> getMano() {
        return mano;
    }
}
