package co.edu.uniandes.dse.parcialejemplo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.parcialejemplo.entities.HabitacionEntity;
import co.edu.uniandes.dse.parcialejemplo.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.parcialejemplo.repositories.HabitacionRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class HabitacionService {

    @Autowired
    HabitacionRepository habitacionRepository;

    @Transactional
	public HabitacionEntity createHabitacion(HabitacionEntity habitacionEntity) throws IllegalOperationException {
        log.info("Inicia el proceso de crear un hotel");
        if (habitacionEntity.getNumeroBanos() <= habitacionEntity.getNumeroPersonas()){
            throw new IllegalOperationException("The room has more restroms than people");
        }

        return habitacionRepository.save(habitacionEntity);
	}

}

