package br.com.fiap.clientmanagement.fiaptcp4clientmanagement.model.entity;

import br.com.fiap.clientmanagement.fiaptcp4clientmanagement.dto.ClientRequestDto;
import br.com.fiap.clientmanagement.fiaptcp4clientmanagement.dto.ClientResponseDto;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.UUID;

@Entity
@Table(name = "client")
@Data
@NoArgsConstructor
@Builder
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    private String name;

    @Column
    private String email;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address", referencedColumnName = "id")
    private AddressEntity address;

    public ClientResponseDto toClientDto(){
        return new ModelMapper().map(this, ClientResponseDto.class);
    }

    public ClientEntity toEntity(ClientRequestDto dto) {
        return new ModelMapper().map(dto, ClientEntity.class);
    }

    public ClientEntity(UUID id) {
        this.id = id;
    }

    public ClientEntity(UUID id, String name, String email, AddressEntity address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
    }
}

