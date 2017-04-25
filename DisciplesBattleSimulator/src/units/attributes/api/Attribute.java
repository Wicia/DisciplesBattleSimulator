package units.attributes.api;

public interface Attribute<V> {

    void setValue(AttributeValue value);

    AttributeName getName();

    <V> V getSimpleValue();
}
