package Gestion_Clientes.GestionClientes.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Table(name = "venta_detalle")
@Entity
@Getter
@Setter
public class VentaDetalleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int cantidad;

    private float precio;

    @ManyToOne
    @JoinColumn(name = "venta_id")
    private VentaEntity venta;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private ProductoEntity producto;

}
