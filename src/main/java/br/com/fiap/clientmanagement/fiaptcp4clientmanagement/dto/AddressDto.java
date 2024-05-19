package br.com.fiap.clientmanagement.fiaptcp4clientmanagement.dto;

import br.com.fiap.clientmanagement.fiaptcp4clientmanagement.model.entity.AddressEntity;
import io.swagger.v3.oas.annotations.media.Schema;
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

    @Schema(description = "uuid", example = "3fa85f64-5717-4562-b3fc-2c963f66afa6")
    private UUID id;

    @Schema(description = "street", example = "Avenida Passos")
    private String street;

    @Schema(description = "number", example = "2560")
    private String number;

    @Schema(description = "complement", example = "Rua próxima a creche")
    private String complement;

    @Schema(description = "neighborhood", example = "Centro")
    private String neighborhood;

    @Schema(description = "city", example = "Rio de Janeiro")
    private String city;

    @Schema(description = "province", example = "RJ")
    private String province;

    @Schema(description = "country", example = "Brasil")
    private String country;

    @Schema(description = "zip-code", example = "26251350")
    private String zipCode;

    public AddressEntity toEntity(){
        return new ModelMapper().map(this,AddressEntity.class);
    }

}
