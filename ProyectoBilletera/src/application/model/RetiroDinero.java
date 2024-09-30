package application.model;

public class RetiroDinero implements OperacionDinero {
    private Usuario usuario;
    private double monto;

    public RetiroDinero(Usuario usuario, double monto) {
        this.usuario = usuario;
        this.monto = monto;
    }

    @Override
    public void ejecutar() throws Exception {
        if (monto > usuario.getSaldo()) {
            throw new Exception("Saldo insuficiente para retirar.");
        }
        
    }
}