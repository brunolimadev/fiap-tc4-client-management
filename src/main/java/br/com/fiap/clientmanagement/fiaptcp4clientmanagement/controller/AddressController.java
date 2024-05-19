package br.com.fiap.clientmanagement.fiaptcp4clientmanagement.controller;

import br.com.fiap.clientmanagement.fiaptcp4clientmanagement.dto.AddressDto;
import br.com.fiap.clientmanagement.fiaptcp4clientmanagement.service.AddressService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/address")
@Tag(name = "Address Controller",
        description = "This service will be responsible for reading the customer's address data.")
public class AddressController {

    @Autowired
    private AddressService service;

    @Operation(summary = "Search all registered customer addresses")
    @GetMapping
    public ResponseEntity<List<AddressDto>> findAll() {
        List<AddressDto> addressDtos = service.findAll();
        return ResponseEntity.ok(addressDtos);
    }

    @Operation(summary = "Search Customer Address by Id")
    @GetMapping("/{uuid}")
    public ResponseEntity<AddressDto> findById(@PathVariable UUID uuid) {
        AddressDto addressDto = service.findById(uuid);
        return ResponseEntity.ok(addressDto);
    }
}
