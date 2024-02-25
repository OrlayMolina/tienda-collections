package collections.co.edu.uniquindio.estructura.datos.tienda.mapping.dto;

public record ClienteDto(
        String numeroIdentificacion,
        String nombre,
        String apellido,
        String direccion) {

    @Override
    public String toString() {
        return numeroIdentificacion + " " + "-" +  " " + nombre + " " + apellido;
    }
}
