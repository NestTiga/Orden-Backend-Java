package com.tignestor.articulos.controllers;

import com.tignestor.articulos.models.Articulo;
import com.tignestor.articulos.models.Orden;
import com.tignestor.articulos.services.OrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/ordenes")
@RestController
public class OrdenController {
    @Autowired
    OrdenService ordenService;

    @PostMapping
    public ResponseEntity<Orden> crearOrden(@RequestBody Orden orden){

        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(ordenService.crearOrden(orden));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
