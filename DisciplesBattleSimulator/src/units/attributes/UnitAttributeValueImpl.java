package units.attributes;

public class UnitAttributeValueImpl<V> implements UnitAttributeValue<V>{

    private final V value;

    public UnitAttributeValueImpl(V value) {
        super();
        this.value = value;
    }

    public V getValue() {
        return value;
    }
}