package com.technical_test.infrastructure.controllers;

import com.technical_test.application.port.ClientServicePort;
import com.technical_test.domain.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientServicePort clientServicePort;

    @Autowired
    public ClientController(ClientServicePort clientServicePort) {
        this.clientServicePort = clientServicePort;
    }

    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        Client createdClient = clientServicePort.createClient(client);
        return ResponseEntity.ok(createdClient);
    }

    @GetMapping
    public ResponseEntity<List<Client>> findAllClients() {
        List<Client> clients = clientServicePort.findAllClients();
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> findClientById(@PathVariable Long id) {
        Client client = clientServicePort.findClientById(id);
        return ResponseEntity.ok(client);
    }

    @PutMapping
    public ResponseEntity<Client> updateClient(@RequestBody  Client clientUpdate, @PathVariable Long id) {
        Client client = clientServicePort.updateClient(id, clientUpdate);
        return ResponseEntity.ok(client);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Client> deleteClientById(@PathVariable Long id) {
        clientServicePort.deleteClientById(id);
        return ResponseEntity.noContent().build();
    }
}
