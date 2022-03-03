package com.gerenciador_de_reserva.repos;

import com.gerenciador_de_reserva.model.ReservaTipo;
import com.gerenciador_de_reserva.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    List<Reserva> findReservaByReservaTipo(ReservaTipo reservaTipo);

    List<Reserva> findReservasByReservaDateAndStartTimeBeforeAndEndTimeAfterOrStartTimeBetween(
            LocalDate reservaDate, LocalTime startTime, LocalTime endTime,
            LocalTime betweenStart, LocalTime betweenEnd);
}
