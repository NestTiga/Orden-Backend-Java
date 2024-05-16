package com.tignestor.articulos.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="articulos")
@Builder
public class Articulo {
    @Id
    @SequenceGenerator(
            name = "articulo_sequence",
            sequenceName = "articulo_sequence"
    )
    @GeneratedValue(
            generator = "articulo_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Long articId;

    private String codigo=generarCodigoUnico();

    @NotNull(message = "No se aceptan nulos en este campo")
    @NotBlank(message = "Este campo no puede ser vacío")
    private String nombre;

    @NotNull(message = "No se acepta nulos en este campo")
    @DecimalMin(value = "0.0", inclusive = false, message = "El precio debe ser mayor que 0")
    @DecimalMax(value = "1000.0", inclusive = false, message = "El precio debe ser menor que 1000")
    private double precio;


    public String generarCodigoUnico(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
