module ProyectoBilletera {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
	requires java.desktop;

    exports application;  
    opens application.controller to javafx.fxml;  
}