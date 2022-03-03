package com.gerenciador_de_reserva;

import com.gerenciador_de_reserva.model.ReservaTipo;
import com.gerenciador_de_reserva.model.Capacidade;
import com.gerenciador_de_reserva.model.User;
import com.gerenciador_de_reserva.repos.CapacidadeRepository;
import com.gerenciador_de_reserva.repos.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class GerenciadorDeReservaApplication {

    private final Map<ReservaTipo, Integer> initialCapacities =
            new HashMap<>() {
                {
                    put(ReservaTipo.SAUNA, 4);
                    put(ReservaTipo.GYM, 1);
                    put(ReservaTipo.POOL, 12);
                }
            };

    public static void main(String[] args) {

        SpringApplication.run(GerenciadorDeReservaApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(
            UserRepository userRepository,
            CapacidadeRepository capacidadeRepository) {
        return (args) -> {
            userRepository.save(
                new User("Teste", "teste",
                        bCryptPasswordEncoder().encode("12345")));

            for (ReservaTipo reservaTipo : initialCapacities.keySet()) {
                capacidadeRepository.save(new Capacidade(reservaTipo, initialCapacities.get(reservaTipo)));
            }
        };
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {

        return new BCryptPasswordEncoder();
    }
}
