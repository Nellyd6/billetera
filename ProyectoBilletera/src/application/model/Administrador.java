package application.model;

import java.util.ArrayList;
import java.util.List;

// Clase Administrador
public class Administrador {
    private List<Usuario> usuarios;
    private List<Cuenta> cuentas;
    private List<Transaccion> transacciones;

    public Administrador() {
        this.usuarios = new ArrayList<>();
        this.cuentas = new ArrayList<>();
        this.transacciones = new ArrayList<>();
    }

    // RF-006: Gestionar usuarios
    public void crearUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void actualizarUsuario(Usuario usuario) {
        // Lógica para actualizar un usuario
        // Busca el usuario y actualiza sus datos
    }

    public void eliminarUsuario(Usuario usuario) {
        usuarios.remove(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return usuarios;
    }

    // RF-007: Gestionar cuentas
    public void agregarCuenta(Cuenta cuenta) {
        cuentas.add(cuenta);
    }

    public void actualizarCuenta(Cuenta cuenta) {
        // Lógica para actualizar una cuenta
        // Busca la cuenta y actualiza sus datos
    }

    public void eliminarCuenta(Cuenta cuenta) {
        cuentas.remove(cuenta);
    }

    // RF-008: Gestionar transacciones
    public void crearTransaccion(Transaccion transaccion) {
        transacciones.add(transaccion);
    }

    public List<Transaccion> listarTransacciones() {
        return transacciones;
    }

    // RF-009: Mostrar estadísticas
    public void mostrarEstadisticas() {
        // Lógica para calcular y mostrar estadísticas
        // Ejemplo: gastos más comunes, usuarios con más transacciones, saldo promedio
    }

    // RF-010: Mostrar estadísticas en gráficas (utilizando JavaFX Charts)
    public void mostrarEstadisticasGrafica() {
        // Lógica para mostrar estadísticas en gráficas usando JavaFX Charts
        // Necesitarás importar la librería JavaFX para utilizar sus componentes de gráficos
    }
}