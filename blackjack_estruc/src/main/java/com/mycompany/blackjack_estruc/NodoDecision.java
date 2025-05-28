/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blackjack_estruc;

/**
 *
 * @author AGSalud
 */
public class NodoDecision {

    int valor;
    String accion;
    NodoDecision izquierda, derecha;

    public NodoDecision(int valor, String accion) {
        this.valor = valor;
        this.accion = accion;
    }
}
