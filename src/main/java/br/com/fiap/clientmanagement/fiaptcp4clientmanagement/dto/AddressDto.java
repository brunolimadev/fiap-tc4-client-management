package br.com.fiap.clientmanagement.fiaptcp4clientmanagement.dto;

import br.com.fiap.clientmanagement.fiaptcp4clientmanagement.model.entity.AddressEntity;
import jakarta.persistence.Id;
import lombok.*;
import org.modelmapper.ModelMapper;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AddressDto {

    private UUID id;

    private String street;

    private String number;

    private String complement;

    private String neighborhood;

    private String city;

    private String province;

    private String country;

    private String zipCode;

    public AddressEntity toEntity(){
        return new ModelMapper().map(this,AddressEntity.class);
    }

}
