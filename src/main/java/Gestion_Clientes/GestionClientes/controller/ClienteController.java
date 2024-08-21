package Gestion_Clientes.GestionClientes.controller;

import Gestion_Clientes.GestionClientes.dao.ClienteRepository;
import Gestion_Clientes.GestionClientes.entity.ClienteEntity;
import Gestion_Clientes.GestionClientes.entity.ProductoEntity;
import Gestion_Clientes.GestionClientes.service.ClienteService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping("/save")
    public ClienteEntity guardar(@RequestBody  ClienteEntity cliente){
        return clienteService.saveCliente(cliente);
    }

    @GetMapping("/list")
    public List<ClienteEntity> listarClientes(){
        return clienteService.getAllClientes();
    }

    @GetMapping("/eliminar/{id}")
    public String deleteCliente(@PathVariable Long id, HttpSession session) {
        Boolean deleteCliente = clienteService.deleteCliente(id);
        if (deleteCliente) {
            session.setAttribute("succMsg", "Cliente delete success");
        } else {
            session.setAttribute("errorMsg", "Something wrong on server");
        }
        return "se elimino exitosamente";
    }

    @GetMapping("/listarPorId/{id}")
    ResponseEntity<ClienteEntity> buscarCliente(@PathVariable Long id){
        ClienteEntity respuestaService = clienteService.getClienteById(id);
        if(respuestaService != null){
            return ResponseEntity.ok().body(respuestaService);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

}
