package ejercicios;

import java.time.*;

import recursos.Contacto;

/**
 * 7.28. Sobre el siguiente código, modifica la clase Contacto para que funcione
 * el main() mostrado:
 */

public class Ejercicio28 {
    public static void main(String[] args) {
        Contacto[] agenda = new Contacto[10];
        agenda[0] = new Contacto("Marta", 6661111222L, LocalDate.parse("2019-11-25"));
        agenda[1] = new Contacto("Miguel", 1111111L, LocalDate.now());
        agenda[2] = new Contacto("Ana", 3333333L, "2019-11-20");
        agenda[3] = new Contacto("Daniel", 444444L);
    }
}
