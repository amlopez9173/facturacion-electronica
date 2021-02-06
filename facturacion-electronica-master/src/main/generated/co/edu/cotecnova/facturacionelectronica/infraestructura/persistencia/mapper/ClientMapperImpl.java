package co.edu.cotecnova.facturacionelectronica.infraestructura.persistencia.mapper;

import co.edu.cotecnova.facturacionelectronica.dominio.modelo.Client;
import co.edu.cotecnova.facturacionelectronica.infraestructura.persistencia.entidades.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-01-27T19:07:27-0500",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_271 (Oracle Corporation)"
)
@Component
public class ClientMapperImpl implements ClientMapper {

    @Override
    public Client toClient(Cliente cliente) {
        if ( cliente == null ) {
            return null;
        }

        Client client = new Client();

        if ( cliente.getId() != null ) {
            client.setClientId( cliente.getId() );
        }
        client.setDocument( cliente.getDocumento() );
        client.setName( cliente.getNombres() );
        client.setLastname( cliente.getApellidos() );
        client.setAddress( cliente.getDireccion() );
        client.setPhone( cliente.getTelefono() );
        if ( cliente.getEstado() != null ) {
            client.setActive( cliente.getEstado() );
        }
        client.setCreationDate( cliente.getFechaCreacion() );
        client.setEmail( cliente.getEmail() );

        return client;
    }

    @Override
    public List<Client> toClients(List<Cliente> clientes) {
        if ( clientes == null ) {
            return null;
        }

        List<Client> list = new ArrayList<Client>( clientes.size() );
        for ( Cliente cliente : clientes ) {
            list.add( toClient( cliente ) );
        }

        return list;
    }

    @Override
    public Cliente toCliente(Client client) {
        if ( client == null ) {
            return null;
        }

        Cliente cliente = new Cliente();

        cliente.setId( client.getClientId() );
        cliente.setDocumento( client.getDocument() );
        cliente.setNombres( client.getName() );
        cliente.setApellidos( client.getLastname() );
        cliente.setDireccion( client.getAddress() );
        cliente.setTelefono( client.getPhone() );
        cliente.setEstado( client.isActive() );
        cliente.setFechaCreacion( client.getCreationDate() );
        cliente.setEmail( client.getEmail() );

        return cliente;
    }
}
