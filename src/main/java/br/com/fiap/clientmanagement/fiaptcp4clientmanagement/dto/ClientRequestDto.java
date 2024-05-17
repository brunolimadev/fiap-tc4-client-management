package br.com.fiap.clientmanagement.fiaptcp4clientmanagement.dto;

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

    private UUID id;

    @NotEmpty(message = "name cannot be null")
    private String name;

    @Email(message = "email invalid")
    private String email;

    private AddressDto address;

}
