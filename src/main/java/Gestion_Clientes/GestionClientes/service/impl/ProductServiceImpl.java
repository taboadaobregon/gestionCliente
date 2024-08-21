package Gestion_Clientes.GestionClientes.service.impl;

import Gestion_Clientes.GestionClientes.dao.ProductoRepository;
import Gestion_Clientes.GestionClientes.entity.ProductoEntity;
import Gestion_Clientes.GestionClientes.service.ProductoService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductoService {

    private ProductoRepository productoRepository;

    public ProductServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public ProductoEntity saveProduct(ProductoEntity product) {
        ProductoEntity producto = productoRepository.save(product);
        return product;
    }

    @Override
    public List<ProductoEntity> getAllProducts() {
        return productoRepository.findAll();
    }

    @Override
    public Boolean deleteProduct(Long id) {
        ProductoEntity producto = productoRepository.findById(id).orElse(null);
        if(!ObjectUtils.isEmpty(producto)){
            productoRepository.delete(producto);
            return true;
        }

        return false;
    }

    @Override
    public ProductoEntity getProductById(Long id) {
        Optional<ProductoEntity> producto = productoRepository.findById(id);
        if (producto.isPresent()){
            ProductoEntity productoEntity = producto.get();
            return productoEntity;
        }
        return null;
    }

    @Override
    public ProductoEntity updateProduct(ProductoEntity product) {
        return null;
    }
}
