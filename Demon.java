public class Demon extends Monster{
    private int darkMagicDamage;

    public Demon(String name, int hitPoints, int armorClass ,int darkMagicDamage){
        super(name, hitPoints, armorClass);
        this.darkMagicDamage = darkMagicDamage;
    }

    public int getDarkMagicDamage() {
        return darkMagicDamage;
    }

    public void setDarkMagicDamage(int darkMagicDamage) {
        this.darkMagicDamage = darkMagicDamage;
    }

    public void arrack(){
        System.out.println(name + " casts dark magic, dealing " + darkMagicDamage + " damage!!");
    }
}