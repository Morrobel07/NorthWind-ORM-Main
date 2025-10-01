package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DefaultLocation {
    private String optionName;
    private String country;
    private String city;
    private String region;
    private String postalCode;
}
