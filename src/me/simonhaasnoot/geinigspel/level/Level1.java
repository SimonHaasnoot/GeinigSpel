package me.simonhaasnoot.geinigspel.level;
import me.simonhaasnoot.geinigspel.Values;

public class Level1 extends BaseLevel {



    public void update() {

            dropShield();
            spawnThunder();
            spawnFireballs();
            spawnMeteorite();
        }

    public void spawnMeteorite(){

        int meteoriteSpawntime = (int)(Math.random()*1000 + 8000);

        if((meteoriteSpawntime - Values.timeDifference) < 5000){
            Values.spawnMeteoriteWarning = true;
        }

        if(Values.timeDifference >= meteoriteSpawntime - 50 && Values.timeDifference <= meteoriteSpawntime){
            Values.spawnMeteorite = true;

        }
        if(Values.spawnMeteorite ){
            Values.spawnMeteoriteWarning = false;

            Values.meteoriteX = Values.meteoriteX - 6;
            Values.meteoriteY = Values.meteoriteY + 5;
        }

    }

    public void spawnThunder(){

        boolean ThundercountBool = true;
        for (int i = 0; i < Values.thunderRandomTime.length; i++) {

            if(Values.timeDifference >= Values.thunderRandomTime[i] - 50 && Values.timeDifference <= Values.thunderRandomTime[i]){
                Values.spawnThunder = true;
                Values.thunderCollide = true;

                if(ThundercountBool){
                    ThundercountBool = false;
                }
            }
        }
    }

    public void dropShield() {

        int shieldDropSpawntime = (int)(Math.random()*50000 + 1000);

        if (Values.timeDifference >= shieldDropSpawntime - 50 && Values.timeDifference <= shieldDropSpawntime) {
            Values.spawnShield = true;
        }
    }

    public void spawnFireballs(){

        int time = 5000;
        for(int i = 0; i < Values.yObject.length; i++) {
            
            if(Values.timeDifference > time) {
                Values.yObject[i] += Values.fallingSpeed[i];
            }
            time += (time * 0.9);
            System.out.println(Values.yObject[i] + " " + time);
        }      
    }    
}
