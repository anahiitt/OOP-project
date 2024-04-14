public class Giants extends Monster {
	private double size;
	

	public Giants(String name, int hitPoints, int attackDamage, int armorClass, boolean isAlive, double size) {
		super(name, hitPoints, attackDamage, armorClass, isAlive);
		this.size = size;
	}
	
	public double getSize() {
		return size;
	}
	
	public void setSize(double size) {
		this.size = size;
	}
	
	public void throwRock(Object target) {
		System.out.println(this.getName() + " throws a rock at the target!");
		attack(target);
	}
}

public class HillGiant extends Giants{
	public HillGiant(String name, int hitPoints, int attackDamage, int armorClass, double size) {
		super(name, hitPoints, attackDamage, armorClass, true, size);
	}
	
	@Override
	public void attack(Object target) {
		throwRock(target);
		super.attack(target);
	}
}

public class StoneGiant extends Giants{
	public StoneGiant(String name, int hitPoints, int attackDamage, int armorClass, double size) {
		super(name, hitPoints, attackDamage, armorClass, true, size);
	}
	
	@Override
	public void attack(Object target) {
		throwRock(target);
		super.attack(target);
	}
}

public class FrostGiant extends Giants{
	public FrostGiant(String name, int hitPoints, int attackDamage, int armorClass, double size) {
		super(name, hitPoints, attackDamage, armorClass, true, size);
	}
	
	@Override
	public void attack(Object target) {
		throwRock(target);
		super.attack(target);
	}
}
