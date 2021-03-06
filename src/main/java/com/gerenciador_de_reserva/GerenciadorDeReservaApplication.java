package com.gerenciador_de_reserva;

import com.gerenciador_de_reserva.model.ReservaTipo;
import com.gerenciador_de_reserva.model.Capacidade;
import com.gerenciador_de_reserva.model.Reserva;
import com.gerenciador_de_reserva.model.User;
import com.gerenciador_de_reserva.repos.CapacidadeRepository;
import com.gerenciador_de_reserva.repos.UserRepository;
import com.gerenciador_de_reserva.repos.ReservaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class GerenciadorDeReservaApplication {

    private Map<ReservaTipo, Integer> initialCapacities =
            new HashMap<>() {
                {
                    put(ReservaTipo.SAUNA, 4);
                    put(ReservaTipo.SALA1, 1);
                    put(ReservaTipo.SALA2, 1);
                    put(ReservaTipo.CONDOMINIO, 1);
                    put(ReservaTipo.PISCINA, 7);
                    put(ReservaTipo.ACADEMIA, 12);
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
