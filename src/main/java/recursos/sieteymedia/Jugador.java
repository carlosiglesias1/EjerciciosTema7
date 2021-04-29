package recursos.sieteymedia;

import java.util.ArrayList;

public class Jugador {
    private ArrayList <Carta> cartas;
    private float puntos;
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

    public float getPuntos() {
        return puntos;
    }

    //metodos
    public void setPlantado() {
        this.plantado = true;
    }

    public boolean cogerCarta (Carta carta) {
        this.puntos += carta.valor;
        if (this.puntos > 7.5f)
            this.plantado = true;
        return (this.cartas.add(carta));
    }
}
