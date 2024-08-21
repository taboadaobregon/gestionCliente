package Gestion_Clientes.GestionClientes.dao;

import Gestion_Clientes.GestionClientes.entity.VentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaRepository extends JpaRepository<VentaEntity,Long> {

}
