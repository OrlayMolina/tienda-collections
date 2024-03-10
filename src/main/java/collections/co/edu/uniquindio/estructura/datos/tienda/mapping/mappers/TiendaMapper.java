package collections.co.edu.uniquindio.estructura.datos.tienda.mapping.mappers;

import collections.co.edu.uniquindio.estructura.datos.tienda.mapping.dto.ClienteDto;
import collections.co.edu.uniquindio.estructura.datos.tienda.mapping.dto.DetalleVentaDto;
import collections.co.edu.uniquindio.estructura.datos.tienda.mapping.dto.ProductoDto;
import collections.co.edu.uniquindio.estructura.datos.tienda.mapping.dto.VentaDto;
import collections.co.edu.uniquindio.estructura.datos.tienda.models.Cliente;
import collections.co.edu.uniquindio.estructura.datos.tienda.models.DetalleVenta;
import collections.co.edu.uniquindio.estructura.datos.tienda.models.Producto;
import collections.co.edu.uniquindio.estructura.datos.tienda.models.Venta;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@Mapper
public interface TiendaMapper {
    TiendaMapper INSTANCE = Mappers.getMapper(TiendaMapper.class);
    @Named("clienteToClienteDto")
    ClienteDto clienteToClienteDto(Cliente cliente);

    Cliente clienteDtoToCliente(ClienteDto compradorDto);

    @IterableMapping(qualifiedByName = "clienteToClienteDto")
    HashMap<String, ClienteDto> getClienteDto(HashMap<String, Cliente> listaClientes);

    @Named("productoToProductoDto")
    ProductoDto productoToProductoDto(Producto producto);

    Producto productoDtoToProducto(ProductoDto productoDto);

    @IterableMapping(qualifiedByName = "productoToProductoDto")
    HashMap<String, ProductoDto> getProductoDto(HashMap<String, Producto> listaProductos);

    @Named("ventaToVentaDto")
    VentaDto ventaToVentaDto(Venta venta);

    Venta ventaDtoToVenta(VentaDto ventaDto);

    @IterableMapping(qualifiedByName = "ventaToVentaDto")
    List<VentaDto> getVentaDto(List<Venta> listaVentas);

    @IterableMapping(qualifiedByName = "ventaToVentaDto")
    LinkedList<VentaDto> getVentaHistorialDto(LinkedList<Venta> listaVentas);

    @Named("detalleVentaToDetalleVentaDto")
    DetalleVentaDto detalleVentaToDetalleVentaDto(DetalleVenta detalleVenta);

    DetalleVenta detalleVentaDtoToDetalleVenta(DetalleVentaDto detalleVentaDto);

    @IterableMapping(qualifiedByName = "detalleVentaToDetalleVentaDto")
    List<DetalleVentaDto> getDetalleVentaDto(List<DetalleVenta> listaDetalleVentas);

}
