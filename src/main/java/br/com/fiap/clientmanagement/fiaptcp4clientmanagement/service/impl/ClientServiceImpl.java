package br.com.fiap.clientmanagement.fiaptcp4clientmanagement.service.impl;

import br.com.fiap.clientmanagement.fiaptcp4clientmanagement.dto.ClientRequestDto;
import br.com.fiap.clientmanagement.fiaptcp4clientmanagement.dto.ClientResponseDto;
import br.com.fiap.clientmanagement.fiaptcp4clientmanagement.exceptions.ClientNotFoundException;
import br.com.fiap.clientmanagement.fiaptcp4clientmanagement.model.entity.ClientEntity;
import br.com.fiap.clientmanagement.fiaptcp4clientmanagement.repository.ClientRepository;
import br.com.fiap.clientmanagement.fiaptcp4clientmanagement.service.ClientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository repository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public void create(ClientRequestDto dto) {
        repository.save(new ClientEntity().toEntity(dto));
    }

    @Override
    public ClientResponseDto findById(UUID id) {
        Optional<ClientEntity> result = repository.findById(id);
        return result.map(ClientEntity::toClientDto)
                .orElseThrow(() -> new ClientNotFoundException(id));
    }

    public List<ClientResponseDto> findAll() {
        return repository.findAll()
                .stream()
                .map(c -> c.toClientDto())
                .collect(Collectors.toList());
    }

    @Override
    public void delete(UUID uuid) {
        repository.delete(new ClientEntity(uuid));
    }

    @Override
    public void update(ClientRequestDto dto) {
        Optional<ClientEntity> client = repository.findById(dto.getId());

        if (client.isPresent()) {
            ClientEntity clienteAtualizado = new ClientEntity().toEntity(dto);
            repository.save(clienteAtualizado);
        } else {
            throw new ClientNotFoundException(dto.getId());
        }
    }
}
