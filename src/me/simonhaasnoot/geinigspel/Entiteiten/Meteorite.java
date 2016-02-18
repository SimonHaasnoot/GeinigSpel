package me.simonhaasnoot.geinigspel.Entiteiten;

import me.simonhaasnoot.geinigspel.Tekenen;
import me.simonhaasnoot.geinigspel.Values;
import me.simonhaasnoot.geinigspel.level.Level1;

import java.awt.*;

/**
 * Created by Simon on 2/18/2016.
 */
public class Meteorite {

    private int x = 1050;
    private int y = -300;

    public Meteorite(){


    }

    public void collision(){

        if((Values.playerX + 45 > x && Values.playerX < x + 230) &&(Values.playerY + 50 > y && Values.playerY - 30 < y + 250)){
            Values.lives -= 3;
        }
    }

    public void draw(Graphics g){
        g.drawImage(Tekenen.img13, Level1.meteorite.getMeteoriteX(), Level1.meteorite.getMeteoriteY() , 300, 300, null);
    }

    public int getMeteoriteX(){
        return x;
    }

    public int getMeteoriteY(){
        return y;
    }

    public int decrementMeteoriteX(int xx){

        this.x = this.x - xx;
        return this.x;
    }

    public int incrementMeteoriteY(int yy){

        this.y = this.y + yy;
        return this.y;
    }
}
