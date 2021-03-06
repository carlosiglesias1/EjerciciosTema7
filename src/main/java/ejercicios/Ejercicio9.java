package ejercicios;

import java.time.Month;
import java.util.Scanner;

import recursos.temperaturas.TemperaturasVersionNueve;

/**
 * 7.9. Realiza un programa que tenga definido un Array como variable global
 * llamado temperaturaMeses, de 12 enteros, con las temperaturas medias de un
 * lugar en cada uno de los meses del año. Serán valores enteros negativos o
 * positivos. El programa tendrá diferentes funciones que realicen las
 * siguientes tareas: a. Llenar el Array con valores al azar para todos los
 * meses. Para enero, febrero, marzo, noviembre y diciembre los valores estarán
 * comprendidos entre -10 y +20 y para el resto de meses entre +10 y +40. b.
 * Mostrar por pantalla el contenido del array con el nombre de los meses (usar
 * clases Java para obtener el nombre del mes) c. Calcular la temperatura media
 * del año, usando printf especificando en el formato que incluya el signo “+”
 * en temperaturas positivas y que solo muestre 1 decimal. d. Mostrar la
 * temperatura máxima del año. e. Mostrar el mes más frío del año. f. Para hacer
 * pruebas estadísticas, desplazar los valores a la derecha, pasando el último
 * al primero. g. Para hacer pruebas estadísticas, desplazar los valores a
 * izquierda, pasando el primero al último. h. Decir si hay algún mes con más de
 * 30 grados, recorriendo lo imprescindible del array, es decir, en cuanto sepa
 * que sí hay alguno, que pare de recorrer el array. (No usar break) i. ¿Se
 * repitió alguna temperatura?
 */

public class Ejercicio9 {
    static void showTemps(int[] temps) {
        for (int i = 0; i < temps.length; i++) {
            System.out.print("[" + Month.of(i + 1) + ", " + temps[i] + "] ");
        }
        System.out.println();
    }

    static void prompMenu() {
        System.out.println("\nHola, bienvenido a tu lista de la compra");
        System.out.println("Pulsa 'c' para crear una nueva lista de temperaturas");
        System.out.println("Pulsa 's' para mostrar la lista de temperaturas");
        System.out.println("Pulsa 'a' para ver la temperatura media");
        System.out.println("Pulsa 'p' para ver la temperatura más alta del año");
        System.out.println("Pulsa 'f' para ver el mes más frío del año");
        System.out.println("Pulsa 'r' para mover las temperaturas a la derecha");
        System.out.println("Pulsa 'l' para mover las temperaturas a la izquierda");
        System.out.println("Pulsa 't' para saber si hay algún mes que supere los 30 grados");
        System.out.println("Pulsa 'e' para salir");
    }

    public static void main(String[] args) {
        TemperaturasVersionNueve tNueve = new TemperaturasVersionNueve();
        Scanner teclado = new Scanner(System.in);
        char opcion;
        do {
            prompMenu();
            showTemps(tNueve.getTemperaturas());
            opcion = teclado.nextLine().charAt(0);
            switch (opcion) {
            case 'c':
                tNueve.newTemperaturaMeses();
                break;
            case 's':
                break;
            case 'a':
                System.out.printf("Temperatura media: %.2f\n", tNueve.temperaturaMedia());
                break;
            case 'p':
                System.out.println("Temperatura más alta: " + tNueve.getTemperaturas()[tNueve.getMesMasCaliente()]);
                break;
            case 'f':
                System.out.println("Mes más frío: " + Month.of(tNueve.getMesMasFrio() + 1) + ", "
                        + tNueve.getTemperaturas()[tNueve.getMesMasFrio()]);
                break;
            case 'r':
                if (tNueve.moveTempsRight())
                    System.out.println("\nSe han movido las temperaturas");
                else
                    System.out.println("\nNo se ha completado la operación");
                System.out.println();
                break;
            case 'l':
                if (tNueve.moveTempsLeft())
                    System.out.println("\nSe han movido las temperaturas");
                else
                    System.out.println("\nNo se ha completado la operación");
                System.out.println();
                break;
            case 't':
                if (tNueve.plusThirty())
                    System.out.println("Lo hay");
                else
                    System.out.println("No lo hay");
                break;
            default:
                break;
            }
        } while (opcion != 'e');
        teclado.close();
    }
}
