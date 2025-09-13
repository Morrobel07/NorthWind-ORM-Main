package models;

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

    public Product(int productID, String productName, MySupplier supplierID, Categorie categoryID,
            String quantityPerUnit, double unitPrice, int unitsInStock, int unitsOnOrder, int reorderLevel,
            boolean discontinued) {
        this.productID = productID;
        this.productName = productName;
        this.supplierID = supplierID;
        this.categoryID = categoryID;
        this.quantityPerUnit = quantityPerUnit;
        this.unitPrice = unitPrice;
        this.unitsInStock = unitsInStock;
        this.unitsOnOrder = unitsOnOrder;
        this.reorderLevel = reorderLevel;
        this.discontinued = discontinued;

    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public MySupplier getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(MySupplier supplierID) {
        this.supplierID = supplierID;
    }

    public Categorie getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Categorie categoryID) {
        this.categoryID = categoryID;
    }

    public String getQuantityPerUnit() {
        return quantityPerUnit;
    }

    public void setQuantityPerUnit(String quantityPerUnit) {
        this.quantityPerUnit = quantityPerUnit;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getUnitsInStock() {
        return unitsInStock;
    }

    public void setUnitsInStock(int unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    public int getUnitsOnOrder() {
        return unitsOnOrder;
    }

    public void setUnitsOnOrder(int unitsOnOrder) {
        this.unitsOnOrder = unitsOnOrder;
    }

    public int getReorderLevel() {
        return reorderLevel;
    }

    public void setReorderLevel(int reorderLevel) {
        this.reorderLevel = reorderLevel;
    }

    public boolean isDiscontinued() {
        return discontinued;
    }

    public void setDiscontinued(boolean discontinued) {
        this.discontinued = discontinued;
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
