package application.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Date;


public class SeguimientoTransacciones {
    private Usuario usuario;

    public SeguimientoTransacciones(Usuario usuario) {
        this.usuario = usuario;
    }

    // Método para listar todas las transacciones
    public List<Transaccion> listarTransacciones() {
        return usuario.getTransacciones();
    }

    // Método para filtrar transacciones por tipo (depósito, retiro, transferencia)
    public List<Transaccion> filtrarPorTipo(tipoTransacción tipo) {
        return usuario.getTransacciones().stream()
                .filter(t -> t.getTipo().equals(tipo))
                .collect(Collectors.toList());
    }

    // Método para filtrar transacciones por fecha (transacciones recientes)
    public List<Transaccion> filtrarPorFecha(Date fecha) {
        return usuario.getTransacciones().stream()
                .filter(t -> t.getFecha().equals(fecha))
                .collect(Collectors.toList());
    }

    // Método para obtener el detalle de una transacción específica
    public Transaccion obtenerDetalle(String idTransaccion) {
        return usuario.getTransacciones().stream()
                .filter(t -> t.getIdTransaccion().equals(idTransaccion))
                .findFirst()
                .orElse(null);
    }
}