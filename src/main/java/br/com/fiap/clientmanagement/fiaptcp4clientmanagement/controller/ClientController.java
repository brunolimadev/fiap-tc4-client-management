package br.com.fiap.clientmanagement.fiaptcp4clientmanagement.controller;

import br.com.fiap.clientmanagement.fiaptcp4clientmanagement.dto.AddressDto;
import br.com.fiap.clientmanagement.fiaptcp4clientmanagement.dto.ClientDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/client-management/clients")
public class ClientController {


    @GetMapping("/{id}")
    public ResponseEntity<ClientDto> findById(@PathVariable UUID id) {
        //TODO ...
        return ResponseEntity.ok(null);
    }

    @GetMapping
    public ResponseEntity<ClientDto> findAll() {
        //TODO ...
        return ResponseEntity.ok(null);

    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody ClientDto dto) {
        //TODO ...
        return ResponseEntity.ok("Customer registered successfully!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable UUID uuid, @RequestBody ClientDto clientDto) {
        //TODO ...
        return ResponseEntity.ok("Client updated successfully!");
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@PathVariable UUID uuid) {
        //TODO ...
        return ResponseEntity.ok("Customer deleted successfully!");
    }

}
