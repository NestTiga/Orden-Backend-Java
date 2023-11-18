package com.tignestor.articulos.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="ordenes")
public class Orden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ordenId;

    private String codigoOrden=generarCodUnico();

    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "clienteId")
    private Cliente cliente;

    @ManyToMany
    @JoinTable(
            name = "ordenArticulo",
            joinColumns = @JoinColumn(name = "ordenId"),
            inverseJoinColumns = @JoinColumn(name = "articId")
    )
    private Set<Articulo> articulos = new HashSet<>();

    public String generarCodUnico(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
