package application.model;

import java.util.ArrayList;
import java.util.List;

public class Reporte {
    private String idReporte;
    private TipoReporte tipoReporte;
    private List<Notificacion> notificaciones;

    // Constructor
    public Reporte(String idReporte, TipoReporte tipoReporte) {
        this.idReporte = idReporte;
        this.tipoReporte = tipoReporte;
        this.notificaciones = new ArrayList<>();
    }

    // Getters y setters
    public String getIdReporte() {
        return idReporte;
    }

    public TipoReporte getTipoReporte() {
        return tipoReporte;
    }

    public List<Notificacion> getNotificaciones() {
        return notificaciones;
    }

    public void enviarNotificacion() {
        // Crear una notificación asociada al reporte y enviarla
        Notificacion notificacion = new Notificacion();
        notificacion.setMensaje("Nuevo reporte generado: " + tipoReporte);
        notificacion.enviarNotificacion();
    }
    // Método para agregar una notificación al reporte
    public void agregarNotificacion(Notificacion notificacion) {
        notificaciones.add(notificacion);
    }



    // Método para ver las notificaciones asociadas al reporte
    public void verNotificaciones() {
        for (Notificacion notificacion : notificaciones) {
            System.out.println(notificacion.getMensaje());
        }
    }
}