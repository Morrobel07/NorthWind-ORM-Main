package models;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonDeserialize
@JsonPOJOBuilder(withPrefix = "")
public class OrderDetails {

    private Order orderDetailsId;
    private Product productID;
    private double unitPrice;
    private int quantity;
    private double discount;


}
