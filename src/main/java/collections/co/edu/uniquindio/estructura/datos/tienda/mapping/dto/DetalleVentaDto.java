package collections.co.edu.uniquindio.estructura.datos.tienda.mapping.dto;

import java.util.ArrayList;

public record DetalleVentaDto(
        Integer cantidad,
        Integer subtotal,
        ProductoDto producto) {
}