package models;

public class Shipper {

    private Integer shipperID;
    private String companyName;
    private String phone;

    public Shipper() {
    }

    public Shipper(Builder builder) {

        this.shipperID = builder.shipperID;
        this.companyName = builder.companyName;
        this.phone = builder.phone;

    }

    public Integer getShipperID() {
        return shipperID;
    }

    public void setShipperID(int shipperID) {
        this.shipperID = shipperID;
    }

    public static class Builder {
        private int shipperID;
        private String companyName;
        private String phone;

        public Builder shipperID(int shipperID) {
            this.shipperID = shipperID;
            return this;
        }

        public Builder companyName(String companyName) {
            this.companyName = companyName;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Shipper build() {
            return new Shipper(this);
        }
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
