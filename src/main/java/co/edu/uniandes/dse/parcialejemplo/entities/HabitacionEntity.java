
package co.edu.uniandes.dse.parcialejemplo.entities;


import javax.persistence.Entity;


import javax.persistence.ManyToOne;


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
public class HabitacionEntity extends BaseEntity {

    private Long identificacion;
    private Integer numeroPersonas;
    private Integer numeroCamas;
    private Integer numeroBanos;

    @PodamExclude
    @ManyToOne
    private HotelEntity perteneceHotel;

}