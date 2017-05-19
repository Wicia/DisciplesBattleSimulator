package units.api.attributes;

public interface AttributeValue<V> {
    V get();
    V copy();
    V getMinValue();
    V getMaxValue();
}