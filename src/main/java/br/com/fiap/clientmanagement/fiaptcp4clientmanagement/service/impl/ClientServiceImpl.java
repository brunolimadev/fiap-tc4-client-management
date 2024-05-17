package br.com.fiap.clientmanagement.fiaptcp4clientmanagement.service.impl;

import br.com.fiap.clientmanagement.fiaptcp4clientmanagement.dto.ClientRequestDto;
import br.com.fiap.clientmanagement.fiaptcp4clientmanagement.dto.ClientResponseDto;
import br.com.fiap.clientmanagement.fiaptcp4clientmanagement.exceptions.ClientNotFoundException;
import br.com.fiap.clientmanagement.fiaptcp4clientmanagement.model.entity.ClientEntity;
import br.com.fiap.clientmanagement.fiaptcp4clientmanagement.repository.AddressRepository;
import br.com.fiap.clientmanagement.fiaptcp4clientmanagement.repository.ClientRepository;
import br.com.fiap.clientmanagement.fiaptcp4clientmanagement.service.ClientService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ClientResponseDto create(@Valid ClientRequestDto dto) {
        ClientEntity clientEntity = modelMapper.map(dto,ClientEntity.class);
        return clientRepository.save(clientEntity).toClientDto();
    }

    @Override
    public ClientResponseDto findById(UUID id) {
        Optional<ClientEntity> result = clientRepository.findById(id);
        return result.map(ClientEntity::toClientDto)
                .orElseThrow(() -> new ClientNotFoundException(id));
    }

    public List<ClientResponseDto> findAll() {
        return clientRepository.findAll()
                .stream()
                .map(c -> c.toClientDto())
                .collect(Collectors.toList());
    }

    @Override
    public void delete(UUID uuid) {
        clientRepository.delete(new ClientEntity(uuid));
    }

    @Override
    public void update(ClientRequestDto dto) {

        Optional<ClientEntity> client = clientRepository.findById(dto.getId());

        if (client.isPresent()) {
            ClientEntity updateCliente = new ClientEntity().toEntity(dto);
            clientRepository.save(updateCliente);
        } else {
            throw new ClientNotFoundException(dto.getId());
        }
    }
}
