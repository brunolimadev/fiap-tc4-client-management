package br.com.fiap.clientmanagement.fiaptcp4clientmanagement.repository;

import br.com.fiap.clientmanagement.fiaptcp4clientmanagement.model.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AddressRepository extends JpaRepository<AddressEntity, UUID> {
}
