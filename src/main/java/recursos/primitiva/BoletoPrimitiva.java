package recursos.primitiva;

public class BoletoPrimitiva {
    private int [] boleto;
    
    public BoletoPrimitiva (int [] numeros, int dimension){
        this.boleto = new int [dimension];
        for (int i = 0; i < numeros.length; i++) {
            System.arraycopy(numeros, i, this.boleto, i, boleto.length);
        }
    }

    public int getLength (){
        return this.boleto.length;
    }

    public int getAciertos (int [] boleto, Primitiva primitiva){
        return primitiva.aciertos(boleto);
    }
}
