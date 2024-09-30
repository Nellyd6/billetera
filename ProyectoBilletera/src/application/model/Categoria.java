package application.model;

public class Categoria {
    private int idCategoria;
    private String nombre;
    private String descripcion;

    // Constructor
    public Categoria(int idCategoria, String nombre, String descripcion) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    // Métodos
    public void crearCategoria(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        System.out.println("Categoría creada: " + this.nombre);
    }

    public void actualizarCategoria(String nuevoNombre, String nuevaDescripcion) {
        this.nombre = nuevoNombre;
        this.descripcion = nuevaDescripcion;
        System.out.println("Categoría actualizada: " + this.nombre);
    }

    public void eliminarCategoria() {
        System.out.println("Categoría eliminada: " + this.nombre);
    }

    public void listarCategorias() {
        System.out.println("Categoría: " + this.nombre + " - Descripción: " + this.descripcion);
    }

    @Override
    public String toString() {
        return "Categoría: " + nombre + " - Descripción: " + descripcion;
    }
}