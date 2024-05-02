package br.com.fiap.clientmanagement.fiaptcp4clientmanagement.service;

import br.com.fiap.clientmanagement.fiaptcp4clientmanagement.dto.ClientRequestDto;
import br.com.fiap.clientmanagement.fiaptcp4clientmanagement.dto.ClientResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface ClientService {

    public void create(ClientRequestDto dto);

    public ClientResponseDto findById(UUID id);

    public List<ClientResponseDto> findAll();

    public void delete(UUID uuid);

    public void update(ClientRequestDto dto);
}
