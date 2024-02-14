package com.tignestor.articulos.controllers;

import com.tignestor.articulos.errors.NotFoundException;
import com.tignestor.articulos.models.Cliente;
import com.tignestor.articulos.services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @GetMapping("/listarClientes")
    public List<Cliente> listarClientes(){
        return clienteService.obtenerClientes();
    }
    @GetMapping("/clientePorId/{id}")
    public Cliente listarClientePorId(@PathVariable Long id) throws NotFoundException {
        return clienteService.obtenerPorId(id);
    }

    @GetMapping("/clientePorNombre/{name}")
    public Cliente listarClientePorNombre(@PathVariable String name) throws NotFoundException{
        return clienteService.encontrarPorNombre(name);
    }

    @PostMapping("/crearCliente")
    public ResponseEntity<Cliente> crearCliente(@Valid @RequestBody Cliente cliente){
        return ResponseEntity.status(HttpStatus.CREATED)
                    .body(clienteService.crearCliente(cliente));
    }

    @DeleteMapping("/eliminarClientePorId/{id}")
    public void eliminarCliente(@PathVariable("id") Long id){
        clienteService.eliminarCliente(id);
    }

    @PutMapping("/actualizarCliente")
    public Cliente actualizarCliente(@Valid @RequestBody Cliente cliente){
        return clienteService.actualizarCliente(cliente);
    }

}
