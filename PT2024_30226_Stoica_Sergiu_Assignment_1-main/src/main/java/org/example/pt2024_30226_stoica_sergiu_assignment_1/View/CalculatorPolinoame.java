package org.example.pt2024_30226_stoica_sergiu_assignment_1.View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.pt2024_30226_stoica_sergiu_assignment_1.Controller.Calc_Controller;

import java.io.IOException;

public class CalculatorPolinoame extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(CalculatorPolinoame.class.getResource("/org/example/pt2024_30226_stoica_sergiu_assignment_1/calc-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Calculator polinoame!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}