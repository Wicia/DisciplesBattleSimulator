package units.attributes.api;

public interface AttributeValue<V> {
    V value();
    V getCopy();
}