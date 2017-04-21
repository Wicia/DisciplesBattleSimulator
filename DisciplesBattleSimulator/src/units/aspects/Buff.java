/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package units.aspects;

import units.enums.AttributeName;

public class Buff {
    
    private BuffType type;
    private AttributeName attributeName;
    private ChangeType changeType;
    private int value;
    private  int turnsDuration;

    public Buff(){}
    
    public static Buff createWardBuff(AttributeName attributeName){
        Buff buff = new Buff();
        buff.type = BuffType.POSITIVE;
        buff.attributeName = attributeName;
        buff.turnsDuration = 999;
        buff.changeType = ChangeType.WARD;
        return buff;
    }

    public AttributeName getAttributeName() {
        return attributeName;
    }

    public ChangeType getChangeType() {
        return changeType;
    }

    public long getValue() {
        return value;
    }

    public int getTurnsDuration() {
        return turnsDuration;
    }

    public BuffType getType() {
        return type;
    }
}
