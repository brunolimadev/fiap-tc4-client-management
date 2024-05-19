package br.com.fiap.clientmanagement.fiaptcp4clientmanagement.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
public class ClientResponseDto {

    @Schema(description = "uuid", example = "3fa85f64-5717-4562-b3fc-2c963f66afa6")
    private UUID id;

    @Schema(description = "name", example = "Astrogildo Fontoura do Carmo")
    private String name;

    @Schema(description = "email", example = "astrogildo@gmail.com")
    private String email;

    private AddressDto address;

}
