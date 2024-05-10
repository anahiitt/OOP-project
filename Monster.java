public class Monster {
    private boolean isAlive;
    protected Position position;
    private String name;
    private int hitPoints;
    private int attackDamage;
    private int armorClass;

    public Monster(String name, int hitPoints, int attackDamage, int armorClass, boolean isAlive, int x, int y) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.attackDamage = attackDamage;
        this.armorClass = armorClass;
        this.isAlive = isAlive;
        this.position = new Position(x, y);
    }
    public Monster(Monster that) {
        this.name = that.name;
        this.hitPoints = that.hitPoints;
        this.attackDamage = that.attackDamage;
        this.armorClass = that.armorClass;
        this.isAlive = that.isAlive;
    }

    public String getName() {
        return name;
    }
    public Position getPosition() {
        return new Position();
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }
    public void setPosition(int x, int y) {
        position.setX(x);
        position.setY(y);
    }
    public void setHitPoints(int hitPoints){
        this.hitPoints = hitPoints;
    }
    public int getArmorClass() {
        return armorClass;
    }

    public boolean isAlive() {
        return (hitPoints > 0);
    }

    public void currentStatistics() {
        System.out.println("Name: " + this.name);
        System.out.println("Hit Points: " + this.hitPoints);
        System.out.println("Attack Damage: " + this.attackDamage);
        System.out.println("Armor Class: " + this.armorClass);
    }

    public void attack(Player player) {
        int initialHitPoints = player.getHitPoints();
        player.setHitPoints(player.getHitPoints() - this.getAttackDamage());
        if(player.getHitPoints() == initialHitPoints){
            System.out.println("The attack was missed");
        }
    }

    public void takeDamage(int attackDamage) {
        if ((hitPoints - attackDamage) < 1) {
            System.out.println(name + " is dead.");
            isAlive = false;
        }
    }

}

