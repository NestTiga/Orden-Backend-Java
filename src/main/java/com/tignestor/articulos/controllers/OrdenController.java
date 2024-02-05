package com.tignestor.articulos.controllers;

import com.tignestor.articulos.models.Articulo;
import com.tignestor.articulos.models.Orden;
import com.tignestor.articulos.services.OrdenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/api/ordenes")
@RestController
public class OrdenController {
    @Autowired
    OrdenService ordenService;


    @GetMapping("/listar")
    public ResponseEntity<List<Orden>> listarOrdenes(){
        return ResponseEntity.status(HttpStatus.OK).body(ordenService.listarOrdenes());
    }

    @PostMapping("/crear")
    public ResponseEntity<Orden> guardarOrden(@Valid @RequestBody Orden orden){
        return ResponseEntity.status(HttpStatus.CREATED).body(ordenService.guardarOrden(orden));
    }
}
