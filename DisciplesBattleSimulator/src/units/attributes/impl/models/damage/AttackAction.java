package units.attributes.impl.models.damage;

import units.attributes.impl.models.damage.AttackSource;

public class AttackAction {

    private final int damage;
    private final AttackSource source;

    public AttackAction(int damage, AttackSource source) {
        this.damage = damage;
        this.source = source;
    }

    public int getDamage() {
        return damage;
    }

    public AttackSource getSource() {
        return source;
    }
}
