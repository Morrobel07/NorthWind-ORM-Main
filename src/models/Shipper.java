package models;

public class Shipper  {

    private int shipperID;
    private String companyName;
    private String phone;

    public Shipper(){}

    public Shipper(int shipperID, String companyName, String phone) {

        this.shipperID = shipperID;
        this.companyName = companyName;
        this.phone = phone;

    }

    public int getShipperID() {
        return shipperID;
    }

    public void setShipperID(int shipperID) {
        this.shipperID = shipperID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Shipper {\n" +
                "shipperID=" + shipperID + ",\n" +
                "companyName=" + companyName + ",\n" +
                "phone=" + phone + "\n" +
                "}";
    }

 
}
