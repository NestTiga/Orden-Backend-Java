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
@Entity
@Table(name="clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_cliente_generator")
    @SequenceGenerator(name = "sq_cliente_generator", sequenceName = "cliente_sequence")
    private Long clienteId;

    @NotNull(message = "No se aceptan nulos en este campo")
    @NotBlank(message = "Este campo no puede ser vacío")
    private String nombre;

    @NotNull(message = "No se aceptan nulos en este campo")
    @NotBlank(message = "Este campo no puede ser vacío")
    private String apellido;

    @OneToMany(mappedBy = "cliente")
    @JsonIgnore
    List<Orden> ordenes;

}
