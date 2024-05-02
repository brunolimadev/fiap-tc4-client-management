package br.com.fiap.clientmanagement.fiaptcp4clientmanagement.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
public class ClientRequestDto {

    private UUID id;

    private String name;

    private String email;

    private UUID idAddress;

}
