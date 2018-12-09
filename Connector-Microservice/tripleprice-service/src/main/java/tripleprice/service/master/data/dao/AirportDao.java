package tripleprice.service.master.data.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import tripleprice.service.master.data.model.AirportModel;

@Repository
public interface AirportDao extends PagingAndSortingRepository<AirportModel, Long> {
	
	@Query("from AirportModel where disabled = true")
	public long getAirport();
}
