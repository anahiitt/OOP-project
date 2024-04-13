public class Beholder extends Monster{
    private int speed;
    private int climbSpeed;
    private int challengeRating;

    public Beholder(String name, int hitPoints, int attackDamage, int armorClass, boolean isAlive,
                    int speed, int climbSpeed, int challengeRating) {
        super(name, hitPoints, attackDamage, armorClass, isAlive);
        this.speed = speed;
        this.climbSpeed = climbSpeed;
        this.challengeRating = challengeRating;
    }
    public Beholder(){
        super("Beholder", 168, 17, 17, true);
        speed = 50;
        climbSpeed = 40;
        challengeRating = 13;
    }
    public int getSpeed() {
        return speed;
    }
    public int getClimbSpeed() {
        return climbSpeed;
    }
    public int getChallengeRating() {
        return challengeRating;
    }

}
