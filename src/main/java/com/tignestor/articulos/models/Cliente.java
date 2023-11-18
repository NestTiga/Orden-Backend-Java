package com.tignestor.articulos.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clienteId;
    @NotBlank(message = "Debe ingresar un nombre")
    private String nombre;
    @NotBlank(message = "Debe ingresar un apellido")
    private String apellido;

    @OneToMany(mappedBy = "cliente")
    @JsonIgnore
    List<Orden> ordenes;

}
