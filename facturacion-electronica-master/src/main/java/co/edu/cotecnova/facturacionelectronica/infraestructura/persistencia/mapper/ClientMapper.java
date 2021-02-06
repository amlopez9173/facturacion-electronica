package co.edu.cotecnova.facturacionelectronica.infraestructura.persistencia.mapper;

import co.edu.cotecnova.facturacionelectronica.dominio.modelo.Client;
import co.edu.cotecnova.facturacionelectronica.infraestructura.persistencia.entidades.Cliente;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * Interface que permite mapear un Cliente a un Client y viceversa
 * @author Desarrolladores Cotecnova
 * @version 1.0
 * @since 2021
 */

@Mapper(componentModel = "spring")
public interface ClientMapper {
    @Mappings({
            @Mapping(source = "id", target = "clientId"),
            @Mapping(source = "documento", target = "document"),
            @Mapping(source = "nombres", target = "name"),
            @Mapping(source = "apellidos", target = "lastname"),
            @Mapping(source = "direccion", target = "address"),
            @Mapping(source = "telefono", target = "phone"),
            @Mapping(source = "estado", target = "active"),
            @Mapping(source = "fechaCreacion", target = "creationDate"),
    })
    Client toClient(Cliente cliente);
    List<Client> toClients(List<Cliente> clientes);

    @InheritInverseConfiguration
    @Mapping(target = "ventas", ignore = true)
    Cliente toCliente(Client client);
}
