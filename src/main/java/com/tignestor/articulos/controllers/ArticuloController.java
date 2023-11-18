package com.tignestor.articulos.controllers;

import com.tignestor.articulos.models.Articulo;
import com.tignestor.articulos.models.Cliente;
import com.tignestor.articulos.services.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/articulos")
@RestController
public class ArticuloController {
    @Autowired
    ArticuloService articuloService;
    @GetMapping
    public List<Articulo> listarArticulos(){
        return articuloService.obtenerArticulos();
    }
    @PostMapping
    public Articulo crearArticulo(@RequestBody Articulo articulo){
        
        return articuloService.crearArticulo(articulo);
    }
}
