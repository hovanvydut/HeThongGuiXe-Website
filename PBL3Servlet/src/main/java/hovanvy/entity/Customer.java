package hovanvy.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author hovanvydut
 */

@Entity
@Table(name = "Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID_customer;
    private String fullname;
    private String student_id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String card_id;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Payment> payments = new HashSet<>();

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<ParkingHistory> parkingHistorys = new HashSet<>();

    public Customer() {
    }

    public Integer getID_customer() {
        return ID_customer;
    }

    public void setID_customer(Integer ID_customer) {
        this.ID_customer = ID_customer;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
    	if (fullname == null) {
    		this.fullname = fullname;
    	} else {
    		this.fullname = fullname.trim().replaceAll("\\s+", " ");
    	}
        
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    public Set<Payment> getPayments() {
        return payments;
    }

    public void setPayments(Set<Payment> payments) {
        this.payments = payments;
    }

    public Set<ParkingHistory> getParkingHistorys() {
        return parkingHistorys;
    }

    public void setParkingHistorys(Set<ParkingHistory> parkingHistorys) {
        this.parkingHistorys = parkingHistorys;
    }

    @Override
    public String toString() {
        return "Customer{" + "ID_customer=" + ID_customer + ", fullname=" + fullname + ", student_id=" + student_id + ", username=" + username + ", password=" + password + ", email=" + email + ", phone=" + phone + ", card_id=" + card_id + ", created_at=" + created_at + ", updated_at=" + updated_at + ", payments=" + payments + ", parkingHistorys=" + parkingHistorys + '}';
    }
  
}
