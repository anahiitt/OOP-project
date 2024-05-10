public class Player extends DnD{
    private Position position;
    private String name;
    private int level;
    private int hitPoints;
    private int armorClass;
    private int wisdom;
    private int strength;

    public Player(String name, int level, int hitPoints, int armorClass, int intelligence, int strength,  int dexterity, int constitution, int wisdom, int charisma, int maxHitPoints){
        this.name = name;
        this.level = level;
        this.hitPoints = hitPoints;
        this.armorClass = armorClass;
        this.strength = strength;
        this.wisdom = wisdom;
    }
    public Player(){
        position = new Position(3, 3);
        name = null;
        level = 1;
        hitPoints = 10;
        armorClass = 5;
        strength = 10;
        wisdom = 10;
    }
    public Player(Player player){
        position = new Position(player.getPosition().getX(), player.getPosition().getY());
        this.name = player.getName();
        this.level = player.getLevel();
        hitPoints = player.getHitPoints();
        armorClass = player.getArmorClass();
        strength = player.getLevel();
        wisdom = player.getWisdom();
    }
    public Player(int x, int y){
        position = new Position(x, y);
        name = null;
        level = 1;
        hitPoints = 10;
        armorClass = 5;
        strength = 10;
        wisdom = 10;
    }
    public void setPosition(int x, int y){
        this.position = new Position(x, y);
    }
    public void setPosition(Position position){
        this.position = new Position(position);
    }

    public Position getPosition(){
        return new Position();
    }
    public String getName(){
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getHitPoints(){
        return hitPoints;
    }

    public int getArmorClass(){
        return armorClass;
    }

    public int getStrength(){
        return strength;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setName(String name){
        if (name == null){
            System.out.println("That is not a name");
            System.exit(0);
        }
        this.name = name;
    }

    public void setLevel(int level){
        this.level = level;
    }

    public void setHitPoints(int hitPoints){
        if (hitPoints < 6 || hitPoints > 12){
            System.out.println("As you showed that you are not very noble, thus, you will be executed.");
            System.out.println("You lost.");
            System.exit(0);
        }
        this.hitPoints = hitPoints;
    }

    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }


    public void setStrength(int strength) {
        if (hitPoints < 10 || hitPoints > 12){
            System.out.println("As you showed that you are not very noble, thus, you will be executed.");
            System.out.println("You lost.");
            System.exit(0);
        }
        this.strength = strength;
    }

    public void setWisdom(int wisdom) {
        if (hitPoints < 10 || hitPoints > 12){
            System.out.println("As you showed that you are not very noble, thus, you will be executed.");
            System.out.println("You lost.");
            System.exit(0);
        }
        this.wisdom = wisdom;
    }
    public void attack(Monster monster) {
        int initialHitPoints = monster.getHitPoints();
        monster.setHitPoints(monster.getHitPoints() - this.armorClass);
        if(monster.getHitPoints() == initialHitPoints){
            System.out.println("The attack was missed");
        }
    }


    public String toString() {
        return "Player\n" + "name: " + name +
                ", level: " + level +
                ", hitPoints: " + hitPoints +
                ", armorClass: " + armorClass +
                ", strength: " + strength +
                ", wisdom: " + wisdom;
    }
    public void levelUp(){
        this.level ++;
    }
    public void takeDamage(int attackDamage) {
        if ((hitPoints - attackDamage) < 1) {
            System.out.println("You died.");
            isAlive();
        }
    }

    public boolean isAlive() {
        return hitPoints > 0;
    }

    public void heal(int amount){
        hitPoints += amount;
        System.out.println(name  + " heals for " + amount + " hit points!!");
    }
}
