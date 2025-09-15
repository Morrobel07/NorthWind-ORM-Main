package models;

public class OrderDetails {

    private Order orderDetailsId;
    private Product productID;
    private double unitPrice;
    private int quantity;
    private double discount;

    public OrderDetails() {
    }

    private OrderDetails(Builder builder) {
        this.orderDetailsId = builder.orderDetailsId;
        this.productID = builder.productID;
        this.unitPrice = builder.unitPrice;
        this.quantity = builder.quantity;
        this.discount = builder.discount;
    }

    // Métodos getter y setter
    public Order getOrderID() {
        return orderDetailsId;
    }

    public void setOrderID(Order orderID) {
        this.orderDetailsId = orderID;
    }

    public static class Builder {
        private Order orderDetailsId;
        private Product productID;
        private double unitPrice;
        private int quantity;
        private double discount;

        public Builder orderID(Order orderDetailsId) {
            this.orderDetailsId = orderDetailsId;
            return this;
        }

        public Builder productID(Product productID) {
            this.productID = productID;
            return this;
        }

        public Builder unitPrice(double unitPrice) {
            this.unitPrice = unitPrice;
            return this;
        }

        public Builder quantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder discount(double discount) {
            this.discount = discount;
            return this;
        }

        public OrderDetails build() {
            return new OrderDetails(this);
        }
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
