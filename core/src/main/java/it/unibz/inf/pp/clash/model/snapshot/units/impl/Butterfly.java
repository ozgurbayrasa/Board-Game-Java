package main.java.it.unibz.inf.pp.clash.model.snapshot.units.impl;

import main.java.it.unibz.inf.pp.clash.model.snapshot.units.MobileUnit;
import main.java.it.unibz.inf.pp.clash.model.snapshot.units.Unit;

public class Butterfly extends AbstractMobileUnit implements Unit {

    public Butterfly(MobileUnit.UnitColor color) {
        super(5, color);
    }

}
