public class Player{
        private String name;
        private int level;
        private int hitPoints;
        private int armorClass;
        private int intelligence;
        private int strength;
        private int dexterity;
        private int constitution;
        private int wisdom;
        private int charisma;
        private Dice dice;
        private int maxHitPoints;
    // Constructor
    public Player(String name, int level, int hitPoints, int armorClass, int intelligence, int strength,  int dexterity, int constitution, int wisdom, int charisma, int maxHitPoints){
        this.name = name;
        this.level = level;
        this.hitPoints = hitPoints;
        this.armorClass = armorClass;
        this.intelligence = intelligence;
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.wisdom = wisdom;
        this.charisma = charisma;
        this.dice = new Dice();
        this.maxHitPoints = maxHitPoints;
    }

    // getters
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

    public int getIntelligence(){
        return intelligence;
    }

    public int getStrength(){
        return strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getConstitution(){
        return constitution;
    }

    public int getCharisma() {
        return charisma;
    }

    public int getWisdom() {
        return wisdom;
    }

    public int getMaxHitPoints() {
        return maxHitPoints;
    }

    //setters
    public void setName(String name){
        this.name = name;
    }

    public void setLevel(int level){
        this.level = level;
    }

    public void setHitPoints(int hitPoints){
        this.hitPoints = hitPoints;
    }

    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public void setMaxHitPoints(int maxHitPoints) {
        this.maxHitPoints = maxHitPoints;
    }

    public String toString() {
        return "Player{" + "name: " + name +
                ", level: " + level +
                ", hitPoints: " + hitPoints +
                ", armorClass: " + armorClass +
                ", strength: " + strength +
                ", dexterity: " + dexterity +
                ", constitution: " + constitution +
                ", intelligence: " + intelligence +
                ", wisdom: " + wisdom +
                ", charisma: " + charisma + "}";
    }

    public void takeDamage(int damage){
        this.hitPoints -= damage;
    }

    public void levelUp(){
        this.level ++;
    }

    public void defend(){}

    public void attack(){}

    public void heal(int amount){
        hitPoints += amount;
        if(hitPoints > maxHitPoints)
            hitPoints = maxHitPoints;
        System.out.println(name  + " heals for " + amount + " hit points!!");
    }


}