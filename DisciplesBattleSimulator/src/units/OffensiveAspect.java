package units;

import enums.AttackSource;

public class OffensiveAspect extends UnitAscpect{
	
	private AttackSource source;
	private String attackName;
	private int chanceToHit;
	private int damage;
	private int initiative;
	private int range;
	private int targets;
	
	private final Unit ref = null;
	
	public OffensiveAspect(Unit ref){
		super(ref);
	}
}
