package com.tignestor.articulos.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="articulos")
public class Articulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long artic_id;

    private String codigo=generarCodigoJugador();

    @NotBlank(message = "Debe ingresar un nombre de producto")
    private String nombre;

    private double precio;

    @ManyToMany(mappedBy = "articulos")
    private Set<Orden> ordens = new HashSet<>();


    public String generarCodigoJugador(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
