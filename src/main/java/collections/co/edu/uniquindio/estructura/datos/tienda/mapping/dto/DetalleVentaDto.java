package collections.co.edu.uniquindio.estructura.datos.tienda.mapping.dto;
public record DetalleVentaDto(

        String codigo,
        Integer cantidad,
        Integer subtotal,
        ProductoDto producto) {


}