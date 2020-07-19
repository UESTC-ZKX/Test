package swordOffer;

import org.junit.Test;

import static org.junit.Assert.*;

public class SwordOffer_21Test {

    private SwordOffer_21 swordOffer_21 = new SwordOffer_21();

    @Test
    public void min() {
        for (int i = 0; i < 100; i++) {
            swordOffer_21.push(i);
        }
        assertEquals(0, swordOffer_21.min());
    }
}