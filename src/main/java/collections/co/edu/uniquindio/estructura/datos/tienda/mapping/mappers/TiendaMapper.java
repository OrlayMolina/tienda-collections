package collections.co.edu.uniquindio.estructura.datos.tienda.mapping.mappers;

import collections.co.edu.uniquindio.estructura.datos.tienda.mapping.dto.ClienteDto;
import collections.co.edu.uniquindio.estructura.datos.tienda.models.Cliente;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface TiendaMapper {

    TiendaMapper INSTANCE = Mappers.getMapper(TiendaMapper.class);

    @Named("clienteToClienteDto")
    ClienteDto clienteToClienteDto(Cliente cliente);

    Cliente clienteDtoToCliente(ClienteDto compradorDto);

    @IterableMapping(qualifiedByName = "clienteToClienteDto")
    HashMap<String, ClienteDto> getClienteDto(HashMap<String, Cliente> listaClientes);
}
