package org.example.pt2024_30226_stoica_sergiu_assignment_1.Test;

import org.example.pt2024_30226_stoica_sergiu_assignment_1.Model.Operations;
import org.example.pt2024_30226_stoica_sergiu_assignment_1.Model.Polinom;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PolinomTest {

    @Test
    public void testSuma() throws Exception{
        Polinom p1 = new Polinom(); // 3x^2 + 4x
        p1.addTerm(3, 2); // 3x^2
        p1.addTerm(2, 1); // + 2x
        p1.addTerm(2, 1); // + 2x

        Polinom p2 = new Polinom(); // 5x^2 + 3
        p2.addTerm(5, 2); // 5x^2
        p2.addTerm(3, 0); // + 3

        Polinom suma = Operations.suma(p1, p2);

        assertEquals(8, (int) suma.getTermeni().get(2), "3x^2 + 5x^2 = 8x^2");
        assertEquals(4, (int) suma.getTermeni().get(1), "4x + 0 = 4x");
        assertEquals(3, (int) suma.getTermeni().get(0), "3 + 0 = 3");
    }

    @Test
    public void testDiferenta() throws Exception{
        Polinom p1 = new Polinom();     // 5x^3 + 2x^2 + x
        p1.addTerm(5, 3); // 5x^3
        p1.addTerm(2, 2); // + 2x^2
        p1.addTerm(1, 1); // + x

        Polinom p2 = new Polinom();     // 4x^3 + x + 1
        p2.addTerm(4, 3); // 4x^3
        p2.addTerm(1, 1); // + x
        p2.addTerm(1, 0); // + 1

        Polinom diferenta = Operations.diferenta(p1, p2);

        assertEquals(1, (int) diferenta.getTermeni().get(3), "5x^3 - 4x^3 = x^3");
        assertEquals(2, (int) diferenta.getTermeni().get(2), "2x^2 - 0 = 2x^2");
        assertFalse(diferenta.getTermeni().containsKey(1));
        assertEquals(-1, (int) diferenta.getTermeni().get(0), "0 - 1 = -1");
    }

    @Test
    public void testProdus() throws Exception{
        Polinom p1 = new Polinom();     // 3x^2 - x + 1
        p1.addTerm(3, 2);
        p1.addTerm(-1, 1);
        p1.addTerm(1, 0);

        Polinom p2 = new Polinom();     // x - 2
        p2.addTerm(1, 1);
        p2.addTerm(-2, 0);

        Polinom produs = Operations.produs(p1, p2);

        assertEquals(3, (int) produs.getTermeni().get(3), "3 * X^3");
        assertEquals(-7, (int) produs.getTermeni().get(2), "-7 * X^2");
        assertEquals(3, (int) produs.getTermeni().get(1), "3 X");
        assertEquals(-2, (int) produs.getTermeni().get(0), "-2");
    }

    @Test
    public void testDerivata() throws Exception{
        Polinom p1 = new Polinom();     // x^3 -2 * x^2 + 6 * x - 5
        p1.addTerm(1, 3);
        p1.addTerm(-2, 2);
        p1.addTerm(6, 1);
        p1.addTerm(-5, 0);

        Polinom derivata = Operations.derivat(p1); // 3 * x^2 - 4 * x + 6

        assertEquals(3, (int) derivata.getTermeni().get(2), "3 * x^2");
        assertEquals(-4, (int) derivata.getTermeni().get(1), "-4 * x");
        assertEquals(6, (int) derivata.getTermeni().get(0), "6");

        Assert.assertEquals(3, derivata.getTermeni().size());
    }

    @Test
    public void testIntegrala() throws Exception{
        Polinom p1 = new Polinom();     // x^3 + 4 * x^2 + 5
        p1.addTerm(1, 3);
        p1.addTerm(4, 2);
        p1.addTerm(5, 0);

        Polinom integrala = Operations.integrala(p1); // 1/4 x^4 + 4/3 x^3 + 5x -> 0.25 x^4 + 1.33 x^3 + 5x

        assertEquals(1.0 / 4.0, (double) integrala.getTermeni().get(4), "0.25*x^4");
        assertEquals(4.0 / 3.0, (double) integrala.getTermeni().get(3), "1.33*x^3");
        assertEquals(5.0, (double) integrala.getTermeni().get(1), "5x");

        Assert.assertEquals(3, integrala.getTermeni().size());
    }

}
