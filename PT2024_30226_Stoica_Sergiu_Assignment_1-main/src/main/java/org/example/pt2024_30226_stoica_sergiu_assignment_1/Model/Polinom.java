package org.example.pt2024_30226_stoica_sergiu_assignment_1.Model;

import java.text.DecimalFormat;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.BiConsumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polinom {

    private final TreeMap<Number, Number> termeni;

    public Polinom() {
        termeni = new TreeMap<>((a, b) -> b.intValue() - a.intValue()); // ordine descrescatoare
    }

    /** ADAUGA TERMENI **/
    public void addTerm(Number coeficient, Number grad) {
        termeni.merge(grad, coeficient, (existingCoef, newCoef) -> {
            int updatedCoef = existingCoef.intValue() + newCoef.intValue();
            return updatedCoef != 0 ? updatedCoef : null; // returneaza null pentru coeficientul 0
        });
    }

    /**  VERIFICAM SA FIE INPUTUL CORECT **/
    public boolean isValidPolynomial(String polynomial) {

        if (!polynomial.matches("[0-9xX^+\\-\\s]*")) {
            return false; // contine alte caractere
        }

        if (polynomial.contains("++") || polynomial.contains("--") || polynomial.contains("**") || polynomial.contains("//")) {
            return false;
        }

        return true; // input corect
    }

    /** PARSEAZA TERMENII DIN STRING **/
    public void parseAndAddTerms(String polynomial) {
        String sanitizedPolynomial = polynomial.replaceAll("\\s+", ""); // Scapam de spatii
        sanitizedPolynomial = sanitizedPolynomial.replaceAll("X", "x");

        Pattern pattern = Pattern.compile("([-+]?\\d*x\\^\\d+)|([-+]?\\d*x)|([-+]?\\d+)"); // Verificam sa fie scris : coeficient x ^ putere, coeficient x sau doar coeficient
        Matcher matcher = pattern.matcher(sanitizedPolynomial);

        if (!isValidPolynomial(polynomial)) {
            throw new IllegalArgumentException("Input invalid."); // daca nu e corect, trimitem o exceptie
        }
        while (matcher.find()) {
            for (int i = 1; i <= matcher.groupCount(); i++) {
                String matchedPart = matcher.group(i);
                if (matchedPart == null) continue;
                if (matchedPart.contains("x")) {
                    matchedPart = matchedPart.trim();
                    if (matchedPart.equals("x")) {
                        addTerm(1, 1);
                    } else if (matchedPart.equals("-x")) {
                        addTerm(-1, 1);
                    } else {
                        String[] parts = matchedPart.split("x\\^?");
                        int coef = parts[0].isEmpty() || parts[0].equals("+") ? 1 : parts[0].equals("-") ? -1 : Integer.parseInt(parts[0]);
                        int grad = parts.length > 1 ? Integer.parseInt(parts[1]) : 1;
                        addTerm(coef, grad);
                    }
                } else {
                    int constant = Integer.parseInt(matchedPart); // daca nu contine x
                    addTerm(constant, 0);
                }
                break;}}}

    /** FUNCTIE PENTRU FOR EACH **/
    public void forEach(BiConsumer<Number, Number> action) {
        termeni.forEach(action);
    }

    /** GET COEFICIENT**/
    public TreeMap<Number, Number> getTermeni() {
        return this.termeni;
    }

    /** AFISARE POLINOM **/
    @Override
    public String toString() {

        // Daca nu avem termeni, returnam 0
        if (termeni.isEmpty()) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Number, Number> entry : termeni.entrySet()) {
            int coef = entry.getValue().intValue();
            int degree = entry.getKey().intValue();

            // daca coeficientul e mai mare decat zero si nu suntem la inceput, adaugam + deoarece numarul e pozitiv, daca coeficientul e mai mic decat 0 adaugam -
            if (coef > 0 && !sb.isEmpty()) sb.append("+");
            else if (coef < 0) sb.append("-");

            // daca coeficientul nu e 1, este adaugat la string
            if (Math.abs(coef) != 1 || degree == 0) {
                sb.append(Math.abs(coef));
            }

            // daca gradul este mai mare decat 0 adaugam x, daca este mai mare decat 1 adaugam si puterea
            if (degree > 0) {
                sb.append("x");
                if (degree > 1) {
                    sb.append("^").append(degree);
                }
            }
        }
        return sb.toString();
    }

    // La fel ca mai sus, dar imbunatatit pentru impartire
    public String toStringImpartiri() {

        // Daca nu avem termeni, returnam 0
        if (termeni.isEmpty()) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<Number, Number> entry : termeni.entrySet()) {
            double coef = entry.getValue().doubleValue();
            int degree = entry.getKey().intValue();

            // daca coeficientul e mai mare decat zero si nu suntem la inceput, adaugam + deoarece numarul e pozitiv, daca coeficientul e mai mic decat 0 adaugam -
            if (coef > 0 && !sb.isEmpty()) sb.append("+");
            else if (coef < 0) sb.append("-");

            if (Math.abs(coef) != 1 || degree == 0) { // daca coeficientul nu e 1, este adaugat la string
                coef = Math.abs(coef);
                String coefStr = formatDecimal(coef);
                sb.append(coefStr);
            }

            if (degree > 0) { // daca gradul este mai mare decat 0 adaugam x, daca este mai mare decat 1 adaugam si puterea
                sb.append("x");
                if (degree > 1) {
                    sb.append("^").append(degree);
                }
            }
        }
        return sb.toString();
    }

    // Pentru a afisa doar 2 cifre dupa virgula
    private String formatDecimal(double number) {
        DecimalFormat df = new DecimalFormat("0.##");
        return df.format(number);
    }
}
