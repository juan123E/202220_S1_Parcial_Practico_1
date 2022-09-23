package co.edu.uniandes.dse.parcialejemplo.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import co.edu.uniandes.dse.parcialejemplo.entities.HabitacionEntity;
import co.edu.uniandes.dse.parcialejemplo.entities.HotelEntity;
import co.edu.uniandes.dse.parcialejemplo.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.parcialejemplo.exceptions.IllegalOperationException;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Transactional
@Import(HotelService.class)
public class HotelServiceTest {

    @Autowired
    private HotelService hotelService;
    @Autowired
    private TestEntityManager entityManager;

    private PodamFactory factory = new PodamFactoryImpl();

    private List<HotelEntity> hotelList = new ArrayList<>();
    private List<HabitacionEntity> habitacionList = new ArrayList<>();

    @BeforeEach
    void setUp(){
        clearData();
        insertData();
    }

    private void clearData(){
        entityManager.getEntityManager().createQuery("delete from HotelEntity");
        entityManager.getEntityManager().createQuery("delete from HabitacionEntity");
    }

    private void insertData(){
        for (int i = 0; i < 3; i++) {
            HotelEntity hotelEntity = factory.manufacturePojo(HotelEntity.class);
            entityManager.persist(hotelEntity);
            hotelList.add(hotelEntity);
    }
        for (int i = 0; i < 3; i++) {
            HabitacionEntity habitacionEntity = factory.manufacturePojo(HabitacionEntity.class);
            entityManager.persist(habitacionEntity);
            habitacionList.add(habitacionEntity);
    }
    }

    @Test
    void testCreateHotel() throws EntityNotFoundException, IllegalOperationException{
        HotelEntity newEntity = factory.manufacturePojo(HotelEntity.class);
        HotelEntity result = hotelService.createHotel(newEntity);
        assertNotNull(result);
        HotelEntity entity = entityManager.find(HotelEntity.class, result.getId());
        assertEquals(newEntity.getId(), entity.getId());
        assertEquals(newEntity.getName(), entity.getName());
        assertEquals(newEntity.getDireccion(), entity.getDireccion());
        assertEquals(newEntity.getNumeroEstrellas(), entity.getNumeroEstrellas());
    }
    @Test
    void testCreateHotelWithNoValidName() {
        assertThrows(IllegalOperationException.class, () -> {
                HotelEntity newEntity = factory.manufacturePojo(HotelEntity.class);
                newEntity.setName(hotelList.get(0).getName());
                hotelService.createHotel(newEntity);
        });
}

    @Test
    void testCreateHotelWithNoValidStars() {
        assertThrows(IllegalOperationException.class, () -> {
            HotelEntity newEntity = factory.manufacturePojo(HotelEntity.class);
            newEntity.setNumeroEstrellas(1);
            hotelService.createHotel(newEntity);
    });
}



}
