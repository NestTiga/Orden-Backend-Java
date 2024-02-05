package com.tignestor.articulos.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="articulos")
public class Articulo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator", sequenceName = "my_sequence")
    private Long articId;

    private String codigo=generarCodigoJugador();

    @NotBlank(message = "Debe ingresar un nombre de producto")
    private String nombre;

    private double precio;

    @ManyToMany(mappedBy = "articulos")
    @JsonIgnore
    private Set<Orden> ordenes = new HashSet<>();


    public String generarCodigoJugador(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
