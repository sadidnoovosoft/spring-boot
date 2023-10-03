package com.example.springboot.ioc

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary

@Configuration
@ComponentScan(basePackages = ["com.example.springboot"])
class Config {
    @Bean
    fun address1(): Address {
        return Address("High Street", "Pune")
    }

    @Bean
    @Primary
    fun address2(): Address {
        return Address("New Street", "Solapur")
    }

    @Bean
    fun generalManager(): Manager {
        return GeneralManager()
    }
}