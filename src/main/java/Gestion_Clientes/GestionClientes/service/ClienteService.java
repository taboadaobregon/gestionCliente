package Gestion_Clientes.GestionClientes.service;

import Gestion_Clientes.GestionClientes.entity.ClienteEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClienteService {


    public ClienteEntity saveCliente(ClienteEntity cliente);

    public List<ClienteEntity> getAllClientes();

    public Boolean deleteCliente(Long id);

    public ClienteEntity getClienteById(Long id);

    public ClienteEntity updateCliente(ClienteEntity cliente);

}
