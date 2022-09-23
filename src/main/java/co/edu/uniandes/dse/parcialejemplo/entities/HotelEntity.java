
package co.edu.uniandes.dse.parcialejemplo.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

import uk.co.jemos.podam.common.PodamExclude;

/**
 * Clase que representa un equipo en la persistencia
 *
 * @author JuanQuiroga
 */

@Getter
@Setter
@Entity
public class HotelEntity extends BaseEntity {

    private String name;
    private String direccion;
    private Integer numeroEstrellas;

    @PodamExclude
    @OneToMany(mappedBy = "perteneceHotel")
    private List<HabitacionEntity> habitaciones = new ArrayList<>();
}