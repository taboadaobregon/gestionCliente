package Gestion_Clientes.GestionClientes.dao;

import Gestion_Clientes.GestionClientes.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteEntity,Long> {

}
