package Gestion_Clientes.GestionClientes.controller;

import Gestion_Clientes.GestionClientes.dao.ProductoRepository;
import Gestion_Clientes.GestionClientes.entity.ProductoEntity;
import Gestion_Clientes.GestionClientes.service.ProductoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/producto")
public class ProductoController {

    private ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping("/save")
    public ProductoEntity agregarProducto(@RequestBody ProductoEntity producto){
        return productoService.saveProduct(producto);
    }

    @GetMapping("/list")
    public List<ProductoEntity> listarProductos(){
        return productoService.getAllProducts();
    }

    @GetMapping("/eliminar/{id}")
    public String deleteProduct(@PathVariable Long id, HttpSession session) {
        Boolean deleteProduct = productoService.deleteProduct(id);
        if (deleteProduct) {
            session.setAttribute("succMsg", "Product delete success");
        } else {
            session.setAttribute("errorMsg", "Something wrong on server");
        }
        return "se elimino exitosamente";
    }

    @GetMapping("/listarPorId/{id}")
    ResponseEntity<ProductoEntity> buscarProducto(@PathVariable Long id){
        ProductoEntity respuestaService = productoService.getProductById(id);
        if(respuestaService != null){
            return ResponseEntity.ok().body(respuestaService);
        }else {
            return ResponseEntity.notFound().build();
        }
    }











}
