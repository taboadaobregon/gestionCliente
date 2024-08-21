package Gestion_Clientes.GestionClientes.controller;

import Gestion_Clientes.GestionClientes.dao.VentaDetalleRepository;
import Gestion_Clientes.GestionClientes.entity.VentaDetalleEntity;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/venta-detalle")
@AllArgsConstructor
public class VentaDetalleController {

    private VentaDetalleRepository ventaDetalleRepository;

    @PostMapping("/save")
    public VentaDetalleEntity guardar(@RequestBody VentaDetalleEntity ventaDetalle){
        Long idventa = ventaDetalle.getVenta().getId();
        Long idProducto = ventaDetalle.getProducto().getId();

        Optional<VentaDetalleEntity> ventaDb = ventaDetalleRepository.findById(idventa);
        Optional<VentaDetalleEntity> productoDb = ventaDetalleRepository.findById(idProducto);

        if(ventaDb.isPresent() || productoDb.isPresent()){
            ventaDetalle.setVenta(ventaDetalle.getVenta());
            ventaDetalle.setProducto(ventaDetalle.getProducto());
            return ventaDetalleRepository.save(ventaDetalle);
        }


        return null;




    }

}
