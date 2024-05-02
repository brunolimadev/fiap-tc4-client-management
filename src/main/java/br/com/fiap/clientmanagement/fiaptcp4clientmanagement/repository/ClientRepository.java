package br.com.fiap.clientmanagement.fiaptcp4clientmanagement.repository;

import br.com.fiap.clientmanagement.fiaptcp4clientmanagement.model.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, UUID> {
}
