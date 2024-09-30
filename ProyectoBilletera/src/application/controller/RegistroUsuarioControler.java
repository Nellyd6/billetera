package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import application.model.TipoDocumento;
import application.model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class RegistroUsuarioControler {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button botonContinuar;

    @FXML
    private Button botonVolverBilletera;

    @FXML
    private ComboBox<TipoDocumento> boxTipoDocumento;

    @FXML
    private TextField textCelular;

    @FXML
    private TextField textCorreo;

    @FXML
    private TextField textDireccion;

    @FXML
    private TextField textId;

    @FXML
    private TextField textNombre;

    @FXML
    void agregarCelular(ActionEvent event) {

    }
 
    @FXML
    void agregarCorreo(ActionEvent event) {

    }

    @FXML
    void agregarDireccion(ActionEvent event) {

    }

    @FXML
    void agregarId(ActionEvent event) {

    }

    @FXML
    void agregarNombre(ActionEvent event) {

    }

    @FXML
    void continuarRegistro(ActionEvent event) {
    	
    	// Obtener los valores de los campos
    	String nombre = textNombre.getText();
    	String id = textId.getText();
    	String celular = textCelular.getText();
    	TipoDocumento tipoSeleccionado = boxTipoDocumento.getValue();
    	String correo = textCorreo.getText();
    	String direccion = textDireccion.getText();

    	// Validar si algún campo está vacío
   	 	if (tipoSeleccionado == null ||id.isEmpty() ||nombre.isEmpty() ||  celular.isEmpty() ||  correo.isEmpty() || direccion.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.");
            return;
        }
   	 	
   	 try {
         // Verificar si el usuario ya existe en el archivo usando solo el tipo de documento y el ID
         if (Usuario.usuarioExiste(tipoSeleccionado, Integer.parseInt(id))) {
             JOptionPane.showMessageDialog(null, "El usuario ya se encuentra registrado.");
         } else {
             // Si no existe, crear un nuevo usuario y guardarlo
             Usuario nuevoUsuario = new Usuario(tipoSeleccionado, Integer.parseInt(id), nombre, celular, correo, direccion, 0.0);
             Usuario.guardarUsuarioEnArchivo(nuevoUsuario);
             JOptionPane.showMessageDialog(null, "Usuario registrado con éxito.");
         }
     } catch (IOException e) {
         System.out.println("Ocurrió un error al acceder al archivo: " + e.getMessage());
     } catch (NumberFormatException e) {
         System.out.println("Error en el formato del ID o celular: " + e.getMessage());
     }
 
   	 	
   	 	// Limpiar los campos después del registro
   	 	textNombre.clear();
    	textId.clear();
    	textCelular.clear();
    	boxTipoDocumento.setValue(null);
    	textCorreo.clear();
    	textDireccion.clear();
    }

   
    @FXML
    void tipoDocumento(ActionEvent event) {

    }

    @FXML
    void volverVentanaBilletera(ActionEvent event) {
    	
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/application/viewBilletera.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			Stage nuevaVentana = new Stage();
			nuevaVentana.setTitle("CashColombia");
			nuevaVentana.setScene(scene);
			nuevaVentana.show();
		 
			// Ocultar la ventana actual
			Stage stageActual = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stageActual.hide();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

    @FXML
    void initialize() {
        boxTipoDocumento.getItems().addAll(TipoDocumento.values());
        
        // Para permitir que en los campos Id y celular solo se ingresen dígitos
        textId.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    textId.setText(newValue.replaceAll("[^\\d]", ""));
                    JOptionPane.showMessageDialog(null, "Por favor,ingrese solo números.");
                }
               
                
            }
            }
        );

        textCelular.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    textCelular.setText(newValue.replaceAll("[^\\d]", ""));
                    JOptionPane.showMessageDialog(null, "Por favor,ingrese solo números.");
                }
                
                
            }
            }
        );
    	        
        // Configurar enter para pasar al siguiente campo
        configurarEnter(boxTipoDocumento, textId );
        configurarEnter(textId, textNombre);
        configurarEnter(textNombre, textCelular);
        configurarEnter(textCelular, textCorreo);
        configurarEnter(textCorreo, textDireccion);
    }
    	        
    private void configurarEnter(ComboBox<?> campoActual, TextField siguienteCampo) {
        campoActual.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                siguienteCampo.requestFocus(); 
                event.consume(); 
            }
        });
    }

    private void configurarEnter(TextField campoActual, TextField siguienteCampo) {
        campoActual.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                siguienteCampo.requestFocus();
                event.consume(); 
            }
        });
    }
}
