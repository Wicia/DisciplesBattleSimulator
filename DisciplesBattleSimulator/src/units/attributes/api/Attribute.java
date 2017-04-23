package units.attributes.api;

public interface Attribute<V> {

    void setValue(AttributeValue value);

    String getId();

    <V> V getSimpleValue();
}
