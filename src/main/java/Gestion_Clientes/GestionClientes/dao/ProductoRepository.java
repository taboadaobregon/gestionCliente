package Gestion_Clientes.GestionClientes.dao;

import Gestion_Clientes.GestionClientes.entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<ProductoEntity,Long> {

}
