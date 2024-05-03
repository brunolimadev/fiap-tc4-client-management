package br.com.fiap.clientmanagement.fiaptcp4clientmanagement.controller;

import br.com.fiap.clientmanagement.fiaptcp4clientmanagement.dto.ClientRequestDto;
import br.com.fiap.clientmanagement.fiaptcp4clientmanagement.dto.ClientResponseDto;
import br.com.fiap.clientmanagement.fiaptcp4clientmanagement.service.ClientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/client-management/clients")
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponseDto> findById(@PathVariable UUID id) {
        ClientResponseDto dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<ClientResponseDto>> findAll() {
    List<ClientResponseDto> dtoList = service.findAll();
        return ResponseEntity.ok(dtoList);
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody ClientRequestDto dto) {
        service.create(dto);
        return ResponseEntity.ok("Customer registered successfully!");
    }

    @PutMapping()
    public ResponseEntity<String> update(@RequestBody ClientRequestDto dto) {
            service.update(dto);
            return ResponseEntity.ok("Client updated successfully!");
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<String> delete(@PathVariable UUID uuid) {
        service.delete(uuid);
        return ResponseEntity.ok("Customer deleted successfully!");
    }

}
