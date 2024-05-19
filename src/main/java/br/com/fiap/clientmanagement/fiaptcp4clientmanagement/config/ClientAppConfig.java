package br.com.fiap.clientmanagement.fiaptcp4clientmanagement.config;

import br.com.fiap.clientmanagement.fiaptcp4clientmanagement.service.AddressService;
import br.com.fiap.clientmanagement.fiaptcp4clientmanagement.service.impl.AddressServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * This class represents the application configuration
 */
@Configuration
public class ClientAppConfig {

    @Bean
    public AddressService addressService(){
        return new AddressServiceImpl();
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }


}
