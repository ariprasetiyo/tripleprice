package tripleprice.service.master.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * https://www.nationsonline.org/oneworld/IATA_Codes/airport_code_list.htm#A
 * @author ari.prasetiyo
 */
@Table(name = "T_MST_AIRPORT")
@Entity
public class AirportModel extends ModelEntity {

	private static final long serialVersionUID = -9070126373879712009L;

	@Column(name = "AIRPORT_CODE")
	String airportCode;
	
}
