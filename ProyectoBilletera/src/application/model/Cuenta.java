package application.model;

public class Cuenta {
    private int idCuenta;
    private String nombreBanco;
    private String numeroCuenta;
    private String tipoCuenta; // Ahorro, Corriente, etc.

    // Constructor
    public Cuenta(int idCuenta, String nombreBanco, String numeroCuenta, String tipoCuenta) {
        this.idCuenta = idCuenta;
        this.nombreBanco = nombreBanco;
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
    }

    // Métodos
    public void agregarCuenta() {
    	
        try {
            if (cuentaYaExiste(idCuenta)) {
                throw new CuentaNoValidaException("La cuenta ya existe.");
            }
            // Lógica para agregar cuenta
            System.out.println("Cuenta agregada: " + idCuenta);
        } catch (CuentaNoValidaException e) {
            System.out.println("Error al agregar la cuenta: " + e.getMessage());
        }
        System.out.println("Cuenta agregada: " + this.nombreBanco + ", " + this.numeroCuenta);
    }

    public void actualizarCuenta(String nuevoNombreBanco, String nuevoNumeroCuenta, String nuevoTipoCuenta) {
        this.nombreBanco = nuevoNombreBanco;
        this.numeroCuenta = nuevoNumeroCuenta;
        this.tipoCuenta = nuevoTipoCuenta;
        System.out.println("Cuenta actualizada: " + this.nombreBanco + ", " + this.numeroCuenta);
    }

    public void eliminarCuenta() {
        System.out.println("Cuenta eliminada: " + this.numeroCuenta);
    }

    public void consultarCuenta() {
        System.out.println("Cuenta: " + this.nombreBanco + ", Número: " + this.numeroCuenta + ", Tipo: " + this.tipoCuenta);
    }

    @Override
    public String toString() {
        return "Cuenta: " + nombreBanco + " - Número: " + numeroCuenta + " - Tipo: " + tipoCuenta;
    }
}