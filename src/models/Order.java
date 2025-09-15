package models;

import java.time.LocalDate;

public class Order {

    private int orderID;
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

    public Order() {
    }

    private Order(Builder builder) {
        this.orderID = builder.orderID;
        this.customersID = builder.customersID;
        this.employeeID = builder.employeeID;
        this.orderDate = builder.orderDate;
        this.requiredDate = builder.requiredDate;
        this.shippedDate = builder.shippedDate;
        this.shipVia = builder.shipVia;
        this.freight = builder.freight;
        this.shipName = builder.shipName;
        this.shipAddress = builder.shipAddress;
        this.shipCity = builder.shipCity;
        this.shipRegion = builder.shipRegion;
        this.shipPostalCode = builder.shipPostalCode;
        this.shipCountry = builder.shipCountry;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {

        //this.orderID = orderID;
    }

    public static class Builder {
        private int orderID;
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

        public Builder orderID(int orderID) {
            this.orderID = orderID;
            return this;
        }

        public Builder customersID(Customer customersID) {
            this.customersID = customersID;
            return this;
        }

        public Builder employeeID(Employee employeeID) {
            this.employeeID = employeeID;
            return this;
        }

        public Builder orderDate(LocalDate orderDate) {
            this.orderDate = orderDate;
            return this;
        }

        public Builder requiredDate(LocalDate requiredDate) {
            this.requiredDate = requiredDate;
            return this;
        }

        public Builder shippedDate(LocalDate shippedDate) {
            this.shippedDate = shippedDate;
            return this;
        }

        public Builder shipVia(Shipper shipVia) {
            this.shipVia = shipVia;
            return this;
        }

        public Builder freight(double freight) {
            this.freight = freight;
            return this;
        }

        public Builder shipName(String shipName) {
            this.shipName = shipName;
            return this;
        }

        public Builder shipAddress(String shipAddress) {
            this.shipAddress = shipAddress;
            return this;
        }

        public Builder shipCity(String shipCity) {
            this.shipCity = shipCity;
            return this;
        }

        public Builder shipRegion(String shipRegion) {
            this.shipRegion = shipRegion;
            return this;
        }

        public Builder shipPostalCode(String shipPostalCode) {
            this.shipPostalCode = shipPostalCode;
            return this;
        }

        public Builder shipCountry(String shipCountry) {
            this.shipCountry = shipCountry;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }

    @Override
    public String toString() {
        return "Order {\n" +
                "orderId=" + orderID + ",\n" +
                "customer=" + customersID + ",\n" +
                "employee=" + employeeID + ",\n" +
                "orderDate=" + orderDate + ",\n" +
                " requiereDate" + requiredDate + ",\n" +
                "shippedDate=" + shippedDate + ",\n" +
                "shipper=" + shipVia + ",\n" +
                "freight=" + freight + ",\n" +
                "shipName='" + shipName + "',\n" +
                "shipAddress='" + shipAddress + "',\n" +
                "shipCity='" + shipCity + "',\n" +
                "shipRegion='" + shipRegion + "',\n" +
                "shipostalcode" + shipPostalCode + "',\n" +
                "shipCountry='" + shipCountry + "'\n" +
                "}";
    }

}
