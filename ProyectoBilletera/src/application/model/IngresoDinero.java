package application.model;

public class IngresoDinero implements OperacionDinero {
    private Usuario usuario;
    private double monto;

    public IngresoDinero(Usuario usuario, double monto) {
        this.usuario = usuario;
        this.monto = monto;
    }

    @Override
    public void ejecutar() {
        usuario.setSaldo(usuario.getSaldo() + monto);
        
    }
}
