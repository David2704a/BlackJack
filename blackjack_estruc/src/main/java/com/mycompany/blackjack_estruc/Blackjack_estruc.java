/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.blackjack_estruc;

import java.util.Scanner;

/**
 *
 * @author Johan
 */
public class Blackjack_estruc {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Baraja baraja = new Baraja();
        baraja.mezclar();
        
        System.out.println("Bienvenido a Blackjack versión consola");
        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();

        Jugador jugador = new Jugador(nombre);
        Jugador dealer = new Jugador("Dealer");

        ColaTurnos turnos = new ColaTurnos();
        turnos.agregar(jugador);
        turnos.agregar(dealer);

        // Primera ronda de cartas
        for (int i = 0; i < 2; i++) {
            jugador.recibirCarta(baraja.robar());
            dealer.recibirCarta(baraja.robar());
        }

        // Turnos
        while (!turnos.estaVacia()) {
            Jugador actual = turnos.remover();
            if (!actual.nombre.equals("Dealer")) {
                actual.mostrarMano();
                while (true) {
                    System.out.print("¿Desea otra carta? (s/n): ");
                    String opcion = scanner.nextLine();
                    if (opcion.equalsIgnoreCase("s")) {
                        actual.recibirCarta(baraja.robar());
                        actual.mostrarMano();
                        if (actual.obtenerPuntaje() > 21) {
                            System.out.println("Te pasaste de 21!");
                            break;
                        }
                    } else {
                        break;
                    }
                }
            } else {
                actual.mostrarMano();
                while (actual.obtenerPuntaje() < 17) {
                    System.out.println("El dealer toma una carta...");
                    actual.recibirCarta(baraja.robar());
                }
                System.out.println("El dealer se planta.");
                actual.mostrarMano();
            }
        }

        System.out.println("--- RESULTADOS ---");
        jugador.mostrarMano();
        dealer.mostrarMano();

        int p1 = jugador.obtenerPuntaje();
        int p2 = dealer.obtenerPuntaje();

        if ((p1 > p2 && p1 <= 21) || (p1 <= 21 && p2 > 21)) {
            System.out.println(jugador.nombre + " gana!");
        } else if ((p2 > p1 && p2 <= 21) || (p2 <= 21 && p1 > 21)) {
            System.out.println("El Dealer gana!");
        } else {
            System.out.println("Empate!");
        }
    }
}
