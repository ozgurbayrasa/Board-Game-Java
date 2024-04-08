package dummy;

import main.java.it.unibz.inf.pp.clash.model.snapshot.units.impl.Butterfly;
import main.java.it.unibz.inf.pp.clash.model.snapshot.units.impl.Unicorn;
import org.junit.jupiter.api.Test;

import static main.java.it.unibz.inf.pp.clash.model.snapshot.units.MobileUnit.UnitColor;
import static org.junit.jupiter.api.Assertions.*;

public class DummyTests {

    @Test
    public void testUnitStats() {

        Unicorn unicorn = new Unicorn(UnitColor.ONE);

        assertTrue(unicorn.getAttackCountdown() < 0);

        assertFalse(unicorn.getHealth() < 0);
    }

    @Test
    public void testDifferentObjects() {

        Butterfly butterfly = new Butterfly(UnitColor.ONE);
        Butterfly similarButterfly = new Butterfly(UnitColor.ONE);

        assertEquals(butterfly.getColor(), similarButterfly.getColor());

        assertNotEquals(butterfly, similarButterfly);
    }
}