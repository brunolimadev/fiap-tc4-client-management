package br.com.fiap.clientmanagement.fiaptcp4clientmanagement.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
public class ClientRequestDto {

    @NotEmpty(message = "name cannot be null")
    @Schema(description = "uuid", example = "3fa85f64-5717-4562-b3fc-2c963f66afa6")
    private UUID id;

    @Schema(description = "name", example = "Astrogildo Fontoura do Carmo")
    private String name;

    @Schema(description = "email", example = "astrogildo@gmail.com")
    @Email(message = "email invalid")
    private String email;

    private AddressDto address;

}
