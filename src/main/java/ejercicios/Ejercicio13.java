package ejercicios;

import recursos.HashMap;

/**
 * 7.13. Realizar un programa que tenga un Array con una agenda de teléfonos
 * simple con unos valores cualquiera. Por ejemplo: Marta 666111222 Miguel
 * 981981981 Ana 900900900 Daniel +34881000001 Al programa se le pasará como
 * parámetros un nombre. Si el nombre está en la agenda, mostrará su teléfono, y
 * en caso contrario informará que no existe dicha persona. java prog Ana. En el
 * tercer trimestre veremos que este tipo de estructuras, como la agenda, que no
 * van orientadas a una numeración específica, se almacenan mejor en estructuras
 * llamadas “Map”.
 * 
 */

public class Ejercicio13 {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        try{
            System.out.println(args[0] +" -> "+ map.getMap().get(args[0]));
        }catch(Exception message){
            System.out.println("El número no está en la agenda");
        }
    }
}
