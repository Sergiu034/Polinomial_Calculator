package org.example.pt2024_30226_stoica_sergiu_assignment_1.Model;

import java.util.Map;
public class Operations {

    /** SUMA **/
    public static Polinom suma(Polinom polinom1, Polinom polinom2) {

        Polinom rezultat = new Polinom();

        polinom1.forEach((grad, coeficient) -> rezultat.addTerm(coeficient.intValue(), grad.intValue())); // ADAUGA TETRMENII DIN POLINOMUL CURENT IN POLINOMUL REZULTAT
        polinom2.forEach((grad, coeficient) -> rezultat.addTerm(coeficient.intValue(), grad.intValue())); // ADAUGA TERMENII DIN POLINOMUL 2 IN POLINOMUL REZULTAT

        return rezultat;
    }

    /** DIFERENTA **/
    public static Polinom diferenta(Polinom polinom1, Polinom polinom2) {

        Polinom rezultat = new Polinom();

        polinom1.forEach((grad, coeficient) -> rezultat.addTerm(coeficient.intValue(), grad.intValue())); //  ADAUGA TERMENII DIN POLINOMUL CURENT IN POLINOMUL REZULTAT
        polinom2.forEach((grad, coeficient) -> rezultat.addTerm(-coeficient.intValue(), grad.intValue())); // ADAUGA TERMENII DIN POLINOMUL 2 IN POLINOMUL REZULTAT CU - (PENTRU SCADERE)

        return rezultat;
    }

    public static Polinom produs(Polinom polinom1, Polinom polinom2) {

        Polinom result = new Polinom();

        for (Map.Entry<Number, Number> thisTerm : polinom1.getTermeni().entrySet()) {

            for (Map.Entry<Number, Number> otherTerm : polinom2.getTermeni().entrySet()) {

                Number newCoeff = thisTerm.getValue().intValue() * otherTerm.getValue().intValue();
                Number newGrade = thisTerm.getKey().intValue() + otherTerm.getKey().intValue();

                result.addTerm(newCoeff, newGrade);
            }
        }

        return result;
    }

    public static Polinom derivat(Polinom polinom1) {

        Polinom result = new Polinom();

        for (Map.Entry<Number, Number> term : polinom1.getTermeni().entrySet()) {
            Number grad = term.getKey();
            Number coef = term.getValue();

            if (grad.intValue() == 0) {
                continue;
            }

            Number newCoef = coef.intValue() * grad.intValue();
            Number newGrade = grad.intValue() - 1;

            result.addTerm(newCoef, newGrade);
        }

        return result;
    }public static Polinom integrala(Polinom polinom1) {

        Polinom result = new Polinom();

        for (Map.Entry<Number, Number> term : polinom1.getTermeni().entrySet()) {
            Number grad = term.getKey();
            Number coef = term.getValue();

            Number newGrade = grad.intValue() + 1;
            Number newCoef = coef.doubleValue() / newGrade.doubleValue();

            result.addTerm(newCoef, newGrade);
        }

        return result;
    }
}
