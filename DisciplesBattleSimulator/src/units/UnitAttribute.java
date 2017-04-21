package units;

public class UnitAttribute<AttributeValue> {
	
	private UnitAttributeName name;
	private AttributeValue value;

	public UnitAttribute(UnitAttributeName name, AttributeValue value) {
		super();
		this.name = name;
		this.value = value;
	}
	
	public UnitAttributeName getName() {
		return name;
	}
	public AttributeValue getValue() {
		return value;
	} 
}