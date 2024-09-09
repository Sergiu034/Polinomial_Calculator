package org.example.pt2024_30226_stoica_sergiu_assignment_1.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.example.pt2024_30226_stoica_sergiu_assignment_1.Model.Operations;
import org.example.pt2024_30226_stoica_sergiu_assignment_1.Model.Polinom;

public class Calc_Controller {

    @FXML
    private TextField p1_text;
    @FXML
    private TextField p2_text;
    @FXML
    private Button suma;
    @FXML
    private Button produs;
    @FXML
    private Text rezultat_text;

    @FXML
    private void sumaPolinoame() {

        try {
            String optiune_1 = p1_text.getText();
            String optiune_2 = p2_text.getText();

            Polinom polinom_1 = new Polinom();
            polinom_1.parseAndAddTerms(optiune_1);

            Polinom polinom_2 = new Polinom();
            polinom_2.parseAndAddTerms(optiune_2);

            Polinom rezultat = new Polinom();
            rezultat = Operations.suma(polinom_1, polinom_2);

            rezultat_text.setText(rezultat.toString());
        } catch (IllegalArgumentException e){

            rezultat_text.setText(e.getMessage());
        }
    }

    @FXML
    private void diferentaPolinoame() {

        try {
            String optiune_1 = p1_text.getText();
            String optiune_2 = p2_text.getText();

            Polinom polinom_1 = new Polinom();
            polinom_1.parseAndAddTerms(optiune_1);

            Polinom polinom_2 = new Polinom();
            polinom_2.parseAndAddTerms(optiune_2);

            Polinom rezultat = new Polinom();
            rezultat = Operations.diferenta(polinom_1, polinom_2);

            rezultat_text.setText(rezultat.toString());
        } catch (IllegalArgumentException e){

            rezultat_text.setText(e.getMessage());
        }
    }

    @FXML
    private void produsPolinoame() {

        try {
            String optiune_1 = p1_text.getText();
            String optiune_2 = p2_text.getText();

            Polinom polinom_1 = new Polinom();
            polinom_1.parseAndAddTerms(optiune_1);

            Polinom polinom_2 = new Polinom();
            polinom_2.parseAndAddTerms(optiune_2);

            Polinom rezultat = new Polinom();
            rezultat = Operations.produs(polinom_1, polinom_2);

            rezultat_text.setText(rezultat.toString());
        } catch (IllegalArgumentException e){

            rezultat_text.setText(e.getMessage());
        }
    }

    @FXML
    private void derivataPolinom() {

        try {
            String optiune_1 = p1_text.getText();

            Polinom polinom_1 = new Polinom();
            polinom_1.parseAndAddTerms(optiune_1);

            Polinom rezultat = new Polinom();
            rezultat = Operations.derivat(polinom_1);

            rezultat_text.setText(rezultat.toString());
        } catch (IllegalArgumentException e){

            rezultat_text.setText(e.getMessage());
        }
    } @FXML
    private void integralaPolinom() {

        try {
            String optiune_1 = p1_text.getText();

            Polinom polinom_1 = new Polinom();
            polinom_1.parseAndAddTerms(optiune_1);

            Polinom rezultat = new Polinom();
            rezultat = Operations.integrala(polinom_1);

            rezultat_text.setText(rezultat.toStringImpartiri() + "+C");
        } catch (IllegalArgumentException e){

            rezultat_text.setText(e.getMessage());
        }
    }

}