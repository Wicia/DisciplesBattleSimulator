package units;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import enums.AttackAction;
import enums.ProtectionType;

public class DefensiveAspect extends UnitAscpect{
	
	public static final int DEFAULT_PROTECTION_LEVEL = 0;
	public static final int MAX_PROTECTION_LEVEL = 100;
	
	private final Unit ref = null;
	
	// Attribute name > Attribute value
	private Map<String, UnitAttribute> protectionTypeToValue;
	
	public DefensiveAspect(Unit ref){
		super(ref);
		initDefaultProtection();
	}
	
	private void initDefaultProtection(){
		protectionTypeToValue = new HashMap<>();
		//Arrays.asList(ProtectionType.values()).stream().forEach(
				//(ProtectionType type) -> protectionTypeToValue.put(type, DEFAULT_PROTECTION_LEVEL));
	}
	
	public int getReducedDamage(AttackAction attackAction){
		ProtectionType protectionType = ProtectionType.getByAttackSource(attackAction.getSource());
		int level = getProtectionLevel(protectionType);
		if(level == DEFAULT_PROTECTION_LEVEL){
			return attackAction.getDamage();
		}
		if(level == MAX_PROTECTION_LEVEL){
			return 0;
		}
		else{
			return (int) (attackAction.getDamage() * getProtectionLevelAsPecent(protectionType));
		}
	}
	
	private double getProtectionLevelAsPecent(ProtectionType type){
		if(ProtectionType.ARMOR.equals(type)){
			UnitAttribute attribute = protectionTypeToValue.get(
					UnitAttributeName.WEAPON_RESISTANCE.toString());
			Object value = attribute.getValue();
		}
		else{
			UnitAttribute attribute = protectionTypeToValue.get(
					UnitAttributeName.MAGIC_RESISTANCE.toString());
			Object value = attribute.getValue();
		}
		// return protectionTypeToValue.get(type) / 100;
		return -1L;
	}
	
	public int getProtectionLevel(ProtectionType type){
		// return protectionTypeToValue.get(type);
		return -1;
	}
}