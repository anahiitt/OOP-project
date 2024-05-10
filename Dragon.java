public class Dragon extends Monster{
    private int fireDamage;

    public Dragon(String name, int hitPoints, int attackDamage, int armorClass, int fireDamage, boolean isALive, int x, int y){
        super(name, hitPoints, attackDamage, armorClass, isALive, x, y);
        this.fireDamage = fireDamage;
    }
    public Dragon(int x, int y){
        super("Dragon", 15, 7, 19, true, x, y);
        this.fireDamage = 8;
    }
    public String toString(){
        return "D";
    }
    public int getFireDamage(){
        return fireDamage;
    }

    public void setFireDamage(int fireDamage){
        this.fireDamage = fireDamage;
    }

    public void attackWithFire(Player target){
        System.out.println(this.getName() + " breathes fire, hitting " + fireDamage + " damage");
        attack(target);
    }

}
