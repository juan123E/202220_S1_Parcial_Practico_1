package co.edu.uniandes.dse.parcialejemplo.repositories;

import org.springframework.stereotype.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.uniandes.dse.parcialejemplo.entities.HotelEntity;


@Repository
public interface HotelRepository extends JpaRepository<HotelEntity, Long> {    
    Optional<HotelEntity>findByNombre(String nombre);
}

