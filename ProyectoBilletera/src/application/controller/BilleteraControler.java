package application.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Node;

public class BilleteraControler {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button botonIniciarSesion;

    @FXML
    private Button botonRegistrar;

    @FXML
    void iniciarSesionUsuario(ActionEvent event) {

		try {
			Parent root = FXMLLoader.load(getClass().getResource("/application/viewIniciarSesion.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			Stage nuevaVentana= new Stage();
			nuevaVentana.setTitle("Iniciar sesion");
			nuevaVentana.setScene(scene);
			nuevaVentana.show();
		 
			
			Stage stageActual = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stageActual.hide();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}



    @FXML
    void registrarUsuario(ActionEvent event) {
    
    		try {
    			Parent root = FXMLLoader.load(getClass().getResource("/application/viewRegistroUsuario.fxml"));
    			Scene scene = new Scene(root);
    			scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
    			Stage nuevaVentana= new Stage();
    			nuevaVentana.setTitle("Registro");
    			nuevaVentana.setScene(scene);
    			nuevaVentana.show();
    		 
    			
    			Stage stageActual = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stageActual.hide();
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
    	}
    	

    @FXML
    void initialize() {
       
    }

}