package Gestion_Clientes.GestionClientes.controller;

import Gestion_Clientes.GestionClientes.dao.ClienteRepository;
import Gestion_Clientes.GestionClientes.dao.VentaRepository;
import Gestion_Clientes.GestionClientes.entity.ClienteEntity;
import Gestion_Clientes.GestionClientes.entity.VentaEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequestMapping("/api/venta")
public class VentaController {

    private VentaRepository ventaRepository;
    private ClienteRepository clienteRepository;

    public VentaController(VentaRepository ventaRepository,ClienteRepository clienteRepository) {
        this.ventaRepository = ventaRepository;
        this.clienteRepository = clienteRepository;
    }

    @PostMapping("/save")
    public VentaEntity guardar(@RequestBody VentaEntity venta){
        //VALIDAR SI EL CLIENTE EXISTE
        Long idcliente = venta.getCliente().getId();
        Optional<ClienteEntity> clienteBd = clienteRepository.findById(idcliente);
        if(clienteBd.isPresent()){
            venta.setCliente(clienteBd.get());
            return ventaRepository.save(venta);
        }
        return null;

    }

}
