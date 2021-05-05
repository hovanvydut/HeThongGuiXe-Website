package hovanvy.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author hovanvydut
 */

@Entity
@Table(name = "Parking_Package")
public class ParkingPackage {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID_package;
    
    private String name;
    private String desciption;
    private Integer price;
    private Integer duration;
    private Boolean is_visible;

    public ParkingPackage() {
    }

    public Integer getID_package() {
        return ID_package;
    }

    public void setID_package(Integer ID_package) {
        this.ID_package = ID_package;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Boolean getIs_visible() {
        return is_visible;
    }

    public void setIs_visible(Boolean is_visible) {
        this.is_visible = is_visible;
    }

    @Override
    public String toString() {
        return "ParkingPackage{" + "ID_package=" + ID_package + ", name=" + name + ", desciption=" + desciption + ", price=" + price + ", duration=" + duration + ", is_visible=" + is_visible + '}';
    }

}
