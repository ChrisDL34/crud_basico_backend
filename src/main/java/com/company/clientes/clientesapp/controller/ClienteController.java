package com.company.clientes.clientesapp.controller;

import com.company.clientes.clientesapp.exception.ResourceNotFoundException;
import com.company.clientes.clientesapp.model.Cliente;
import com.company.clientes.clientesapp.repository.IClienteRepository;
import com.company.clientes.clientesapp.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:3000/")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/clientes")
    public List<Cliente> obtenerClientes(){
        return  clienteService.obtenerClientes();
    }
 @PostMapping("/agregar")
    public Cliente guardarCliente(@RequestBody Cliente cliente){
        return clienteService.guardarCliente(cliente);
 }
 @GetMapping("/clientes/{id}")
    public ResponseEntity<Cliente> obtenerClientePorId(@PathVariable Long id){
        Cliente cliente = clienteService.buscarClienteById(id).orElseThrow(()-> new ResourceNotFoundException("el cliente con el id no existe: " + id));
        return ResponseEntity.ok(cliente);
 }

@PutMapping("/clientes/{id}")
    public ResponseEntity<Cliente> actualizarCliente(@PathVariable Long id, @RequestBody Cliente clienteRequest){
Cliente cliente = clienteService.buscarClienteById(id).orElseThrow(()-> new ResourceNotFoundException("el cliente con el id no existe: " + id));

cliente.setNombre(clienteRequest.getNombre());
cliente.setEmail(clienteRequest.getEmail());
cliente.setDescripcion(clienteRequest.getDescripcion());
cliente.setNumero(clienteRequest.getNumero());

Cliente clienteActualizado=clienteService.guardarCliente(cliente);
return  ResponseEntity.ok(clienteActualizado);

}

@DeleteMapping("/cliente{id}")
    public ResponseEntity<Map<String,Boolean>> eliminarCliente(@PathVariable Long id){
    Cliente cliente = clienteService.buscarClienteById(id)
            .orElseThrow(()-> new ResourceNotFoundException("el cliente con el id no existe: " + id));

    clienteService.eliminarCliente(cliente);
    Map<String,Boolean>response = new HashMap<>();
    return ResponseEntity.ok(response);
}

}
