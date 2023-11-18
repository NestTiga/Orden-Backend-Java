package com.tignestor.articulos.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cliente_id;
    @NotBlank(message = "Debe ingresar un nombre")
    private String nombre;
    @NotBlank(message = "Debe ingresar un apellido")
    private String apellido;

    @OneToMany(mappedBy = "cliente")
    List<Orden> ordens;

}
