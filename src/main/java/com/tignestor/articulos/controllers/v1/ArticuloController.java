package com.tignestor.articulos.controllers.v1;

import com.tignestor.articulos.model.entities.Articulo;
import com.tignestor.articulos.services.ArticuloService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/articulos")
@RestController
public class ArticuloController {
    @Autowired
    ArticuloService articuloService;
    @GetMapping
    public List<Articulo> listarArticulos(){
        return articuloService.obtenerArticulos();
    }
    @PostMapping
    public Articulo crearArticulo(@Valid @RequestBody Articulo articulo){
        
        return articuloService.crearArticulo(articulo);
    }
}
