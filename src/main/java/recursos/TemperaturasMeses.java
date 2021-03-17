package recursos;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;


public class TemperaturasMeses {
    private int [] temperaturaMeses = new int [12];
    private Random temperaturaInicial = new Random();

    public TemperaturasMeses (){
        for (int i = 0; i < temperaturaMeses.length; i++) {
            this.temperaturaMeses[i] = this.temperaturaInicial.nextInt(41);
        }
    }

    public int [] getTemperaturas (){
        return this.temperaturaMeses;
    }

    public float temperaturaMedia () {
        float media = 0;
        for (int i = 0; i < temperaturaMeses.length; i++) {
            media += temperaturaMeses[i];
        }
        media /= 12;
        return media;
    }

    public List <Integer> mesesCalurosos (){
        List <Integer> mesesCalurosos = new ArrayList<Integer>();
        for (int i = 0; i < temperaturaMeses.length; i++) {
            if(temperaturaMeses[i] > 30)
                mesesCalurosos.add(i);
            
        }
        return mesesCalurosos;
    }
    
    public boolean huboMesCaluroso (){
        for (int i = 0; i < temperaturaMeses.length; i++) {
            if (temperaturaMeses[i]>30)
                return true;
        }
        return false;
    }
}
