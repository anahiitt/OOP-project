import java.util.Random;

public class Dice{
    private Random random;

    public Dice(){
        random = new Random();
    }

    public int rollD6(){
        return random.nextInt(6) + 1;
    }

    public int rollD20(){
        return random.nextInt(20) + 1;
    }
}
