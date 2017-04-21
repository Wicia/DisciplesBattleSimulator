package units;

public class Unit {
	
	private final DefensiveAspect defensive;
	private final OffensiveAspect offensive;
	private final ProgressAspect progress;
	private final MovingAspect moving;
	
	public Unit(DefensiveAspect defensive, OffensiveAspect offensive, 
			ProgressAspect progress, MovingAspect moving) {
		this.defensive = defensive;
		this.offensive = offensive;
		this.progress = progress;
		this.moving = moving;
	}

	public DefensiveAspect getDefensive() {
		return defensive;
	}

	public OffensiveAspect getOffensive() {
		return offensive;
	}

	public ProgressAspect getProgress() {
		return progress;
	}

	public MovingAspect getMoving() {
		return moving;
	}
}
