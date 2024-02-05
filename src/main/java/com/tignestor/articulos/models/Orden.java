package com.tignestor.articulos.models;

import jakarta.persistence.*;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_orden_generator")
    @SequenceGenerator(name = "sq_orden_generator", sequenceName = "orden_sequence")
    private Long ordenId;

    private String codigoOrden=generarCodUnico();

    @NotNull(message = "No se acepta nulos en este campo")
    @FutureOrPresent(message = "La fecha debe ser igual a la actual o futura")
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
