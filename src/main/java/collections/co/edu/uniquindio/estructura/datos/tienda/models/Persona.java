package collections.co.edu.uniquindio.estructura.datos.tienda.models;

public abstract class Persona {

    private String numeroIdentificacion;
    private String nombre;
    private String apellido;
    private String direccion;

    public Persona(String numeroIdentificacion, String nombre, String apellido, String direccion) {
        this.numeroIdentificacion = numeroIdentificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
    }

    public Persona(){

    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
