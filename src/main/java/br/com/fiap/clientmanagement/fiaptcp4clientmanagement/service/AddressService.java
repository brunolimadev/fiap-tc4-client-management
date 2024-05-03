package br.com.fiap.clientmanagement.fiaptcp4clientmanagement.service;

import br.com.fiap.clientmanagement.fiaptcp4clientmanagement.dto.AddressDto;

import java.util.List;
import java.util.UUID;

public interface AddressService {

    public void create(AddressDto dto);

    public AddressDto findById(UUID id);

    public List<AddressDto> findAll();

    public void delete(UUID id);

    public void update(AddressDto dto);
}
