package Gestion_Clientes.GestionClientes.service;

import Gestion_Clientes.GestionClientes.entity.ProductoEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface ProductoService {

    public ProductoEntity saveProduct(ProductoEntity product);

    public List<ProductoEntity> getAllProducts();

    public Boolean deleteProduct(Long id);

    public ProductoEntity getProductById(Long id);

    public ProductoEntity updateProduct(ProductoEntity product);
}
