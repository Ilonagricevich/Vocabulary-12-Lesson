module com.example.vocabularylesson12 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.vocabularylesson12 to javafx.fxml;
    exports com.example.vocabularylesson12;
}