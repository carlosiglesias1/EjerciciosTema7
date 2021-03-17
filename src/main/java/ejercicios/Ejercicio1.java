package ejercicios;

import recursos.TemperaturasMeses;

/**
 * 7.1. Realiza un programa que tenga definido un Array como variable global
 * llamado temperaturaMeses, de 12 enteros, con las temperaturas medias de un
 * lugar en cada uno de los meses del año. Serán valores enteros negativos o
 * positivos. El programa tendrá diferentes funciones que realicen las
 * siguientes tareas: a. Llenar el Array con valores al azar para todos los
 * meses (entre 0 y 40). b. Mostrar por pantalla el contenido del Array. c.
 * Mostrar por pantalla el contenido del Array en orden inverso. d. Mostrar la
 * temperatura media del año. e. Mostrar los meses en los que hizo más de 30
 * grados. f. Decir si hay algún mes con más de 30 grados
 * 
 */

public class Ejercicio1 {
    static void mostrarTemperaturas (int [] temperaturaMeses){
        for (int i = 0; i < temperaturaMeses.length; i++) {
            System.out.print("["+temperaturaMeses[i]+"]");
        }
    }

    static void mostrarTemperaturasReverse (int [] temperaturaMeses) {
        for (int i = temperaturaMeses.length-1; i > -1; i--) {
            System.out.print("["+temperaturaMeses[i]+"]");
        }
    }

    public static void main(String[] args) {
        String [] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Ocutbre", "Noviembre", "Diciembre"}; 
        TemperaturasMeses temperaturasMeses = new TemperaturasMeses();
        
        mostrarTemperaturas(temperaturasMeses.getTemperaturas());

        System.out.println();

        mostrarTemperaturasReverse(temperaturasMeses.getTemperaturas());

        System.out.println();

        if (temperaturasMeses.huboMesCaluroso()){
            for (int i = 0; i < temperaturasMeses.mesesCalurosos().size(); i++) {
                System.out.print("["+meses[temperaturasMeses.mesesCalurosos().get(i)]+"]");
            }
        }

        System.out.println();

        System.out.printf("Temperatura media: %.2f",temperaturasMeses.temperaturaMedia());
        
    }
}
