package Gestion_Clientes.GestionClientes.service.impl;

import Gestion_Clientes.GestionClientes.dao.ClienteRepository;
import Gestion_Clientes.GestionClientes.entity.ClienteEntity;
import Gestion_Clientes.GestionClientes.entity.ProductoEntity;
import Gestion_Clientes.GestionClientes.service.ClienteService;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

public class ClienteServiceImpl implements ClienteService {

    private ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public ClienteEntity saveCliente(ClienteEntity cliente) {
        ClienteEntity clienteEntity = clienteRepository.save(cliente);
        return clienteEntity;
    }

    @Override
    public List<ClienteEntity> getAllClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Boolean deleteCliente(Long id) {
        ClienteEntity cliente = clienteRepository.findById(id).orElse(null);
        if(!ObjectUtils.isEmpty(cliente)){
            clienteRepository.delete(cliente);
            return true;
        }

        return false;
    }

    @Override
    public ClienteEntity getClienteById(Long id) {
        Optional<ClienteEntity> cliente = clienteRepository.findById(id);
        if (cliente.isPresent()){
            ClienteEntity cliente1 = cliente.get();
            return cliente1;
        }
        return null;
    }

    @Override
    public ClienteEntity updateCliente(ClienteEntity cliente) {
        return null;
    }
}
