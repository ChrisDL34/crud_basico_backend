package com.company.clientes.clientesapp.service;

import com.company.clientes.clientesapp.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface IClienteService {
    public List<Cliente> obtenerClientes();
    public Cliente guardarCliente(Cliente cliente);
    public Optional<Cliente> buscarClienteById(Long id);

    public void eliminarCliente(Cliente cliente);
}
