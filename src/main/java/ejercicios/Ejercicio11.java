package ejercicios;

import java.time.Month;
import java.util.Random;

/**
 * 7.11. Realizar un programa que tenga definido un Array de 12 filas y 30
 * columnas llamado temperaturaDia con las temperaturas medias de un lugar en
 * cada uno de los días del año (suponemos meses de 30 días). Serán valores
 * enteros negativos o positivos. El programa debe tener funciones para realizar
 * las siguientes tareas: a. Llenar de valores el Array: para evitar tener que
 * introducir los valores a mano, genera valores al azar para todos los días.
 * Para enero, febrero, marzo, noviembre y diciembre los valores estarán
 * comprendidos entre -10 y +20 y para el resto de meses entre +10 y +35. b.
 * Mostrar por pantalla el contenido del array en forma de tabla: todos los días
 * de un mes en la misma fila, ocupando 3 posiciones (una para el signo y dos
 * dígitos para la temperatura). c. Mostrar la temperatura media del año. d.
 * Mostrar el día en el que más calor hizo del año. e. Calcular la temperatura
 * media de cada mes. f. Decir si hay algún día con más de 30 grados,
 * recorriendo lo imprescindible del array, es decir, en cuanto sepa que sí hay
 * alguno, que pare de recorrer el array. g. Crear un Array unidimensional con
 * la temperatura mínima de cada mes.
 */

public class Ejercicio11 {
    static void fullMatrix (int [][] matrix, Random random){
        for (int i = 0; i < matrix.length; i++) {
            switch (i) {
                case 11:
                case 12:
                case 0:
                case 1:
                case 2:
                    for (int j = 0; j < 30; j++) {
                        matrix[i][j]= random.nextInt(31)-10;
                    }
                    break;
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                    for (int j = 0; j < 30; j++) {
                        matrix[i][j]= random.nextInt(25)+10;
                    }
                    break;
                default:
                    break;
                }
        }
    }

    static void showMatrix (int [][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < 30; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    static float avgTemperature (int[][] matrix){
        float average = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < 30; j++) {
                average += matrix[i][j];
            }
        }
        return average/365;
    }

    static float [] monthlyTemperature (int[][] matrix){
        float [] avgTemperature = new float [12];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < 30; j++) {
                avgTemperature[i]+=matrix[i][j];
            }
        }
        for (int i = 0; i < avgTemperature.length; i++) {
            avgTemperature[i] /= 30;
        }
        return avgTemperature;
    }

    static int maxTemperature (int [][] matrix){
        int max = -1000; 
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < 30; j++) {
                if(max < matrix[i][j])
                max = matrix[i][j];
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int [][] temperaturaMes = new int [12][30];
        Random random = new Random();
        fullMatrix(temperaturaMes, random);
        showMatrix(temperaturaMes);
        
        System.out.println("\nTEMPERATURA MEDIA: "+avgTemperature(temperaturaMes));
        System.out.println("\nTEMPERATURA MÁXIMA: "+maxTemperature(temperaturaMes));
        System.out.println();
        
        float[] medias = monthlyTemperature(temperaturaMes);
        for (int i = 0; i < medias.length; i++) {
            System.out.printf("[%s: %.2f] ", Month.of(i+1),medias[i]);
        }
    }
}
