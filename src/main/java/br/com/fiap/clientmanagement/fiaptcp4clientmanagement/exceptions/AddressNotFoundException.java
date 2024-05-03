package br.com.fiap.clientmanagement.fiaptcp4clientmanagement.exceptions;

import java.util.UUID;

public class AddressNotFoundException extends RuntimeException {
    public AddressNotFoundException(UUID id) {
        super("Address id: " + id + " not found ");
    }
}
