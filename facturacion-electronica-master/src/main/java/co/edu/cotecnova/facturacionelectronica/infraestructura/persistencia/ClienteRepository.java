package co.edu.cotecnova.facturacionelectronica.infraestructura.persistencia;

import co.edu.cotecnova.facturacionelectronica.dominio.modelo.Client;
import co.edu.cotecnova.facturacionelectronica.dominio.repositorio.ClientRepository;
import co.edu.cotecnova.facturacionelectronica.infraestructura.persistencia.crud.ClienteCrudRepositorio;
import co.edu.cotecnova.facturacionelectronica.infraestructura.persistencia.entidades.Cliente;
import co.edu.cotecnova.facturacionelectronica.infraestructura.persistencia.mapper.ClientMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repositorio que implementa todas las operaciones en base de datos para los clientes
 * @author Desarrolladores Cotecnova
 * @version 1.0
 * @since 2021
 */

@Repository
public class ClienteRepository implements ClientRepository {

    private ClienteCrudRepositorio clienteCrudRepositorio;
    private ClientMapper clientMapper;

    public ClienteRepository(ClienteCrudRepositorio clienteCrudRepositorio, ClientMapper clientMapper) {
        this.clienteCrudRepositorio = clienteCrudRepositorio;
        this.clientMapper = clientMapper;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Client> getAll() {
        List<Cliente> clientes = (List<Cliente>) clienteCrudRepositorio.findByEstadoTrue();
        return clientMapper.toClients(clientes);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Client> findById(int clientId) {
        Optional<Cliente> cliente = clienteCrudRepositorio.findById(clientId);
        return cliente.map(clie -> clientMapper.toClient(clie));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Client save(Client client) {
        Cliente cliente = clientMapper.toCliente(client);
        return clientMapper.toClient(clienteCrudRepositorio.save(cliente));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(int clientId) {
        clienteCrudRepositorio.deleteById(clientId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Client update(Client client) {
        Cliente cliente = clientMapper.toCliente(client);
        return clientMapper.toClient(clienteCrudRepositorio.save(cliente));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Client> findByDocument(String document) {
        Optional<Cliente> cliente = clienteCrudRepositorio.findByDocumento(document);
        return cliente.map(cli -> clientMapper.toClient(cli));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Page<Client> findAll(Pageable pageable) {
        return clienteCrudRepositorio.findAll(pageable).map(cliente -> clientMapper.toClient(cliente));
    }
}
