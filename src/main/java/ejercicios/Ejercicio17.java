package ejercicios;

import java.util.ArrayList;

import recursos.primitiva.BoletoPrimitiva;
import recursos.primitiva.Primitiva2;

/**
 * 7.17. Realiza una clase llamada Primitiva2 similar a la clase Primitiva, pero
 * empleando ahora una ArrayList, y aprovechando los métodos de los que dispone
 * para simplificar la generación de números sin repetidos. Además, los números
 * premiados se mantendrán ordenados y, por último, la búsqueda de los números
 * jugados en el ArrayList de los premiados se requiere que se haga de forma
 * dicotómica. Rehacer los 3 programas del ejercicio anterior de la Primitiva
 * pero usando esta nueva clase.  Programa que el usuario introduzca los 6
 * números de su boleto y le diga cuantos acertó.  Programa en el que se
 * generen 1000 boletos al azar y nos informe de cuantos boletos hay con 3, 4, 5
 * y 6 aciertos (a lo mejor es necesario crear un nuevo método en la clase
 * Primitiva para generar boletos al azar).  Programa con un bucle que genere
 * boletos hasta que acierte los 6 números ¿Cuántos boletos has tenido que
 * crear?
 */
public class Ejercicio17 {
    static void aciertos(Primitiva2 primitiva2, BoletoPrimitiva boletoPrimitiva) {
        System.out.println("\nHas acertado " + primitiva2.aciertos(boletoPrimitiva.getBoleto()));
    }

    static int[] milBoletos(Primitiva2 primitiva2) {
        BoletoPrimitiva[] milBoletos = new BoletoPrimitiva[1000];
        int[] counters = new int[4];
        for (int i = 0; i < milBoletos.length; i++) {
            milBoletos[i] = new BoletoPrimitiva(6);
        }
        for (int i = 0; i < milBoletos.length; i++) {
            switch (primitiva2.aciertos(milBoletos[i].getBoleto())) {
            case 3:
                counters[0]++;
                break;
            case 4:
                counters[1]++;
                break;
            case 5:
                counters[2]++;
                break;
            case 6:
                counters[3]++;
                break;
            default:
                break;
            }
        }
        return counters;
    }

    static int acertarTodo(Primitiva2 primitiva2) {
        int contador = 0;
        BoletoPrimitiva bPrimitiva;
        do {
            bPrimitiva = new BoletoPrimitiva(6);
            if (primitiva2.aciertos(bPrimitiva.getBoleto()) < 6) {
                contador++;
            }
        } while (primitiva2.aciertos(bPrimitiva.getBoleto()) != 6);
        return contador;
    }

    public static void main(String[] args) {
        Primitiva2 primitiva2 = new Primitiva2();
        BoletoPrimitiva boletoPrimitiva = new BoletoPrimitiva(6);
        int[] milBoletosResult = milBoletos(primitiva2);
        System.out.println("Hello people!!");
        System.out.println("Borrar");
        System.out.println(primitiva2.getNumeros().toString());
        for (int i = 0; i < boletoPrimitiva.getLength(); i++) {
            System.out.print(" " + boletoPrimitiva.getBoleto()[i]);
        }
        aciertos(primitiva2, boletoPrimitiva);
        System.out.println("3 aciertos: " + milBoletosResult[0]);
        System.out.println("4 aciertos: " + milBoletosResult[1]);
        System.out.println("5 aciertos: " + milBoletosResult[2]);
        System.out.println("6 aciertos: " + milBoletosResult[3]);
        System.out.println("Se han tenido que generar " + acertarTodo(primitiva2) + " boletos");
    }
}
