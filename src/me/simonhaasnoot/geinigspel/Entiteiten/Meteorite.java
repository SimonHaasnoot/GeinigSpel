package me.simonhaasnoot.geinigspel.Entiteiten;
import me.simonhaasnoot.geinigspel.Values;

import java.awt.*;

/**
 * Created by Simon on 2/18/2016.
 */
public class Meteorite {

    public Meteorite(){


    }

    public void collision(){

        if((Values.playerX + 45 > Values.meteoriteX && Values.playerX < Values.meteoriteX + 230) &&(Values.playerY + 50 > Values.meteoriteY  && Values.playerY - 30 < Values.meteoriteY + 250)){
            Values.lives -= 3;
        }
    }
}
