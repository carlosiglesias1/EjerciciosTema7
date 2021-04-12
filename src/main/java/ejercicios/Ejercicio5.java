package ejercicios;

import java.util.Random;
import java.util.Scanner;

import recursos.primitiva.*;

/**
 * Realizar una clase Primitiva que tenga definido un Array privado de 6
 * elementos con el resultado de un sorteo de la primitiva (serán 6 enteros con
 * valores comprendidos entre 1 y 49 y sin repetidos). La clase dispondrá de un
 * constructor en el que se generan y almacenen esos números al azar, también
 * tendrá un método al que se le pase una combinación jugada como parámetro (no
 * necesariamente ordenada) y devuelva el número de aciertos. Realiza tres
 * programas distintos que usen esa clase: Programa que el usuario introduzca
 * los 6 números de su boleto y le diga cuantos acertó. Programa en el que se
 * generen 1000 boletos al azar y nos informe de cuantos boletos hay con 3, 4, 5
 * y 6 aciertos (a lo mejor es necesario crear un nuevo método en la clase
 * Primitiva para generar boletos al azar). Programa con un bucle que genere
 * boletos hasta que acierte los 6 números ¿Cuántos boletos has tenido que
 * crear?
 * @author Carlos Iglesias Gómez
 * @version 1.0
 */

public class Ejercicio5 {
    static Random numero = new Random();

    static String imprimirBoleto (int [] boleto){
        String cadena = "";
        for (int i = 0; i < boleto.length; i++) {
            cadena +=(Integer.toString(boleto[i]));
        }
        return cadena;
    }

    static BoletoPrimitiva[] generarBoletos() {
        BoletoPrimitiva[] boletosPrimitiva = new BoletoPrimitiva[1000];
        for (int i = 0; i < boletosPrimitiva.length; i++) {
            for (int j = 0; j < 6; j++) {
                boletosPrimitiva[i] = new BoletoPrimitiva(6);
            }
        }
        return boletosPrimitiva;
    }

    static int contarAciertos(BoletoPrimitiva[] boletos, Primitiva primitiva, int indice) {
        int count = 0;
        for (int i = 0; i < boletos.length; i++) {
            if (boletos[i].getAciertos(primitiva) == indice)
                count++;
        }
        return count;
    }

    static int contarIntentos (){
        int contadorIntentos = 0;
        BoletoPrimitiva boleto;
        Primitiva primitiva;
        do {
            boleto = new BoletoPrimitiva(6);
            primitiva = new Primitiva();
            contadorIntentos++;
        } while (boleto.getAciertos(primitiva)!=6);
        return contadorIntentos;
    }
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        BoletoPrimitiva boleto = new BoletoPrimitiva(6);
        BoletoPrimitiva[] milBoletos = generarBoletos();
        Primitiva primitiva = new Primitiva();
        System.out.println("El boleto " + imprimirBoleto(boleto.getBoleto()) + " ha conseguido "
                + boleto.getAciertos(primitiva) + " aciertos de la primitiva " + imprimirBoleto(primitiva.getPrimitiva()));
        System.out.println("\nCon 1000 boletos los resultados son: ");
        System.out.println("\tHan tenido 3 aciertos: " + contarAciertos(milBoletos, primitiva, 3));
        System.out.println("\tHan tenido 4 aciertos: " + contarAciertos(milBoletos, primitiva, 4));
        System.out.println("\tHan tenido 5 aciertos: " + contarAciertos(milBoletos, primitiva, 5));
        System.out.println("\tHan tenido 6 aciertos: " + contarAciertos(milBoletos, primitiva, 6));
        System.out.println("\nHan hecho falta "+contarIntentos()+" intentos para lograr los 6 aciertos");
        teclado.close();
    }
}
