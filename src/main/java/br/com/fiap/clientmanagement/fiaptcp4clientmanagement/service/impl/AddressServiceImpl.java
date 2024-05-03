package br.com.fiap.clientmanagement.fiaptcp4clientmanagement.service.impl;

import br.com.fiap.clientmanagement.fiaptcp4clientmanagement.dto.AddressDto;
import br.com.fiap.clientmanagement.fiaptcp4clientmanagement.exceptions.AddressInUseException;
import br.com.fiap.clientmanagement.fiaptcp4clientmanagement.exceptions.AddressNotFoundException;
import br.com.fiap.clientmanagement.fiaptcp4clientmanagement.model.entity.AddressEntity;
import br.com.fiap.clientmanagement.fiaptcp4clientmanagement.repository.AddressRepository;
import br.com.fiap.clientmanagement.fiaptcp4clientmanagement.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository repository;

    @Override
    public void create(AddressDto dto) {
        repository.save(new AddressEntity().toEntity(dto));
    }

    @Override
    public AddressDto findById(UUID id) {
        Optional<AddressEntity> address = repository.findById(id);
        return address.map(AddressEntity::toDto).orElseThrow(() -> new AddressNotFoundException(id));
    }

    @Override
    public List<AddressDto> findAll() {
        return repository.findAll().stream().map(a -> a.toDto()).collect(Collectors.toList());
    }

    @Override
    public void delete(UUID id) {

        try {
            repository.delete(new AddressEntity(id));
        } catch (RuntimeException e) {
            throw new AddressInUseException(id);
        }
    }

    @Override
    public void update(AddressDto dto) {
        Optional<AddressEntity> address = repository.findById(dto.getId());

        if (address.isPresent()) {
            AddressEntity updateAddress = new AddressEntity().toEntity(dto);
            repository.save(updateAddress);
        } else {
            throw new AddressNotFoundException(dto.getId());
        }

    }
}
