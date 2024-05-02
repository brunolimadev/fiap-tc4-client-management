package br.com.fiap.clientmanagement.fiaptcp4clientmanagement.dto;

import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
public class ClientResponseDto {

    private UUID id;

    private String name;

    private String email;

    private AddressDto address;

}
