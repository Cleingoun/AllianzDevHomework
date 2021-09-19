package at.sk.allianzdevhomework.Service;

import at.sk.allianzdevhomework.Model.City;
import at.sk.allianzdevhomework.Repository.CityRepository;
import com.sun.jdi.request.InvalidRequestStateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepo;

    public City create(String district, String city) {
        return cityRepo.save(new City(new Date(), district, city));
    }

    public City addCo2(City co2data) {
        if(!co2data.getCo2Data().isEmpty()&&!co2data.getCity().isEmpty()&&!co2data.getDistrict().isEmpty())
            return cityRepo.save(co2data);
        throw new InvalidRequestStateException();
    }


    public List<City> getCO2ofDistrict(String districtName) {
        return cityRepo.findByDistrict(districtName);
    }

    public List<City> getCO2ofCity(String districtName) {
        return cityRepo.findByCity(districtName);
    }
}
