package ejercicios;

import java.util.Random;
import java.util.Scanner;

import recursos.sieteymedia.*;

/**
 * 7.21. Realizar una versión del juego de cartas de las 7 y media para 3
 * jugadores. Los jugadores van solicitando cartas 1 a 1 para llegar a las 7 y
 * media sin pasarse, pudiendo plantarse cuando lo desee. Las figuras valen
 * medio punto y el resto su valor numérico. La baraja tiene 40 cartas. El juego
 * se acaba cuando todos los jugadores se planten, se hayan pasado, o se acaben
 * las cartas.
 */

public class Ejercicio21 {
    static boolean todosSePlantan(Jugador[] jugadors) {
        for (int i = 0; i < jugadors.length; i++) {
            if (!jugadors[i].getPlantado())
                return false;
        }
        return true;
    }

    static boolean quedanCartas(Carta[] baraja) {
        for (int i = 0; i < baraja.length; i++) {
            if (baraja[i] == null)
                return true;
        }
        return false;
    }

    static Carta sacarCarta(Carta[] baraja) {
        int posicion;
        do {
            Random random = new Random();
            posicion = random.nextInt(40);
        } while (baraja[posicion] != null);
        if (posicion > 27) {
            baraja[posicion] = new Figura();
            return baraja[posicion];
        } else {
            baraja[posicion] = new Numero(posicion);
            return baraja[posicion];
        }
    }

    static void inicializarJugadores(Jugador[] jugadores) {
        for (int i = 0; i < jugadores.length; i++) {
            jugadores[i] = new Jugador();
        }
    }

    static void verCartas(Jugador jugador) {
        for (int i = 0; i < jugador.getCartas().size(); i++) {
            System.out.print(" " + jugador.getCartas().get(i).getValor());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Carta[] baraja = new Carta[40];
        Jugador[] jugadores = new Jugador[3];
        char opcion;
        Scanner teclado = new Scanner(System.in);
        inicializarJugadores(jugadores);
        do {
            for (int i = 0; i < jugadores.length; i++) {
                if (!jugadores[i].getPlantado()) {
                    System.out.println("Es el turno del jugador " + (i + 1));
                    opcion = teclado.nextLine().charAt(0);
                    switch (opcion) {
                    case 'c':
                        jugadores[i].cogerCarta(sacarCarta(baraja));
                        verCartas(jugadores[i]);
                        break;
                    case 'p':
                        jugadores[i].setPlantado();
                        break;
                    }
                }
            }
        } while (!todosSePlantan(jugadores) && quedanCartas(baraja));

        teclado.close();
    }
}
