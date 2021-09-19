package at.sk.allianzdevhomework.Controller;

import at.sk.allianzdevhomework.Model.City;
import at.sk.allianzdevhomework.Model.District;
import at.sk.allianzdevhomework.Service.CityService;
import com.sun.jdi.request.InvalidRequestStateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class CityController {
    @Autowired
    private CityService cityService;

    private final static String API = "/api";

    //ReciveCo2Data of district
    @RequestMapping(method = RequestMethod.GET, value = API + "/getCo2District")
    public List<City> getCO2District(@PathParam("district") String district) {
        List<City> co2data = cityService.getCO2ofDistrict(district);
        if (co2data.get(0).getCo2Data() == null)
            throw new InvalidRequestStateException();
        return co2data;
    }

    //ReciveCo2Data of City
    @RequestMapping(method = RequestMethod.GET, value = API + "/getCo2City")
    public List<City> getCO2City(@PathParam("city") String city) {
        List<City> co2data = cityService.getCO2ofDistrict(city);
        if (co2data.get(0).getCo2Data() == null)
            throw new InvalidRequestStateException();
        return co2data;
    }

    //send co2 data to server
    @RequestMapping(method = RequestMethod.POST, value = API + "/setCO2")
    public ResponseEntity<String> postCO2(@RequestBody City co2data) {
        try {
            cityService.addCo2(co2data);
            return ResponseEntity.status(HttpStatus.OK).body("The Data was added to the database");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("The Data had some mistakes.");
        }
    }

    //Create a District
    @RequestMapping(method = RequestMethod.POST, value = API + "/createDistrict")
    public ResponseEntity<String> createDistrict(@RequestBody District district) {
        try {
            cityService.create(district.getDistrict(), district.getCity());
            return ResponseEntity.status(HttpStatus.OK).body("The District was added to the database");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("The Data had some mistakes.");
        }
    }

}
