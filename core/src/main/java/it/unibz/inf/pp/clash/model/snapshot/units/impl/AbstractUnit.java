package main.java.it.unibz.inf.pp.clash.model.snapshot.units.impl;

import main.java.it.unibz.inf.pp.clash.model.snapshot.units.Unit;

public abstract class AbstractUnit implements Unit {

    int health;

    protected AbstractUnit(int health) {
        this.health = health;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public void setHealth(int health) {
        this.health = health;
    }

}
