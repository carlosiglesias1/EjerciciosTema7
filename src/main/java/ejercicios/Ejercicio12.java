package ejercicios;

/**
 * 7.12. Realizar un programa llamado hipotenusa al que se le pasen como
 * parámetros dos valores, verifique que son enteros positivos y que suponiendo
 * que son los catetos de un ángulo recto, calcule el valor de la hipotenusa.
 * (se refiere a introducirlos en la llamada al programa, java prog param1
 * param2, sería algo así: java hipotenusa 4 2.
 */

public class Ejercicio12 {
    public static void main(String[] args) {
        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);
        double hyp = Math.sqrt((num1*num1) + (num2 *num2));
        System.out.printf("%.2f", hyp);
    }
}
