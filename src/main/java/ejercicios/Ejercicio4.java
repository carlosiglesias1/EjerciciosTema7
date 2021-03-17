package ejercicios;

/**
 * 7.4. Realizar un programa que defina un Array con 10 elementos e introduzca
 * valores a azar entre 1 y 20 pero garantizando que no se introducen repetidos.
 */

 public class Ejercicio4 {
    static void rellenarElementos (int [] elementos){
        for (int i = 0; i < elementos.length; i++) {
            do{
                elementos[i] = Ejercicio3.numero.nextInt(21)+1;
            }while(Ejercicio3.tieneRepetidos(elementos));
        }
    }
    public static void main(String[] args) {
        int [] elementos = {1,2,3,4,5,6,7,8,9,0};
        rellenarElementos(elementos);

        Ejercicio3.mostrarElementos(elementos);
    }
}
