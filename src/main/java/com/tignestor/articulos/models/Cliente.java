package com.tignestor.articulos.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="clientes")
@Builder
public class Cliente {

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
