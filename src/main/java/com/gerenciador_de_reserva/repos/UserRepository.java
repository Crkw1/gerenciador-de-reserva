package com.gerenciador_de_reserva.repos;

import com.gerenciador_de_reserva.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUsername(String username);
}