package com.tignestor.articulos.controllers;

import com.tignestor.articulos.models.Articulo;
import com.tignestor.articulos.models.Orden;
import com.tignestor.articulos.services.OrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("api/ordenes")
@RestController
public class OrdenController {
    @Autowired
    OrdenService ordenService;


    @PostMapping("/crear")
    public ResponseEntity<Boolean> crearOrden(@RequestBody Orden orden){
        try {
            ordenService.crearOrden(orden);
            return ResponseEntity.status(HttpStatus.CREATED).body(Boolean.TRUE);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Boolean.FALSE);
        }
    }
}
