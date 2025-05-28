/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blackjack_estruc;

/**
 *
 * @author AGSalud
 */
public class ArbolDecisionDealer {

    NodoDecision raiz;

    public ArbolDecisionDealer() {
        raiz = new NodoDecision(17, "plantarse");
        raiz.izquierda = new NodoDecision(0, "pedir");
        raiz.derecha = new NodoDecision(21, "plantarse");
    }

    public String decidir(int puntaje) {
        if (puntaje < 17) {
            return raiz.izquierda.accion;
        }
        return raiz.derecha.accion;
    }
}
