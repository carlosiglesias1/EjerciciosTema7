package recursos;

import java.util.Scanner;

public class Alumno {
    private int [] notas = new int [10];
    static Scanner teclado = new Scanner(System.in);

    public Alumno (){
        int nota;
        for (int i = 0; i < notas.length; i++) {
            do{
                nota = teclado.nextInt();
            }while (nota<0 || nota > 10);
            this.notas[i] = nota;
        }
    }

    public float notaMedia (){
        float media = 0;
        for (int i = 0; i < this.notas.length; i++) {
            media += this.notas[i];
        }
        return media/10;
    }

    public int notaMaxima (){
        int maximo = 0;
        for (int i = 0; i < notas.length; i++) {
            if(this.notas[i] > maximo)
                maximo = this.notas[i];
        }
        return maximo;
    }

    public int notaMinima () {
        int minimo = 10;
        for (int i = 0; i < notas.length; i++) {
            if(this.notas[i] < minimo)
                minimo = this.notas[i];
        }
        return minimo;
    }

    public boolean vaFct (){
        for (int i = 0; i < notas.length; i++) {
            if(this.notas[i] < 5)
                return false;
        }
        return true;
    }

    public boolean promocionaMatricula (){
        for (int i = 0; i < notas.length; i++) {
            if (this.notas[i] < 9)
                return false;
        }
        return true;
    }

}
