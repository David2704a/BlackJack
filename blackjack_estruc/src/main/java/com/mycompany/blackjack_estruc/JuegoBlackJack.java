/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blackjack_estruc;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author AGSalud
 */
public class JuegoBlackJack {

    private Scanner scanner = new Scanner(System.in);
    private Baraja baraja = new Baraja();
    private HistorialCartas historial = new HistorialCartas();
    private ColaTurnos cola = new ColaTurnos();
    private ArbolDecisionDealer arbol = new ArbolDecisionDealer();
    private HashMap<String, Jugador> jugadores = new HashMap<>();

    public void iniciar() {
        System.out.println("Bienvenido a Blackjack");
        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();
        Jugador jugador = new Jugador(nombre);
        Jugador dealer = new Jugador("Dealer");
        jugadores.put(nombre, jugador);
        jugadores.put("Dealer", dealer);
        cola.agregarTurno(nombre);
        cola.agregarTurno("Dealer");

        // Repartir cartas iniciales
        for (int i = 0; i < 2; i++) {
            jugador.recibirCarta(baraja.robarCarta());
            dealer.recibirCarta(baraja.robarCarta());
        }

        while (cola.hayTurnos()) {
            String turno = cola.siguienteTurno();
            Jugador actual = jugadores.get(turno);
            System.out.println("\nTurno de: " + turno);
            actual.mostrarMano();

            if (!turno.equals("Dealer")) {
                while (true) {
                    System.out.print("¿Desea otra carta? (s/n): ");
                    String r = scanner.nextLine();
                    if (r.equalsIgnoreCase("s")) {
                        Carta nueva = baraja.robarCarta();
                        actual.recibirCarta(nueva);
                        historial.agregar(nueva);
                        actual.mostrarMano();
                        if (actual.calcularPuntaje() > 21) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
            } else {
                while (arbol.decidir(actual.calcularPuntaje()).equals("pedir")) {
                    System.out.println("El dealer toma una carta...");
                    Carta nueva = baraja.robarCarta();
                    actual.recibirCarta(nueva);
                    historial.agregar(nueva);
                }
                System.out.println("El dealer se planta.");
            }
        }

        mostrarResultados(jugador, dealer);
    }

    private void mostrarResultados(Jugador jugador, Jugador dealer) {
        System.out.println("\n--- RESULTADOS ---");
        System.out.println(jugador.getNombre() + " tiene:");
        jugador.mostrarMano();
        System.out.println("\nDealer tiene:");
        dealer.mostrarMano();

        int puntJugador = jugador.calcularPuntaje();
        int puntDealer = dealer.calcularPuntaje();

        if (puntJugador > 21 || (puntDealer <= 21 && puntDealer > puntJugador)) {
            System.out.println("\nDealer gana!");
        } else if (puntDealer > 21 || puntJugador > puntDealer) {
            System.out.println("\n" + jugador.getNombre() + " gana!");
        } else {
            System.out.println("\nEmpate.");
        }
    }
}
