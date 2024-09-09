module org.example.pt2024_30226_stoica_sergiu_assignment_ {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.junit.jupiter.api;
    requires junit;


    opens org.example.pt2024_30226_stoica_sergiu_assignment_1 to javafx.fxml;
    //exports org.example.pt2024_30226_stoica_sergiu_assignment_1;
    exports org.example.pt2024_30226_stoica_sergiu_assignment_1.Model;
    opens org.example.pt2024_30226_stoica_sergiu_assignment_1.Model to javafx.fxml;
    exports org.example.pt2024_30226_stoica_sergiu_assignment_1.Controller;
    opens org.example.pt2024_30226_stoica_sergiu_assignment_1.Controller to javafx.fxml;
    exports org.example.pt2024_30226_stoica_sergiu_assignment_1.View;
    opens org.example.pt2024_30226_stoica_sergiu_assignment_1.View to javafx.fxml;
    exports org.example.pt2024_30226_stoica_sergiu_assignment_1.Test;
    opens org.example.pt2024_30226_stoica_sergiu_assignment_1.Test to javafx.fxml;
}