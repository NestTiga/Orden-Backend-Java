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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator", sequenceName = "my_sequence")
    private Long clienteId;

    @NotNull
    @NotBlank(message = "Debe ingresar un nombre")
    private String nombre;

    @NotNull
    @NotBlank(message = "Debe ingresar un apellido")
    private String apellido;

    @OneToMany(mappedBy = "cliente")
    @JsonIgnore
    List<Orden> ordenes;

}
