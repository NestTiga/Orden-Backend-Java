package com.tignestor.articulos.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="clientes")
@Builder
public class Customer {

    @Id
    @SequenceGenerator(
            name = "cliente_sequence",
            sequenceName = "cliente_sequence"
    )
    @GeneratedValue(
            generator = "cliente_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Long clienteId;

    @NotNull(message = "No se aceptan nulos en este campo")
    @NotBlank(message = "Este campo no puede ser vacío")
    private String nombre;

    @NotNull(message = "No se aceptan nulos en este campo")
    @NotBlank(message = "Este campo no puede ser vacío")
    private String apellido;


}
