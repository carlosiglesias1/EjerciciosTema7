package recursos.sieteymedia;

import java.util.ArrayList;

public class Jugador {
    private ArrayList <Carta> cartas;
    private boolean plantado;

    public Jugador (){
        this.cartas = new ArrayList<Carta>();
        this.plantado = false;
    }

    //getters
    public ArrayList<Carta> getCartas() {
        return this.cartas;
    }

    public boolean getPlantado (){
        return this.plantado;
    }

    //metodos
    public void setPlantado() {
        this.plantado = true;
    }

    public boolean cogerCarta (Carta carta) {
        float suma = 0;
        for (int i = 0; i < this.cartas.size(); i++) {
            suma += this.cartas.get(i).getValor();
        }
        suma += carta.getValor();
        if (suma > 7.5f)
            this.plantado = true;
        return (this.cartas.add(carta));
    }
}
