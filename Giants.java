public class Giants extends Monster {
	private double size;
	public Giants(String name, int hitPoints, int attackDamage, int armorClass, boolean isAlive, double size, int x, int y) {
		super(name, hitPoints, attackDamage, armorClass, isAlive, x, y);
		this.size = size;
	}
	public Giants(int x, int y){
		super("Giant", 9, 4, 13, true, x, y);
		this.size = 3.0;
	}
	
	public double getSize() {
		return size;
	}
	
	public void setSize(double size) {
		this.size = size;
	}
	
	public void throwRock(Player target) {
		System.out.println(this.getName() + " throws a rock at the target!");
		attack(target);
	}
	public String toString(){
		return "G";
	}
}
