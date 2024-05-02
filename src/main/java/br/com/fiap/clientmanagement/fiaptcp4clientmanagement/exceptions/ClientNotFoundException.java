package br.com.fiap.clientmanagement.fiaptcp4clientmanagement.exceptions;

import java.util.UUID;

public class ClientNotFoundException extends RuntimeException{

    public ClientNotFoundException(UUID uuid) {
        super("customer not found with the specified id: " + uuid);
    }

}
