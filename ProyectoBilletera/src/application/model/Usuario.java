package application.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private TipoDocumento tipoDocumento;
    private int idUsuario;
    private String nombre;
    private String correo;
    private String celular;
    private String direccion;
    private double saldo;
    private List<Cuenta> cuentas;
    private List<Transaccion> transacciones;

    // Constructor
    public Usuario(TipoDocumento tipoDocumento, int idUsuario, String nombre,String celular, String correo,  String direccion, double saldo) {
        this.tipoDocumento = tipoDocumento;
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.correo = correo;
        this.celular = celular;
        this.direccion = direccion;
        this.saldo = saldo;
        this.cuentas = new ArrayList<>();
        this.transacciones = new ArrayList<>();
    }

    // Getters y Setters
    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    public List<Transaccion> getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(List<Transaccion> transacciones) {
        this.transacciones = transacciones;
    }

    // Registrar usuario
    public void registrarse(TipoDocumento tipoDocumento, int idUsuario, String nombre, String celular, String correo, String direccion) {
        this.tipoDocumento = tipoDocumento;
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.correo = correo;
        this.celular = celular;
        this.direccion = direccion;
        System.out.println("Usuario registrado exitosamente.");
    }

    // Métodos de persistencia
    
 
    public static void guardarUsuarioEnArchivo(Usuario usuario) throws IOException {
    	  // Especificar la ruta completa al archivo dentro de un directorio
        String rutaDirectorio = "C:\\Users\\Nelly Delgado\\UsuariosBilletera";
        File directorio = new File(rutaDirectorio);

        // Crear el directorio si no existe
        if (!directorio.exists()) {
            directorio.mkdirs(); // Crear directorio
        }

        // Especificar la ruta del archivo dentro del directorio
        File archivo = new File(directorio, "usuarios.txt");

        // Si el archivo no existe, se creará
        if (!archivo.exists()) {
            archivo.createNewFile();  // Crea el archivo si no existe
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("usuarios.txt", true))) {
            writer.write(usuario.getTipoDocumento() + "," + usuario.getIdUsuario() + "," + usuario.getNombre() + "," +
                         usuario.getCelular() + "," + usuario.getCorreo() + "," + usuario.getDireccion());
            writer.newLine();
        }
     }
       
    

    public static boolean usuarioExiste(TipoDocumento tipoDocumento, int idUsuario) throws IOException {
        // Leer el archivo y buscar si el usuario ya existe
        try (BufferedReader reader = new BufferedReader(new FileReader("usuarios.txt"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datosUsuario = linea.split(",");

                // Asegúrate de que hay suficientes campos en cada línea antes de acceder a ellos
                if (datosUsuario.length < 2) {
                    continue; // Saltar la línea si no tiene el número esperado de campos
                }

                TipoDocumento tipoDocumentoExistente = TipoDocumento.valueOf(datosUsuario[0]);
                int idExistente = Integer.parseInt(datosUsuario[1]);

                // Verificar si el tipoDocumento y el idUsuario coinciden
                if (tipoDocumentoExistente.equals(tipoDocumento) && idExistente == idUsuario) {
                    return true; // El usuario ya existe
                }
            }
        }
        return false; // El usuario no existe
    }

    // Iniciar sesión
    public void  iniciarSesion(TipoDocumento tipoDocumento, int idUsuario) throws IOException {
    	this.tipoDocumento= tipoDocumento;
    	this.idUSuario = idUsuario;
    }
    	
    	public static void guardarUsuarioEnArchivo1(Usuario usuario) throws IOException {
            String rutaArchivo = "usuarios.txt";
            File archivo = new File(rutaArchivo);

            // Crear el archivo si no existe
            if (!archivo.exists()) {
                archivo.createNewFile();
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true))) {
                writer.write(usuario.getTipoDocumento() + "," + usuario.getIdUsuario());
                writer.newLine();
            }
        }

        public static boolean validarUsuarioCreado(TipoDocumento tipoDocumento, int idUsuario) throws IOException {
            File archivo = new File("usuarios.txt");

            // Verificar si el archivo de usuarios existe
            if (!archivo.exists()) {
                return false;
            }

            try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
                String linea;
                while ((linea = reader.readLine()) != null) {
                    String[] datosUsuario = linea.split(",");
                    if (datosUsuario.length < 2) continue; // Asegúrate que haya suficientes campos

                    TipoDocumento tipoDocumentoExistente = TipoDocumento.valueOf(datosUsuario[0]);
                    int idExistente = Integer.parseInt(datosUsuario[1]);

                    // Verificar si el tipoDocumento y el idUsuario coinciden
                    if (tipoDocumentoExistente.equals(tipoDocumento) && idExistente == idUsuario) {
                        return true; // El usuario ya existe
                    }
                }
            }
            return false; // El usuario no existe
        }


    // Modificar perfil
    public void modificarPerfil(String nuevoNombre, String nuevoCorreo, String nuevoCelular, String nuevaDireccion) {
        try {
            if (!nuevoCorreo.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
                throw new FormatoEmailInvalidoException("El formato del email es inválido.");
            }
            if (nuevoCelular.length() != 10) {
                throw new NumeroCelularInvalidoException("Número de teléfono debe tener 10 dígitos.");
            }

            // Actualizar los datos
            this.nombre = nuevoNombre;
            this.correo = nuevoCorreo;
            this.celular = nuevoCelular;
            this.direccion = nuevaDireccion;

            System.out.println("Perfil actualizado exitosamente.");
        } catch (FormatoEmailInvalidoException | NumeroCelularInvalidoException e) {
            System.out.println("Error al modificar el perfil: " + e.getMessage());
        }
    }

    // Consultar saldo
    public void consultarSaldo() {
        System.out.println("Saldo disponible: " + this.saldo);
    }

    // Ver transacciones
    public void verTransacciones() {
        System.out.println("Transacciones de " + this.nombre + ":");
        for (Transaccion transaccion : transacciones) {
            System.out.println(transaccion);
        }
    }

    // Gestionar cuentas
    public void gestionarCuentas() {
        System.out.println("Cuentas bancarias:");
        for (Cuenta cuenta : cuentas) {
            System.out.println(cuenta);
        }
    }

    // Agregar cuenta
    public void agregarCuenta(Cuenta cuenta) {
        this.cuentas.add(cuenta);
        System.out.println("Cuenta agregada exitosamente.");
    }

    // Agregar transacción
    public void agregarTransaccion(Transaccion transaccion) {
        this.transacciones.add(transaccion);
        System.out.println("Transacción agregada exitosamente.");
    }
}

