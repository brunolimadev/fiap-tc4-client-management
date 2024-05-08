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
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping("/{uuid}")
    public ResponseEntity<ClientResponseDto> findById(@PathVariable UUID uuid) {
        ClientResponseDto dto = service.findById(uuid);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<ClientResponseDto>> findAll() {
    List<ClientResponseDto> dtoList = service.findAll();
        return ResponseEntity.ok(dtoList);
    }

    @PostMapping
    public ResponseEntity<ClientResponseDto> save(@RequestBody ClientRequestDto dto) {
        ClientResponseDto responseDto = service.create(dto);
        return ResponseEntity.ok(responseDto);
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
