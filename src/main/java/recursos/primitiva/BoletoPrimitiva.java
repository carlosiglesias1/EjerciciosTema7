package recursos.primitiva;

import java.util.Random;

public class BoletoPrimitiva {
    private int [] boleto;
    private Random numero = new Random();

    public BoletoPrimitiva (int dimension){
        this.boleto = new int [dimension];
        for (int i = 0; i < this.boleto.length; i++) {
            this.boleto[i] = numero.nextInt(49)+1;
        }
    }

    public int getLength (){
        return this.boleto.length;
    }

    public int [] getBoleto (){
        return this.boleto;
    }

    public int getAciertos (Primitiva primitiva){
        return primitiva.aciertos(this.boleto);
    }
}
