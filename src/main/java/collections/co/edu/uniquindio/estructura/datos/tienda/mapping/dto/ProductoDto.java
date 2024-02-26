package collections.co.edu.uniquindio.estructura.datos.tienda.mapping.dto;

public record ProductoDto(
        String codigo,
        String nombre,
        Integer precio,
        Integer cantidad) {

    @Override
    public String toString() {
        return codigo + " " + "-" + " " + nombre;
    }
}
