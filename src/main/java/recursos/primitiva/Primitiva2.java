package recursos.primitiva;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Primitiva2 {
    private ArrayList <Integer> numeros = new ArrayList<Integer>();
    private Random nRandom = new Random();

    public Primitiva2 (){
        do{
            int numero = this.nRandom.nextInt(50)+1;
            if (!this.numeros.contains(numero)) 
                this.numeros.add(numero);
        }while(this.numeros.size() < 6);
    }

    public ArrayList<Integer> getNumeros() {
        return this.numeros;
    }

    private boolean boletoValido (int [] combinacion){
        for (int i = 0; i < combinacion.length; i++) {
            for (int j = 0; j < combinacion.length; j++) {
                if(combinacion[j] == combinacion[i] && i != j)
                    return false;
            }
        }
        return true;
    }

    public int aciertos (int [] combinacion){
        Collections.sort(this.numeros);
        Arrays.sort(combinacion);
        if(!boletoValido(combinacion))
            return -1;
        else{
            int aciertos = 0;
            for (int i = 0; i < combinacion.length; i++) {
                if(this.numeros.contains(combinacion[i]))
                aciertos++;
            }
            return aciertos;
        }
    }
}
