package main.java.it.unibz.inf.pp.clash.view.exceptions;

import main.java.it.unibz.inf.pp.clash.model.snapshot.units.Unit;

public class UnknownUnitTypeException extends RuntimeException {
    public UnknownUnitTypeException(Class<? extends Unit> unitType) {
        super("Unknown unit type: "+unitType);
    }
}
