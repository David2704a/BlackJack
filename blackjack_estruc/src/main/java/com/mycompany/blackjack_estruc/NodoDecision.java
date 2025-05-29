/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blackjack_estruc;

/**
 *
 * @author Johan
 */
public class NodoDecision {

    int valor;
    String decision;
    NodoDecision izquierda;
    NodoDecision derecha;

    NodoDecision(int valor, String decision) {
        this.valor = valor;
        this.decision = decision;
    }
}
