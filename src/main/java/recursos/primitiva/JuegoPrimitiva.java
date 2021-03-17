package recursos.primitiva;

public class JuegoPrimitiva{
    public JuegoPrimitiva (){
        //Empty juego
    }

    static int getAciretos (int [] boleto){
        Primitiva primitiva = new Primitiva();
        return primitiva.aciertos(boleto);
    }
}
