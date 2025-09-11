package models;

import java.time.LocalDate;

public class Order  {

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

    public Order (){}

    public Order(int orderID, Customer customersID, Employee employeeID, LocalDate orderDate,
            LocalDate requiredDate, LocalDate shippedDate, Shipper shipVia, double freight,
            String shipName, String shipAddress, String shipCity, String shipRegion, String shipPostalCode,
            String shipCountry) {
        this.orderID = orderID;
        this.customersID = customersID;
        this.employeeID = employeeID;
        this.orderDate = orderDate;
        this.requiredDate = requiredDate;
        this.shippedDate = shippedDate;
        this.shipVia = shipVia;
        this.freight = freight;
        this.shipName = shipName;
        this.shipAddress = shipAddress;
        this.shipCity = shipCity;
        this.shipRegion = shipRegion;
        this.shipPostalCode = shipPostalCode;
        this.shipCountry = shipCountry;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public Customer getCustomers() {
        return customersID;
    }

    public void setCustomers(Customer customersID) {
        this.customersID = customersID;
    }

    public Employee getEmployee() {
        return employeeID;
    }

    public void setEmployee(Employee employeeID) {
        this.employeeID = employeeID;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(LocalDate requiredDate) {
        this.requiredDate = requiredDate;
    }

    public LocalDate getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(LocalDate shippedDate) {
        this.shippedDate = shippedDate;
    }

    public Shipper getShipper() {
        return shipVia;
    }

    public void setShipper(Shipper shipVia) {
        this.shipVia = shipVia;
    }

    public double getFreight() {
        return freight;
    }

    public void setFreight(double freight) {
        this.freight = freight;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    public String getShipCity() {
        return shipCity;
    }

    public void setShipCity(String shipCity) {
        this.shipCity = shipCity;
    }

    public String getShipRegion() {
        return shipRegion;
    }

    public void setShipRegion(String shipRegion) {
        this.shipRegion = shipRegion;
    }

    public String getShipPostalCode() {
        return shipPostalCode;
    }

    public void setShipPostalCode(String shipPostalCode) {
        this.shipPostalCode = shipPostalCode;
    }

    public String getShipCountry() {
        return shipCountry;
    }

    public void setShipCountry(String shipCountry) {
        this.shipCountry = shipCountry;
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
