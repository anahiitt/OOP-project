public class Demon extends Monster{
    private int darkMagicDamage;

    public Demon(String name, int hitPoints, int attackDamage, int armorClass ,int darkMagicDamage, boolean isAlive, int x, int y){
        super(name, hitPoints, attackDamage, armorClass, isAlive, x, y);
        this.darkMagicDamage = darkMagicDamage;
    }
    public Demon(int x, int y){
        super("Demon", 10, 5, 18, true, x, y);
        darkMagicDamage = 6;
    }

    public String toString(){
        return "N";
    }
    public int getDarkMagicDamage() {
        return darkMagicDamage;
    }

    public void setDarkMagicDamage(int darkMagicDamage) {
        this.darkMagicDamage = darkMagicDamage;
    }

    public void attackWithDarkMagic(Player target){
        System.out.println(this.getName() + " casts dark magic, dealing " + darkMagicDamage + " damage!!");
        attack(target);
    }
}
