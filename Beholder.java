public class Beholder extends Monster{
    private int climbSpeed;

    public Beholder(String name, int hitPoints, int attackDamage, int armorClass, boolean isAlive,
                    int speed, int climbSpeed, int challengeRating, int x, int y) {
        super(name, hitPoints, attackDamage, armorClass, isAlive, x, y);
        this.climbSpeed = climbSpeed;
    }
    public Beholder(int x, int y){
        super("Beholder", 8, 3, 17, true, x, y);
        climbSpeed = 40;
        setPosition(0, 3);
    }
    public String toString(){
        return "B";
    }
    public int getClimbSpeed() {
        return climbSpeed;
    }

}
