package at.sk.allianzdevhomework;

import at.sk.allianzdevhomework.Service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AllianzDevHomeworkApplication implements CommandLineRunner {

    @Autowired
    private CityService cityService;

    public static void main(String[] args) {
        SpringApplication.run(AllianzDevHomeworkApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        cityService.create("Gràcia", "Barcelona");
        cityService.create("Eixample", "Barcelona");
        cityService.create("Währing", "Wien");
        cityService.create("Penzing", "Wien");
        cityService.create("Maxvorstadt", "München");
    }
}
