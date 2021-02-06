package co.edu.cotecnova.facturacionelectronica.dominio.servicio;

import co.edu.cotecnova.facturacionelectronica.dominio.excepion.ClientException;
import co.edu.cotecnova.facturacionelectronica.dominio.modelo.Client;
import co.edu.cotecnova.facturacionelectronica.dominio.repositorio.ClientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio para realizar las operaciones de los clientes
 * @author Desarrolladores Cotecnova
 * @version 1.0
 * @since 2021
 */

@Service
public class ClientService {
    private final static String DOCUMENTO_YA_EXISTE = "El codigo ya existe en la base de datos";
    private final static String ID_NO_ENCONTRADO = "El id no fue encontrado";
    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    /**
     * Permite retornar un listado de clientes existentes en la base de datos
     * @return Listado de clientes de la base de datos
     */
    public List<Client> getAll(){
        return clientRepository.getAll();
    }

    /**
     * Permite buscar un cliente enviando su id como parametro
     * @param clientId Corresponde al id del cliente
     * @return Cliente encontrado en la base de datos
     */
    public Optional<Client> findById(int clientId){
        Optional<Client> client = clientRepository.findById(clientId);
        if(client.isPresent()){
            return client;
        }else{
            throw new ClientException(ID_NO_ENCONTRADO);
        }
    }

    /**
     * Permite guardar un cliente
     * @param client Corresponde al objeto cliente con todos sus atributos
     * @return Cliente creado en la base de datos
     */
    public Client save(Client client){
        Optional<Client> result = clientRepository.findByDocument(client.getDocument());
        if(result.isPresent()){
            throw new ClientException(DOCUMENTO_YA_EXISTE);
        }else{
            return clientRepository.save(client);
        }
    }

    /**
     * Permite eliminar un cliente de la base de datos
     * @param clientId Corresponde al id del cliente a eliminar
     */
    public void delete(int clientId){
        Optional<Client> client = clientRepository.findById(clientId);
        if(client.isPresent()){
            clientRepository.delete(clientId);
        }else{
            throw new ClientException(ID_NO_ENCONTRADO);
        }
    }

    /**
     * Permite actualizar un cliente de la base de datos
     * @param client Corresponde al objeto cliente con los datos a actualizar en la base de datos
     * @param clientId Corresponde al id del cliente a actualizar
     * @return Cliente actualizado
     */
    public Client update(Client client, int clientId){
        Optional<Client> result = clientRepository.findById(clientId);
        if(result.isPresent()){
            return clientRepository.update(client);
        }else{
            throw new ClientException(ID_NO_ENCONTRADO);
        }
    }

    /**
     * Permite obtener el listado de clientes de la base de datos de forma paginada
     * @param pageable Corresponde al objeto que contiene el atributo page y size
     * @return Objeto tipo Page con el listado de clientes de la base de datos
     */
    public Page<Client> findAll(Pageable pageable){
        return clientRepository.findAll(pageable);
    }
}
