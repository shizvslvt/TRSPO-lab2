module com.example.trspolab2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.trspolab2 to javafx.fxml;
    exports com.example.trspolab2;
}