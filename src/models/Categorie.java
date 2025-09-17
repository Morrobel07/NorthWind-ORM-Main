package models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

//@JsonDeserialize(builder = Categorie.Builder.class)
public class Categorie {

    private int categoryID;
    private String categoryName;
    private String description;
    private String picture;

    private Categorie(Builder builder) {
        this.categoryID = builder.categoryID;
        this.categoryName = builder.categoryName;
        this.description = builder.description;
        this.picture = builder.picture;
    }



    public int getCategoryID() {
        return categoryID;
    }



    public static class Builder {
        private int categoryID;
        private String categoryName;
        private String description;
        private String picture;

        public Builder categoryID(int categoryID) {
            this.categoryID = categoryID;
            return this;
        }

        public Builder categoryName(String categoryName) {
            this.categoryName = categoryName;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder picture(String picture) {
            this.picture = picture;
            return this;
        }

        public Categorie build() {
            return new Categorie(this);
        }

    }

    @Override
    public String toString() {
        return "Categorie {\n" +
                "categoryId=" + categoryID + ",\n" +
                "categoryName='" + categoryName + "',\n" +
                "description='" + description + "',\n" +
                "picture='" + picture + "'\n" +
                "}";
    }

}
