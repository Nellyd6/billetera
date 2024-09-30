package application.model;

public class Presupuesto {
    private int idPresupuesto;
    private String nombre;
    private double montoTotal;
    private double montoGastado;
    private Categoria categoria;

    // Constructor
    public Presupuesto(int idPresupuesto, String nombre, double montoTotal, Categoria categoria) {
        this.idPresupuesto = idPresupuesto;
        this.nombre = nombre;
        this.montoTotal = montoTotal;
        this.montoGastado = 0;
        this.categoria = categoria;
    }

    // Métodos
    public void crearPresupuesto() {
        System.out.println("Presupuesto creado: " + this.nombre + " con un monto de " + this.montoTotal);
    }

    public void actualizarPresupuesto(double nuevoMontoTotal) {
        this.montoTotal = nuevoMontoTotal;
        System.out.println("Presupuesto actualizado: " + this.nombre + " con un nuevo monto de " + this.montoTotal);
    }

    public void eliminarPresupuesto() {
        System.out.println("Presupuesto eliminado: " + this.nombre);
    }

    public void consultarEstado() {
        System.out.println("Presupuesto: " + this.nombre + " - Monto Total: " + this.montoTotal + " - Gastado: " + this.montoGastado);
    }

    public void registrarGasto(double gasto) {
        if (this.montoGastado + gasto <= this.montoTotal) {
            this.montoGastado += gasto;
            System.out.println("Gasto registrado. Gastado: " + this.montoGastado + " de " + this.montoTotal);
        } else {
            System.out.println("Gasto excede el presupuesto disponible.");
        }
    }
}