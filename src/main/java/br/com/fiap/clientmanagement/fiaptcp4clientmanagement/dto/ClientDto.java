package br.com.fiap.clientmanagement.fiaptcp4clientmanagement.dto;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class ClientDto {

    private UUID id;

    private String name;

    private String email;

    private AddressDto address;

}
