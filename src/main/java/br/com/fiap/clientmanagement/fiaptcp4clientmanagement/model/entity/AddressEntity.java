package br.com.fiap.clientmanagement.fiaptcp4clientmanagement.model.entity;

import br.com.fiap.clientmanagement.fiaptcp4clientmanagement.dto.AddressDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.UUID;

@Entity
@Table(name = "address")
@NoArgsConstructor
@Data
public class AddressEntity {

    @Id
    private UUID id;

    @Column
    private String street;

    @Column
    private String number;

    @Column
    private String complement;

    @Column
    private String neighborhood;

    @Column
    private String city;

    @Column
    private String province;

    @Column
    private String country;

    public AddressEntity(UUID id) {
        this.id = id;
    }

    public AddressDto toDto() {
        return new ModelMapper().map(this, AddressDto.class);
    }

    public AddressEntity toEntity(AddressDto dto) {
        return new ModelMapper().map(dto, AddressEntity.class);
    }

}
