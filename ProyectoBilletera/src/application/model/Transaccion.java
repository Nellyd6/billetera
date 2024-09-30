package application.model;

import java.util.Date;

public class Transaccion {
    private int idTransaccion;
    private Date fecha;
    private String tipo; // Depósito, Retiro, Transferencia
    private double monto;
    private String descripcion;
    private Cuenta cuentaOrigen;
    private Cuenta cuentaDestino;
    private Categoria categoria;

    // Constructor
    public Transaccion(int idTransaccion, Date fecha, String tipo, double monto, String descripcion, Cuenta cuentaOrigen, Cuenta cuentaDestino, Categoria categoria) {
        this.idTransaccion = idTransaccion;
        this.fecha = fecha;
        this.tipo = tipo;
        this.monto = monto;
        this.descripcion = descripcion;
        this.cuentaOrigen = cuentaOrigen;
        this.cuentaDestino = cuentaDestino;
        this.categoria = categoria;
    }

    // Métodos
    public void crearTransaccion() {
        System.out.println("Transacción creada: " + this.tipo + " por " + this.monto);
        if (cuentaOrigen != null) {
            System.out.println("Cuenta Origen: " + cuentaOrigen);
        }
        if (cuentaDestino != null) {
            System.out.println("Cuenta Destino: " + cuentaDestino);
        }
    }

    public void listarTransacciones() {
        // Aquí iría la lógica para listar todas las transacciones
        System.out.println("Transacción: " + this.descripcion + " de " + this.monto);
    }

    public void verDetallesTransaccion() {
        System.out.println("Detalles de la Transacción: ID " + idTransaccion + " - Tipo: " + tipo + " - Monto: " + monto + " - Fecha: " + fecha);
        System.out.println("Descripción: " + descripcion);
        if (cuentaOrigen != null) {
            System.out.println("Cuenta Origen: " + cuentaOrigen);
        }
        if (cuentaDestino != null) {
            System.out.println("Cuenta Destino: " + cuentaDestino);
        }
    }

    @Override
    public String toString() {
        return "Transacción: " + tipo + " - Monto: " + monto + " - Fecha: " + fecha + " - Descripción: " + descripcion;
    }
}
