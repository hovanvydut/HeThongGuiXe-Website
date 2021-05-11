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
@Table(name = "Payment")
public class Payment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID_payment;
    private String description;
    private LocalDateTime paid_at;
    private LocalDateTime start_date;
    private LocalDateTime end_date;
    private Integer price;
    
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Payment() {
    }

    public Integer getID_payment() {
        return ID_payment;
    }

    public void setID_payment(Integer ID_payment) {
        this.ID_payment = ID_payment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getPaid_at() {
        return paid_at;
    }

    public void setPaid_at(LocalDateTime paid_at) {
        this.paid_at = paid_at;
    }

    public LocalDateTime getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDateTime start_date) {
        this.start_date = start_date;
    }

    public LocalDateTime getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalDateTime end_date) {
        this.end_date = end_date;
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
        return "Payment{" + "ID_payment=" + ID_payment + ", description=" + description + ", paid_at=" + paid_at + ", start_date=" + start_date + ", end_date=" + end_date + ", price=" + price + '}';
    }
}
