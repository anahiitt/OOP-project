public class Monster {
    private boolean isAlive;
    private String name; //name of the monster
    private int hitPoints; //health of the monster
    private int attackDamage; //the amount of damage the monster deals in combat
    private int armorClass; //difficulty level of hitting the monster.

    public Monster(String name, int hitPoints, int attackDamage, int armorClass, boolean isAlive) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.attackDamage = attackDamage;
        this.armorClass = armorClass;
        this.isAlive = isAlive;
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

    public int getHitPoints() {
        return hitPoints;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
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

    public void attack(Object target) {
        try {
            if (!(target instanceof Player || target instanceof Monster)) {
                throw new NoSuchTargetException();
            }
        } catch (NoSuchTargetException e) {
            System.out.println("Can not attack such a target");
        }
        if(target instanceof Monster){
            Monster newTarget = (Monster) target;
        }
        else{
            Player newTarget = (Player) target;
        }
        int initialHitPoints = newTarget.getHitPoits;
        newTarget.setHitPoints(newTarget.getHitPoints() - this.getAttackDamage());
        if(newTarget.getHitPoints == initialHitPoints){
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
