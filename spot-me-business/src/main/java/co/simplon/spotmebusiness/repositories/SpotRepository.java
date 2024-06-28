package co.simplon.spotmebusiness.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.spotmebusiness.entities.Spot;

@Repository // Optional
public interface SpotRepository extends JpaRepository<Spot, Long> {
    //
}
