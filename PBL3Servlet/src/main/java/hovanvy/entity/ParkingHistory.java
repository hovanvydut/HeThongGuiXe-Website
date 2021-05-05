package hovanvy.entity;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author hovanvydut
 */

@Entity
@Table(name = "Parking_History")
public class ParkingHistory {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID_parking;
    private String license_plate;
    private LocalDateTime check_in_at;
    private LocalDateTime check_out_at;
    private Boolean is_payment;
    private Integer price;
    
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public ParkingHistory() {
    }

    public Integer getID_parking() {
        return ID_parking;
    }

    public void setID_parking(Integer ID_parking) {
        this.ID_parking = ID_parking;
    }

    public String getLicense_plate() {
        return license_plate;
    }

    public void setLicense_plate(String license_plate) {
        this.license_plate = license_plate;
    }

    public LocalDateTime getCheck_in_at() {
        return check_in_at;
    }

    public void setCheck_in_at(LocalDateTime check_in_at) {
        this.check_in_at = check_in_at;
    }

    public LocalDateTime getCheck_out_at() {
        return check_out_at;
    }

    public void setCheck_out_at(LocalDateTime check_out_at) {
        this.check_out_at = check_out_at;
    }

    public Boolean getIs_payment() {
        return is_payment;
    }

    public void setIs_payment(Boolean is_payment) {
        this.is_payment = is_payment;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "ParkingHistory{" + "ID_parking=" + ID_parking + ", license_plate=" + license_plate + ", check_in_at=" + check_in_at + ", check_out_at=" + check_out_at + ", is_payment=" + is_payment + ", price=" + price + '}';
    }

}
