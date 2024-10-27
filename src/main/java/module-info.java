module com.example.labarboles {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.labarboles to javafx.fxml;
    exports com.example.labarboles;
}