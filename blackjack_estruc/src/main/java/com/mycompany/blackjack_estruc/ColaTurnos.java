/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blackjack_estruc;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author AGSalud
 */
public class ColaTurnos {

    private Queue<String> turnos = new LinkedList<>();

    public void agregarTurno(String nombre) {
        turnos.offer(nombre);
    }

    public String siguienteTurno() {
        return turnos.poll();
    }

    public boolean hayTurnos() {
        return !turnos.isEmpty();
    }
}
