package recursos.parkings;

import java.time.LocalTime;
import java.util.ArrayList;

public class Parking2 {
    private String matriculas[][];
    private int occupiedPLace;

    public Parking2() {
        matriculas = new String[20][2];
        occupiedPLace = 0;
    }

    public ArrayList<String[]> getStatus() {
        ArrayList<String[]> places = new ArrayList<String[]>();
        for (int i = 0; i < occupiedPLace; i++) {
            if (this.matriculas[i] != null) {
                places.add(matriculas[i]);
            }
        }
        return places;
    }

    public int getOccupiedPlaces() {
        return occupiedPLace;
    }

    public int park(String matricula) {
        if (occupiedPLace < 20) {
            this.matriculas[occupiedPLace][0] = matricula;
            this.matriculas[occupiedPLace][1] = LocalTime.now().toString();
            this.occupiedPLace++;
            return this.occupiedPLace;
        } else
            return 0;
    }

    public String[] unPark() {
        String[] unparking = new String[2];
        if (occupiedPLace == 0)
            return unparking;
        else {
            LocalTime timeNow = LocalTime.now();
            LocalTime initialTime = LocalTime.parse(matriculas[occupiedPLace][1]);
            occupiedPLace--;
            unparking[0] = matriculas[occupiedPLace][0];
            unparking[1] = Float.toString((timeNow.getSecond() - initialTime.getSecond()) * 0.02f);
            matriculas[occupiedPLace] = null;
            return unparking;
        }
    }
}
