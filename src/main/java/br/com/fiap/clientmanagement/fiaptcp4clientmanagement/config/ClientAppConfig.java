package br.com.fiap.clientmanagement.fiaptcp4clientmanagement.config;

import br.com.fiap.clientmanagement.fiaptcp4clientmanagement.service.ClientService;
import br.com.fiap.clientmanagement.fiaptcp4clientmanagement.service.impl.ClientServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * This class represents the application configuration
 */
@Configuration
public class ClientAppConfig {

    @Bean
    public ClientServiceImpl clientService(){
        return new ClientServiceImpl();
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }


}
