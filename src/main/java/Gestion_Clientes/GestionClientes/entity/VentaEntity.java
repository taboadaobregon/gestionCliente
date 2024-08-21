package Gestion_Clientes.GestionClientes.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "ventas")
@Getter
@Setter
public class VentaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "venta_id")
    private Long id;
    private String fecha;
    private float total;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteEntity cliente;




}
