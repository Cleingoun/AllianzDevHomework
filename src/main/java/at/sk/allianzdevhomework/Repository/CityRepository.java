package at.sk.allianzdevhomework.Repository;

import at.sk.allianzdevhomework.Model.City;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CityRepository extends CrudRepository<City, String> {

    List<City> findByDistrict(String district);

    List<City> findByCity(String city);
}
