package com.tignestor.articulos.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_articulo_generator")
    @SequenceGenerator(name = "sq_articulo_generator", sequenceName = "articulo_sequence")
    private Long articId;

    private String codigo=generarCodigoUnico();

    @NotNull(message = "No se aceptan nulos en este campo")
    @NotBlank(message = "Este campo no puede ser vacío")
    private String nombre;

    @NotNull(message = "No se acepta nulos en este campo")
    @DecimalMin(value = "0.0", inclusive = false, message = "El precio debe ser mayor que 0")
    @DecimalMax(value = "1000.0", inclusive = false, message = "El precio debe ser menor que 1000")
    private double precio;

    @ManyToMany(mappedBy = "articulos")
    @JsonIgnore
    private Set<Orden> ordenes = new HashSet<>();


    public String generarCodigoUnico(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
