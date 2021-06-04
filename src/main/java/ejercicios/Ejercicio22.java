package ejercicios;

import java.util.Random;

/**
 * 7.22. Realizar un programa que genere 10.000 números aleatorios entre 1 y 6
 * (como si fuese lanzar un dado). Guarda los resultados obtenidos, esto es,
 * cuantas veces ha salido el uno, cuantas veces ha salido el dos, etc… para
 * finalmente mostrar la diferencia de veces entre el número que más ha salido y
 * el que menos ha salido.
 */
public class Ejercicio22 {
    static void calcularNumeros (int [] numeros){
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            numeros[random.nextInt(6)]++;
        }
    }

    static int calcularMaximo (int [] numeros){
        //obtengo la posicion del array con el contador más alto, lo que quiere decir que 
        //es el número que más veces ha salido
        int maximo = 0;
        for (int i = 0; i < numeros.length; i++) {
            if(numeros[maximo]<numeros[i])
                maximo = i;
        }
        return maximo;
    }

    static int calcularMinimo (int [] numeros){
        int minimo = 0;
        for (int i = 0; i < numeros.length; i++) {
            if(numeros[minimo]> numeros[i])
                minimo = i;
        }
        return minimo;
    }
    public static void main(String[] args) {
        //Simplemente creo un array de 6 números, cada vez que salga un número aleatorio
        //Incremento la posicion que ha salido, como si fuesen 6 contadores
        int [] numeros = new int [6];
        calcularNumeros(numeros);
        int maximo = calcularMaximo(numeros);
        int minimo = calcularMinimo(numeros);
        System.out.println("El número que más veces ha salido es el "+(maximo+1)+", ha salido "+numeros[maximo]+" veces");
        System.out.println("El número que menos veces ha salido es el "+(minimo+1+", ha salido "+numeros[minimo]+" veces"));
        System.out.println("La diferencia entre ambos es de "+(numeros[maximo]-numeros[minimo]));
    }
}
