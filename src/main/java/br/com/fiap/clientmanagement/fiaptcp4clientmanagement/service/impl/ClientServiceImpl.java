package br.com.fiap.clientmanagement.fiaptcp4clientmanagement.service.impl;

import br.com.fiap.clientmanagement.fiaptcp4clientmanagement.dto.ClientRequestDto;
import br.com.fiap.clientmanagement.fiaptcp4clientmanagement.dto.ClientResponseDto;
import br.com.fiap.clientmanagement.fiaptcp4clientmanagement.exceptions.AddressNotFoundException;
import br.com.fiap.clientmanagement.fiaptcp4clientmanagement.exceptions.ClientNotFoundException;
import br.com.fiap.clientmanagement.fiaptcp4clientmanagement.model.entity.AddressEntity;
import br.com.fiap.clientmanagement.fiaptcp4clientmanagement.model.entity.ClientEntity;
import br.com.fiap.clientmanagement.fiaptcp4clientmanagement.repository.AddressRepository;
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
    private ClientRepository clientRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ClientResponseDto create(ClientRequestDto dto) {

        ClientEntity clientEntity = new ClientEntity();
        Optional<AddressEntity> addressDto = addressRepository.findById(dto.getIdAddress());

        if (addressDto.isEmpty()){
            throw new AddressNotFoundException(dto.getIdAddress());
        }

        clientEntity.setName(dto.getName());
        clientEntity.setEmail(dto.getEmail());
        clientEntity.setAddress(addressDto.get());

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
