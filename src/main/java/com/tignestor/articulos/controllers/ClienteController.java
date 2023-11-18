package com.tignestor.articulos.controllers;

import com.tignestor.articulos.models.Cliente;
import com.tignestor.articulos.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/clientes")
@RestController
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @GetMapping
    public List<Cliente> listarClientes(){

        return clienteService.obtenerClientes();
    }
    @PostMapping
    public Cliente crearCliente(@RequestBody Cliente cliente){
        return clienteService.crearCliente(cliente);
    }

    @DeleteMapping(value = "/{id}")
    public void eliminarCliente(@PathVariable("id") Long id){
        clienteService.eliminarCliente(id);
    }

    @PutMapping
    public Cliente actualizarCliente(@RequestBody Cliente cliente){
        return clienteService.actualizarCliente(cliente);
    }

}
