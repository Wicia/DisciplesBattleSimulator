package units;

public class DescriptionAscpect extends UnitAscpect{
	
	private int unitId;
	private String name;
	private String description;
	
	private final Unit ref = null;
	
	public DescriptionAscpect(Unit ref){
		super(ref);
	}
}
