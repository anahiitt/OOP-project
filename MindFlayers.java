public class MindFlayers extends Monster {
	private int tentacleDamage;
	
	public MindFlayers(String name, int hitPoints, int attackDamage, int armorClass, boolean isAlive,  int tentacleDamage1,  int dominationChance, int stunChance, int tentacleDamage, int stunDuration, int x, int y) {
		super(name, hitPoints, attackDamage, armorClass, isAlive, x, y);
		this.tentacleDamage = tentacleDamage;
	}
	public MindFlayers(int x, int y){
		super("MindFlayer", 11, 6, 15, true, x, y);
		this.tentacleDamage = 7;
	}
	public String toString(){
		return "M";
	}

	public void tentacleAttack(Player target) {
		System.out.println(target.getName() + " took " + tentacleDamage + " tentacle damage from you.");
		attack(target);
	}
	
	@Override 
	public void currentStatistics() {
		super.currentStatistics();
		System.out.println("Tentacle Damage: " + tentacleDamage);
	}

}
