public class Dragon extends Monster{
    private int fireDamage;

    public Dragon(String name, int hitPoints, int armorClass, int fireDamage){
        super(name, hitPoints, armorClass);
        this.fireDamage = fireDamage;
    }

    public int getFireDamage(){
        return fireDamage;
    }

    public void setFireDamage(int fireDamage){
        this.fireDamage = fireDamage;
    }

    public void attack(){
        System.out.println(name + " breathes fire, dealing " + fireDamage + " damage");
    }

}