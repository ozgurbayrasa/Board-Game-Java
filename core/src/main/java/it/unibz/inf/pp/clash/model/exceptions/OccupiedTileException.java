package main.java.it.unibz.inf.pp.clash.model.exceptions;

import main.java.it.unibz.inf.pp.clash.model.snapshot.units.Unit;

public class OccupiedTileException extends RuntimeException {
    public OccupiedTileException(Unit unit) {
        super("There is already a unit on this tile:\n"+unit);
    }
}
