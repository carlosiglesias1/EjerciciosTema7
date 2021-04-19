package ejercicios;

import recursos.AlturaAlumnos;

/**
 * 7.15. Realiza un programa que tenga un ArrayList llamado AlturaAlumnos que
 * mantenga una lista con las alturas de los alumnos de un centro. Serán valores
 * positivos entre 0,50 y 2,50 redondeados a dos decimales. El programa tendrá
 * las siguientes funciones (accesibles mediante un menú): a. Añadir altura. b.
 * Mostrar lista actual con el número de posición c. Eliminar por posición. Se
 * le pasa como parámetro una posición y elimina la altura en dicha posición. d.
 * Eliminar por valor. Se le pasa como parámetro una altura y elimina todas las
 * posiciones en las que se encuentre dicha altura. Devuelve la cantidad de
 * eliminaciones. e. Ordenar la lista. f. Vaciar la lista.
 * 
 */

public class Ejercicio15 {
    static void printAlturas (AlturaAlumnos alturaAlumnos){
        for (int i = 0; i < alturaAlumnos.getList().size(); i++) {
            System.out.println("["+(i+1)+" -> "+alturaAlumnos.getList().get(i)+"]");
        }
    }
    public static void main(String[] args) {
        AlturaAlumnos alturaAlumnos = new AlturaAlumnos();

        alturaAlumnos.addAltura(2.50f);
        alturaAlumnos.addAltura(1.65f);
        printAlturas(alturaAlumnos);
        alturaAlumnos.orderList();
        printAlturas(alturaAlumnos);
    }
}
