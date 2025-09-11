package models;

public class Categorie {

    private int categoryID;
    private String categoryName;
    private String description;
    private String picture;

    public Categorie(){}

    public Categorie(int categoryID, String categoryName, String description, String picture) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        this.description = description;
        this.picture = picture;
    }



    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
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
