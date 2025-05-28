/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blackjack_estruc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 *
 * @author AGSalud
 */
public class Baraja {

    private NodoCarta cabeza;

    public Baraja() {
        construirBaraja();
    }

    public void construirBaraja() {
        String[] palos = {"Corazones", "Diamantes", "Tréboles", "Picas"};
        String[] valores = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        List<Carta> cartas = new ArrayList<>();
        for (String palo : palos) {
            for (String valor : valores) {
                cartas.add(new Carta(valor, palo));
            }
        }
        Collections.shuffle(cartas);
        for (Carta carta : cartas) {
            NodoCarta nuevo = new NodoCarta(carta);
            nuevo.siguiente = cabeza;
            cabeza = nuevo;
        }
    }

    public Carta robarCarta() {
        if (cabeza == null) {
            return null;
        }
        Carta carta = cabeza.carta;
        cabeza = cabeza.siguiente;
        return carta;
    }
}
