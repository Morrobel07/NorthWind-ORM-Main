package models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.*;

import java.time.LocalDate;


@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonDeserialize
@JsonPOJOBuilder(withPrefix = "")
public class Order {

    private Integer orderID;
    private Customer customersID;
    private Employee employeeID;
    private LocalDate orderDate;
    private LocalDate requiredDate;
    private LocalDate shippedDate;
    private Shipper shipVia;
    private double freight;
    private String shipName;
    private String shipAddress;
    private String shipCity;
    private String shipRegion;
    private String shipPostalCode;
    private String shipCountry;
    
    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", customerID=" +  (customersID != null ? customersID.getCustomerID() : "null")  +
                ", employeeID=" + ( employeeID != null ? employeeID.getEmployeeID() : "null") +
                ", orderDate=" + orderDate +
                ", requiredDate=" + requiredDate +
                ", shippedDate=" + shippedDate +
                ", shipperID=" + (shipVia != null ? shipVia.getShipperID() : "null") +
                ", freight=" + freight +
                ", shipName='" + shipName +
                ", shipAddress='" + shipAddress +
                ", shipCity='" + shipCity +
                ", shipRegion='" + shipRegion +
                ", shipPostalCode='" + shipPostalCode +
                ", shipCountry='" + shipCountry +
                '}';
    }

}
