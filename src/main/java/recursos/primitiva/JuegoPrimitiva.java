package recursos.primitiva;

public class JuegoPrimitiva{
    public JuegoPrimitiva (){
        //Empty juego
    }

    public int getAciertos (int [] boleto){
        Primitiva primitiva = new Primitiva();
        return primitiva.aciertos(boleto);
    }
}
