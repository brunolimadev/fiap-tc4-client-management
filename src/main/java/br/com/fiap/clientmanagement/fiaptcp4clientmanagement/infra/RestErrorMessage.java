package br.com.fiap.clientmanagement.fiaptcp4clientmanagement.infra;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
@Setter
public class RestErrorMessage {

    private HttpStatus httpStatus;

    private String message;
}
