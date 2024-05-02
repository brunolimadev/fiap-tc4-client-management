package br.com.fiap.clientmanagement.fiaptcp4clientmanagement.model.entity;

import br.com.fiap.clientmanagement.fiaptcp4clientmanagement.dto.AddressDto;
import jakarta.persistence.*;
import lombok.Data;
import org.modelmapper.ModelMapper;

import java.util.UUID;

@Entity
@Table(name = "address")
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

    public AddressDto toDto(){
       return new  ModelMapper().map(this,AddressDto.class);
    }

    public AddressEntity toEntity(AddressDto dto){
        return new ModelMapper().map(dto,AddressEntity.class);
    }

}
