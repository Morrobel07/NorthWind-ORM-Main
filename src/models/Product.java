package models;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = Product.Builder.class)
public class Product {

    private int productID;
    private String productName;
    private MySupplier supplierID;
    private Categorie categoryID;
    private String quantityPerUnit;
    private double unitPrice;
    private int unitsInStock;
    private int unitsOnOrder;
    private int reorderLevel;
    private boolean discontinued;

    public Product() {
    }

    private Product(Builder builder) {
        this.productID = builder.productID;
        this.productName = builder.productName;
        this.supplierID = builder.supplierID;
        this.categoryID = builder.categoryID;
        this.quantityPerUnit = builder.quantityPerUnit;
        this.unitPrice = builder.unitPrice;
        this.unitsInStock = builder.unitsInStock;
        this.unitsOnOrder = builder.unitsOnOrder;
        this.reorderLevel = builder.reorderLevel;
        this.discontinued = builder.discontinued;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    @JsonPOJOBuilder(withPrefix = "")
    public static class Builder {
        private int productID;
        private String productName;
        private MySupplier supplierID;
        private Categorie categoryID;
        private String quantityPerUnit;
        private double unitPrice;
        private int unitsInStock;
        private int unitsOnOrder;
        private int reorderLevel;
        private boolean discontinued;

        public Builder productID(int productID) {
            this.productID = productID;
            return this;
        }

        public Builder productName(String productName) {
            this.productName = productName;
            return this;
        }

        public Builder supplierID(MySupplier supplierID) {
            this.supplierID = supplierID;
            return this;
        }

        public Builder categoryID(Categorie categoryID) {
            this.categoryID = categoryID;
            return this;
        }

        public Builder quantityPerUnit(String quantityPerUnit) {
            this.quantityPerUnit = quantityPerUnit;
            return this;
        }

        public Builder unitPrice(double unitPrice) {
            this.unitPrice = unitPrice;
            return this;
        }

        public Builder unitsInStock(int unitsInStock) {
            this.unitsInStock = unitsInStock;
            return this;
        }

        public Builder unitsOnOrder(int unitsOnOrder) {
            this.unitsOnOrder = unitsOnOrder;
            return this;
        }

        public Builder reorderLevel(int reorderLevel) {
            this.reorderLevel = reorderLevel;
            return this;
        }

        public Builder discontinued(boolean discontinued) {
            this.discontinued = discontinued;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }

    @Override
    public String toString() {
        return "Product {\n" +
                "productID=" + productID + ",\n" +
                "productName=" + productName + ",\n" +
                "SuplierId=" + supplierID + ",\n" +
                "categoryId=" + categoryID + ",\n" +
                "quantityPerUnit=" + quantityPerUnit + ",\n" +
                "unitPrice=" + unitPrice + ",\n" +
                "unitsInStock=" + unitsInStock + ",\n" +
                "unitsOnOrder=" + unitsOnOrder + ",\n" +
                "reorderLevel=" + reorderLevel + ",\n" +
                "discontinued=" + discontinued + "\n" +
                "}";

    }

}
