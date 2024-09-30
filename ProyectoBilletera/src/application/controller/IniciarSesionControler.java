package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import application.model.TipoDocumento;
import application.model.Usuario;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class IniciarSesionControler {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button botonIngresar;

    @FXML
    private Button botonVolverBilletera;

    @FXML
    private ComboBox<TipoDocumento> boxTipoDocumento2;

    @FXML
    private TextField textId;

    @FXML
    void agregarDocumento(ActionEvent event) {
        // Método para acciones al seleccionar documento (opcional)
    }

    @FXML
    void agregarId(ActionEvent event) {
        // Método para acciones al ingresar el ID (opcional)
    }

    @FXML
    void iniciarSesion(ActionEvent event) {
        // Obtener el tipo de documento seleccionado y el ID ingresado
        TipoDocumento tipoDocumento2 = boxTipoDocumento2.getValue();
        String id = textId.getText();

        // Validar si algún campo está vacío
        if (tipoDocumento2 == null || id.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.");
            return;
        }

        try {
            // Verificar si el usuario ya existe en el archivo
            if (Usuario.validarUsuarioCreado(tipoDocumento2, Integer.parseInt(id))) {
                JOptionPane.showMessageDialog(null, "El usuario ya se encuentra registrado.");
            } else {
                // Si no existe, crear un nuevo usuario y guardarlo
                Usuario nuevoUsuario = new Usuario(tipoDocumento2, Integer.parseInt(id), nombre, celular, correo, direccion, 0.0);
                Usuario.guardarUsuarioEnArchivo(nuevoUsuario);
                JOptionPane.showMessageDialog(null, "Usuario registrado con éxito.");
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error al acceder al archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error en el formato del ID: " + e.getMessage());
        }
    }

    @FXML
    void volverVentanaBilletera(ActionEvent event) {
        try {
            // Cargar la vista de la billetera
            Parent root = FXMLLoader.load(getClass().getResource("/application/viewBilletera.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
            
            // Mostrar la nueva ventana
            Stage nuevaVentana = new Stage();
            nuevaVentana.setTitle("CashColombia");
            nuevaVentana.setScene(scene);
            nuevaVentana.show();
            
            // Ocultar la ventana actual
            Stage stageActual = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stageActual.hide();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void initialize() {
        // Agregar los valores de TipoDocumento al ComboBox
        boxTipoDocumento2.getItems().addAll(TipoDocumento.values());

        // Validación para que solo se puedan ingresar números en el campo ID
        textId.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    textId.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
    }

}
