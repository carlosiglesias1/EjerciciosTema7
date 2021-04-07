package recursos.parkings;

import java.util.ArrayList;

public class Parking {
    private String matriculas [];
    private int occupiedPLace;
    public Parking (){
        matriculas = new String [20];
        occupiedPLace = 0;
    }

    public Object [] getStatus (){
       ArrayList<String> places = new ArrayList<String>();
        for (int i = 0; i < occupiedPLace; i++) {
            if(this.matriculas[i] != null){
                places.add(matriculas[i]);
            }
        }
       return places.toArray();
    }

    public int getOccupiedPlaces (){
        return occupiedPLace;
    }

    public int park (String matricula){
        if(occupiedPLace < 20){
            this.matriculas[occupiedPLace] = matricula;
            this.occupiedPLace++;
            return this.occupiedPLace;
        }else
            return 0;
    }

    public String unPark (){
        if (occupiedPLace == 0) 
            return "";
        else{
            occupiedPLace--;
            String matricula = matriculas[occupiedPLace];
            matriculas[occupiedPLace] = null;
            return matricula;
        }
    }
}
