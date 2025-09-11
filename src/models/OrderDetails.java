package models;

public class OrderDetails  {

    private Order orderDetailsId;
    private Product productID;
    private double unitPrice;
    private int quantity;
    private double discount;

    public OrderDetails(){}

    public OrderDetails(Order order, Product product, double unitPrice, int quantity, double discount) {
        this.orderDetailsId = order;
        this.productID = product;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.discount = discount;
    }

    // Métodos getter y setter
    public Order getOrderID() {
        return orderDetailsId;
    }

    public void setOrderID(Order orderID) {
        this.orderDetailsId = orderID;
    }

    public Product getProductID() {
        return productID;
    }

    public void setProductID(Product productID) {
        this.productID = productID;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "OrderDetails {\n" +
                "order=" + orderDetailsId + ",\n" +
                "product=" + productID + ",\n" +
                "unitPrice=" + unitPrice + ",\n" +
                "quantity=" + quantity + ",\n" +
                "discount=" + discount + "\n" +
                "}";
    }

   
}
