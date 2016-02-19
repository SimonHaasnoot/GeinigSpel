package me.simonhaasnoot.geinigspel.Entiteiten;
import me.simonhaasnoot.geinigspel.Values;

/**
 * Created by Simon on 2/18/2016.
 */
public class Fireball{

    public Fireball() { }

    public void collision(){

        // if the object reaches the outers of the field, reset them to spawn from above again
        for (int i = 0; i < Values.objects; i++) {

            if (Values.yObject[i] > 810) {
                Values.yObject[i] = (int) (Math.random() * -160 - 50);
                Values.xObject[i] = (int) (Math.random() * 1028 - 35 + 10);

                if(Values.timeDifference < 30000) {
                    Values.fallingSpeed[i] = (int) (Math.random() * Values.maxRandom + 1);
                }
                if(Values.timeDifference >= 30000){
                    Values.fallingSpeed[i] = (int) (Math.random() * Values.maxRandom + 2);
                }
            }
        }

        // check if an object hits the character.
        for (int i = 0; i < Values.objects; i++) {
            if (Values.yObject[i] <= Values.playerY + 50 && Values.yObject[i] > Values.playerY - 30 &&
                    (Values.xObject[i] <= Values.playerX + 50 && Values.xObject[i] >= Values.playerX - 15)) {

                // resets the object that hit the character, you lose 1 life, falling speed randomised from 1 to 5 again. first 30secs.
                Values.yObject[i] = (int) (Math.random() * -160 - 50);
                Values.xObject[i] = (int) (Math.random() * 1028 - 35 + 10);

                if(Values.timeDifference < 30000) {
                    Values.fallingSpeed[i] = (int) (Math.random() * Values.maxRandom + 1);
                }

                if(Values.timeDifference >= 30000) {
                    Values.fallingSpeed[i] = (int) (Math.random() * Values.maxRandom + 2);
                }
                // if you have a shield up, break the shield first.

                if(Values.activateShield){
                    Values.activateShield = false;
                    break;
                }
                // lose a life if you don't have shield.
                Values.lives -= 1;

            }
        }
    }
}
