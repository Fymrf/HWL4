module com.example.hwl4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.hwl4 to javafx.fxml;
    exports com.example.hwl4;
}