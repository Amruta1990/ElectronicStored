package com.amruta.happytech.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {
@Bean
    public ModelMapper modelmapper(){

    return  new ModelMapper();

}
}