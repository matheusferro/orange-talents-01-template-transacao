package br.com.zup.transacao.establishment;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstablishmentRepository extends JpaRepository<Establishment, Long> {
    Optional<Establishment> findByEstablishmentNameAndEstablishmentCityAndEstablishmentAddress(String name, String city, String address);
}
