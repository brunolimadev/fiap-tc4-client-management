package br.com.fiap.clientmanagement.fiaptcp4clientmanagement.dto;

import lombok.*;

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

    private String county;
}
