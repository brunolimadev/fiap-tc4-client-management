package br.com.fiap.clientmanagement.fiaptcp4clientmanagement.controller;

import br.com.fiap.clientmanagement.fiaptcp4clientmanagement.dto.AddressDto;
import br.com.fiap.clientmanagement.fiaptcp4clientmanagement.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService service;

    @GetMapping
    public ResponseEntity<List<AddressDto>> findAll() {
        List<AddressDto> addressDtos = service.findAll();
        return ResponseEntity.ok(addressDtos);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<AddressDto> findById(@PathVariable UUID uuid) {
        AddressDto addressDto = service.findById(uuid);
        return ResponseEntity.ok(addressDto);
    }
}
