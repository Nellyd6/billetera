package application.model;

import java.util.Date;

public class Notificacion {
    private String idNotificacion;
    private String mensaje;
    private Date fecha;

    // Constructor, getters y setters

    public void enviarNotificacion() {
        // Lógica para enviar la notificación (e.g., por correo electrónico)
        System.out.println("Enviando notificación: " + mensaje);
    }

    public void verNotificaciones() {
        // Lógica para mostrar las notificaciones (e.g., en consola)
        System.out.println("Mostrando notificación: " + mensaje);
    }

    public String getIdNotificacion() {
        return idNotificacion;
    }

    public void setIdNotificacion(String idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }


    
}
