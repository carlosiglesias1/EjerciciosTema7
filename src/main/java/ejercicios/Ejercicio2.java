package ejercicios;

import recursos.Alumno;

/**
 * 7.2. Realizar un programa que tenga un Array con las 10 notas de un alumno de
 * ciclos formativos. Primero se le pedirá al usuario que introduzca valores
 * para las 10 asignaturas, verificando que los valores estén entre 1 y 10 (si
 * lo introduce mal, deberá introducirlos hasta que lo haga bien) Mostrar la
 * nota máxima, mínima, media, si puede ir a la FCT (todas >=5), y si se propone
 * para matrícula de honor (todas 9 ó 10).
 */

public class Ejercicio2 {
    public static void main(String[] args) {
        Alumno alumno = new Alumno();
        System.out.println();

        System.out.println(alumno.notaMedia());
        System.out.println(alumno.notaMaxima());
        System.out.println(alumno.notaMinima());
        if(alumno.vaFct())
            System.out.println("Promociona para fct");
        else
            System.out.println("No promociona para fct");
        if(alumno.promocionaMatricula())
            System.out.println("El alumno promociona para matrícula de honor");
        else
            System.out.println("El alumno no promociona para matrícula de honor");
    }
}
