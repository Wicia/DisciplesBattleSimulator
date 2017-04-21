package units;

public class ProgressAspect extends UnitAscpect{
	
	private int level;
	private int currentExpPoints;
	private int nextLevelExpPoints;
	
	private final Unit ref = null;
	
	public ProgressAspect(Unit ref){
		super(ref);
	}
}
