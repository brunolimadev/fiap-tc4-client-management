package br.com.fiap.clientmanagement.fiaptcp4clientmanagement.infra;

import br.com.fiap.clientmanagement.fiaptcp4clientmanagement.exceptions.AddressInUseException;
import br.com.fiap.clientmanagement.fiaptcp4clientmanagement.exceptions.ClientNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<RestErrorMessage> clientNotFoundErrorHandler(ClientNotFoundException e){
        RestErrorMessage restErrorMessage = new RestErrorMessage(HttpStatus.NOT_FOUND,e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(restErrorMessage);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<RestErrorMessage> runtimeErrorHandler(RuntimeException e){
        RestErrorMessage restErrorMessage = new RestErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(restErrorMessage);
    }

    @ExceptionHandler(AddressInUseException.class)
    public ResponseEntity<RestErrorMessage> addressInUseErrorHandler(AddressInUseException e){
        RestErrorMessage message = new RestErrorMessage(HttpStatus.BAD_REQUEST,e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
    }

}
