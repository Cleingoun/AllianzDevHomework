package at.sk.allianzdevhomework.Model;

import com.sun.istack.NotNull;
import lombok.NonNull;
import net.bytebuddy.implementation.bind.annotation.Empty;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "city")
public class City {

    @Id
    @NotNull
    private String district;

    @NotNull
    private String city;

    @NotNull
    private Date timestamp;

    private String co2Data;

    public City(Date date, String district, String city) {
        this.timestamp = date;
        this.district = district;
        this.city = city;
    }

    public City() {

    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCo2Data(String co2Data) {
        this.co2Data = co2Data;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getCity() {
        return city;
    }

    public String getCo2Data() {
        return co2Data;
    }

    public String getDistrict() {
        return district;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "City{" +
                "city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", timestamp=" + timestamp +
                ", co2Data='" + co2Data + '\'' +
                '}';
    }
}
