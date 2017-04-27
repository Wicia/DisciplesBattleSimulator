package units.attributes.api;

public interface AttributeValue<V> {
    V get();
    V copy();
}