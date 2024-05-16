package com.tignestor.articulos.controllers.v1;

import com.tignestor.articulos.errors.NotFoundException;
import com.tignestor.articulos.model.entities.Customer;
import com.tignestor.articulos.services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class CustomerController {
    @Autowired
    ClienteService clienteService;

    @GetMapping("/listarClientes")
    public List<Customer> listarClientes(){
        return clienteService.obtenerClientes();
    }
    @GetMapping("/clientePorId/{id}")
    public Customer listarClientePorId(@PathVariable Long id) throws NotFoundException {
        return clienteService.obtenerPorId(id);
    }

    @GetMapping("/clientePorNombre/{name}")
    public Customer listarClientePorNombre(@PathVariable String name) throws NotFoundException{
        return clienteService.encontrarPorNombre(name);
    }

    @PostMapping("/crearCliente")
    public ResponseEntity<Customer> crearCliente(@Valid @RequestBody Customer customer){
        return ResponseEntity.status(HttpStatus.CREATED)
                    .body(clienteService.crearCliente(customer));
    }

    @DeleteMapping("/eliminarClientePorId/{id}")
    public void eliminarCliente(@PathVariable("id") Long id){
        clienteService.eliminarCliente(id);
    }

    @PutMapping("/actualizarCliente")
    public Customer actualizarCliente(@Valid @RequestBody Customer customer){
        return clienteService.actualizarCliente(customer);
    }

}
