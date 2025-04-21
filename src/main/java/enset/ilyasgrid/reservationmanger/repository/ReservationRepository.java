package enset.ilyasgrid.reservationmanger.repository;

import enset.ilyasgrid.reservationmanger.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {}

