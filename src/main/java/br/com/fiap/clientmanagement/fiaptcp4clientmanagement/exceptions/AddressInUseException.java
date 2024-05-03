package br.com.fiap.clientmanagement.fiaptcp4clientmanagement.exceptions;

import java.util.UUID;

public class AddressInUseException extends RuntimeException {
    public AddressInUseException(UUID id) {
        super("The address cannot be deleted as it is in use: " + id);
    }
}
