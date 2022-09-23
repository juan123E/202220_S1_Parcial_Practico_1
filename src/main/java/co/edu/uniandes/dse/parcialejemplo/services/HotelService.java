package co.edu.uniandes.dse.parcialejemplo.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.parcialejemplo.entities.HotelEntity;
import co.edu.uniandes.dse.parcialejemplo.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.parcialejemplo.repositories.HotelRepository;
import lombok.extern.slf4j.Slf4j;




@Slf4j
@Service
public class HotelService {

    @Autowired
    HotelRepository hotelRepository;

    @Transactional
	public HotelEntity createEquipo(HotelEntity hotelEntity) throws IllegalOperationException {
        log.info("Inicia el proceso de crear un hotel");
        if (!hotelRepository.findByNombre(hotelEntity.getName()).isEmpty()) {
            throw new IllegalOperationException("Hotel name already exists");
            }
        if (hotelEntity.getNumeroEstrellas() < 2){
            throw new IllegalOperationException("The hotel has less that 2 stars");
        }

        if (hotelEntity.getNumeroEstrellas() > 6){
            throw new IllegalOperationException("The hotel has more than 6 stars");
        }

        return hotelRepository.save(hotelEntity);
	}

}
