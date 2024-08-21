package Gestion_Clientes.GestionClientes.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Table(name = "cliente")
@Entity
@Getter
@Setter
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_id")
    private Long id;

    private String nombre;

    private String email;

    @OneToMany(mappedBy = "cliente")
    @JsonIgnore
    private List<VentaEntity> ventas;

}
