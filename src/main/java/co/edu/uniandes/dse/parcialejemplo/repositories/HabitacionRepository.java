package co.edu.uniandes.dse.parcialejemplo.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.uniandes.dse.parcialejemplo.entities.HabitacionEntity;


@Repository
public interface HabitacionRepository extends JpaRepository<HabitacionEntity, Long> {    
}

