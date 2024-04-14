import java.util.Random;

public class MindFlayers extends Monster {
	private int tentacleDamage;
	private int dominationChance;
	private int stunChance;
	private int stunDuration;
	
	public MindFlayers(String name, int hitPoints, int attackDamage, int armorClass, boolean isAlive,  int tentacleDamage1,  int dominationChance, int stunChance, int tentacleDamage, int stunDuration) {
		super(name, hitPoints, attackDamage, armorClass, isAlive);
		this.dominationChance = dominationChance;
		this.stunChance = stunChance;
		this.tentacleDamage = tentacleDamage;
		this.stunDuration = stunDuration;
	}
	
	public int getTentacleDamage() {
		return tentacleDamage;
	}
	
	public void setTentacleDamage(int tentacleDamage) {
		this.tentacleDamage = tentacleDamage;
	}
	
	public int getStunChance() {
		return stunChance;
	}
	public void setStunChance(int stunChance) {
		this.stunChance = stunChance;
	}
	
	public int getDominationChance() {
		return dominationChance;
	}
	public void setDominationChance(int dominationChance) {
		this.dominationChance = dominationChance;
	}
	
	public int getStunDuration() {
		return stunDuration;
	}
	
	public void setStunDuration(int stunDuration) {
		this.stunDuration = stunDuration;
	}
	
	public void tentackleAttack(Monster target){
		
		int originalHitPoints = target.getHitPoints();
		
		target.takeDamage(tentacleDamage);
		
		if (target.getHitPoints() == originalHitPoints) {
			System.out.println("The tentacle attack was missed");
		} else {
			System.out.println(target.getName() + " took " + tentacleDamage + " tentacle damage from " + this.getName());
			if (target.isAlive()) {
				attemptStun(target);
			}
		}
	}
	
	private void attemptStun(Monster target) {
		int randomNumber = (int) (Math.random() * 100);
		if (randomNumber < stunChance) {
			stun(target);
		}
	}
	
	private void stun(Monster target) {
		
		System.out.println(target.getName() + " has been stunned " + stunDuration + " turns!");
		int originalAttackDamage = target.getAttackDamage();
		int reducedAttackDamage = originalAttackDamage - 5;
		
		target.setAttackDamage(reducedAttackDamage);
		
		target.setAttackDamage(originalAttackDamage);
		
	}
	
	public void dominateMonster(Monster target) {
		int randomNumber = (int) (Math.random() * 100 );
		if (randomNumber < dominationChance) {
			System.out.println(target.getName() + " has been dominated by the mind flayer!");
		} else {
			System.out.println("Dominate monster attempt failed.");
		}
	}
	
	@Override 
	public void currentStatistics() {
		super.currentStatistics();
		System.out.println("Tentacle Damage: " + tentacleDamage);
		System.out.println("Stun Chance: " + stunChance + "%");
		System.out.println("Domination Chance: " + dominationChance + "%");
	}

}
