package com.tignestor.articulos.models;

import jakarta.persistence.*;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="ordenes")
@Builder
public class Orden {
    @Id
    @SequenceGenerator(
            name = "orden_sequence",
            sequenceName = "orden_sequence"
    )
    @GeneratedValue(
            generator = "orden_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Long ordenId;

    private String codigoOrden=generarCodUnico();

    @NotNull(message = "No se acepta nulos en este campo")
    @FutureOrPresent(message = "La fecha debe ser igual a la actual o futura")
    private Date fecha;

    @ManyToOne(
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "cliente_id",
            referencedColumnName = "clienteId"
    )
    private Cliente cliente;

    @ManyToMany(
            fetch = FetchType.EAGER
    )
    @JoinTable(
            name = "orden_articulo_map",
            joinColumns = @JoinColumn(name = "orden_id", referencedColumnName = "ordenId"),
            inverseJoinColumns = @JoinColumn(name = "articulo_id", referencedColumnName = "articId")
    )
    private List<Articulo> articuloList;

    public String generarCodUnico(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
