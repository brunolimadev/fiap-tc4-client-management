package br.com.fiap.clientmanagement.fiaptcp4clientmanagement.controller;

import br.com.fiap.clientmanagement.fiaptcp4clientmanagement.dto.ClientRequestDto;
import br.com.fiap.clientmanagement.fiaptcp4clientmanagement.dto.ClientResponseDto;
import br.com.fiap.clientmanagement.fiaptcp4clientmanagement.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@Validated
@RequestMapping("/clients")
@Tag(name = "Client Controller",
        description = "This service will be responsible for all customer-related operations" +
                      ", including creating, reading, updating and deleting customer records")
public class ClientController {

    @Autowired
    private ClientService service;

    @Operation(summary = "Search Customer by Id")
    @GetMapping("/{uuid}")
    public ResponseEntity<ClientResponseDto> findById(@PathVariable UUID uuid) {
        ClientResponseDto dto = service.findById(uuid);
        return ResponseEntity.ok(dto);
    }

    @Operation(summary = "Search all Customer")
    @GetMapping
    public ResponseEntity<List<ClientResponseDto>> findAll() {
    List<ClientResponseDto> dtoList = service.findAll();
        return ResponseEntity.ok(dtoList);
    }

    @Operation(summary = "Register Customer")
    @PostMapping
    public ResponseEntity<ClientResponseDto> save(@Valid @RequestBody ClientRequestDto dto) {
        ClientResponseDto responseDto = service.create(dto);
        return ResponseEntity.ok(responseDto);
    }

    @Operation(summary = "Update Customer")
    @PutMapping()
    public ResponseEntity<String> update(@Valid @RequestBody ClientRequestDto dto) {
            service.update(dto);
            return ResponseEntity.ok("Client updated successfully!");
    }

    @Operation(summary = "Delete Customer")
    @DeleteMapping("/{uuid}")
    public ResponseEntity<String> delete(@PathVariable UUID uuid) {
        service.delete(uuid);
        return ResponseEntity.ok("Customer deleted successfully!");
    }
}
