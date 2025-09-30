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
public class Categorie {

    private Integer categoryID;
    private String categoryName;
    private String description;
    private String picture;

}

