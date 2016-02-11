import java.util.Random;

/**
 * Created by Simon on 2/11/2016.
 */
public class DummyClass {

    public static void main(String[] args) {
        // Awesome main
    }

    public static int getRandomNumber() {
        Random rand = new Random();

        return rand.nextInt(1000);
    }
}
