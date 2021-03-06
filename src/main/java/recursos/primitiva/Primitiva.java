package recursos.primitiva;

import java.util.Random;

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
 */

public class Primitiva {
    private int [] digitos = {1,2,3,4,5,6};
    private Random numero = new Random();

    private boolean repetidos (){
        for (int i = 0; i < digitos.length; i++) {
            for (int j = 0; j < digitos.length; j++) {
                if(this.digitos[j] == this.digitos[i] && i != j)
                    return true;
            }
        }
        return false;
    }

    private boolean repetidos (int [] combinaciones){
        for (int i = 0; i < combinaciones.length; i++) {
            for (int j = 0; j < combinaciones.length; j++) {
                if(combinaciones[j] == combinaciones[i] && i != j)
                    return true;
            }
        }
        return false;
    }

    public Primitiva (){
        for (int i = 0; i < digitos.length; i++) {
            do{
                this.digitos[i] = numero.nextInt(50)+1;
            }while(!repetidos());
        }
    }

    public int aciertos (int [] combinacion){
        int acierta = 0;
        if(repetidos(combinacion))
            return acierta;
        else{
            for (int i = 0; i < digitos.length; i++) {
                for (int j = 0; j < combinacion.length; j++) {
                    if (digitos[i] == combinacion[j])
                        acierta++;
                }
            }
            return acierta;
        }
    }

    public int [] getPrimitiva (){
        return this.digitos;
    }
}
