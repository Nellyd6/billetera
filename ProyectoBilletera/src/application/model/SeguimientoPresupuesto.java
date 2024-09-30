package application.model;

import java.util.List;

public class SeguimientoPresupuesto {
    private Usuario usuario;

    public SeguimientoPresupuesto(Usuario usuario) {
        this.usuario = usuario;
    }

    // Método para listar todos los presupuestos
    public List<Presupuesto> listarPresupuestos() {
        return usuario.getPresupuestos();
    }

    // Método para consultar el estado de un presupuesto específico
    public Presupuesto consultarEstado(String idPresupuesto) {
        return usuario.getPresupuestos().stream()
                .filter(p -> p.getIdPresupuesto().equals(idPresupuesto))
                .findFirst()
                .orElse(null);
    }

    // Método para crear un nuevo presupuesto
    public void crearPresupuesto(Presupuesto presupuesto) {
        usuario.getPresupuestos().add(presupuesto);
    }

    // Método para actualizar un presupuesto existente
    public void actualizarPresupuesto(String idPresupuesto, double montoGastado) {
        Presupuesto presupuesto = consultarEstado(idPresupuesto);
        if (presupuesto != null) {
            presupuesto.setMontoGastado(montoGastado);
        }
    }

    // Método para eliminar un presupuesto
    public void eliminarPresupuesto(String idPresupuesto) {
        usuario.getPresupuestos().removeIf(p -> p.getIdPresupuesto().equals(idPresupuesto));
    }

    // Método para monitorear el gasto en relación con el presupuesto
    public void monitorearGasto(String idPresupuesto) {
        Presupuesto presupuesto = consultarEstado(idPresupuesto);
        if (presupuesto != null) {
            double gastoRestante = presupuesto.getMontoTotal() - presupuesto.getMontoGastado();
            System.out.println("Presupuesto: " + presupuesto.getNombre() + " | Gastado: " + presupuesto.getMontoGastado() + " | Restante: " + gastoRestante);
        }
    }
}