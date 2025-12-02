package com.example.Client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import com.example.Client.entities.*;
import com.example.Client.repositories.ClientRepository;

@EnableDiscoveryClient
@SpringBootApplication
public class ClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    // Ajoutez cette méthode pour insérer des données initiales
    @Bean
    CommandLineRunner initialiserBaseH2(ClientRepository clientRepository) {
        return args -> {
            clientRepository.save(new Client(null, "Rabab SELIMANI", 23f));
            clientRepository.save(new Client(null, "Amal RAMI", 22f));
            clientRepository.save(new Client(null, "Samir SAFI", 22f));
            System.out.println("✅ Données initiales insérées dans la base H2");
        };
    }
}
