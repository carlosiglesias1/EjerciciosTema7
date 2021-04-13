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
    static void showTemps(TemperaturasVersionNueve tNueve) {
        for (int i = 0; i < tNueve.getTemperaturas().length; i++) {
            System.out.print("[" + tNueve.getTemperaturas()[i] + "] ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TemperaturasVersionNueve tNueve = new TemperaturasVersionNueve();
        Scanner teclado = new Scanner(System.in);
        char opcion;
        do {
            showTemps(tNueve);
            opcion = teclado.nextLine().charAt(0);
            switch (opcion) {
            case 'c':
                tNueve.newTemperaturaMeses();
                break;
            case 's':
                showTemps(tNueve);
                break;
            case 'a':
                System.out.printf("Temperatura media: %.2f\n", tNueve.temperaturaMedia());
                break;
            case '+':
                System.out.printf("Temperatura más alta: %.2f\n", tNueve.getTemperaturas()[tNueve.getMesMasCaliente()]);
                break;
            case 'f':
                System.out.println("Mes más frío: " + Month.of(tNueve.getMesMasFrio()));
                break;
            default:
                break;
            }

        } while (opcion != 'e');
    }
}
