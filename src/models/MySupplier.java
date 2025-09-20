package models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = MySupplier.Builder.class)
public class MySupplier {

    private int supplierID;
    private String companyName;
    private String contactName;
    private String contactTitle;
    private String address;
    private String city;
    private String region;
    private String postalCode;
    private String country;
    private String phone;
    private String fax;
    private String homePage;

    public MySupplier() {
    }

    private MySupplier(Builder builder) {
        this.supplierID = builder.supplierID;
        this.companyName = builder.companyName;
        this.contactName = builder.contactName;
        this.contactTitle = builder.contactTitle;
        this.address = builder.address;
        this.city = builder.city;
        this.region = builder.region;
        this.postalCode = builder.postalCode;
        this.country = builder.country;
        this.phone = builder.phone;
        this.fax = builder.fax;
        this.homePage = builder.homePage;
    }

    public Integer getSupplierID() {
        return supplierID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getContactName() {
        return contactName;
    }

    public String getContactTitle() {
        return contactTitle;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getRegion() {
        return region;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCountry() {
        return country;
    }

    public String getPhone() {
        return phone;
    }

    public String getFax() {
        return fax;
    }

    public String getHomePage() {
        return homePage;
    }

    @JsonPOJOBuilder(withPrefix = "")
    public static class Builder {
        private int supplierID;
        private String companyName;
        private String contactName;
        private String contactTitle;
        private String address;
        private String city;
        private String region;
        private String postalCode;
        private String country;
        private String phone;
        private String fax;
        private String homePage;

        public Builder supplierID(int supplierID) {
            this.supplierID = supplierID;
            return this;
        }

        public Builder companyName(String companyName) {
            this.companyName = companyName;
            return this;
        }

        public Builder contactName(String contactName) {
            this.contactName = contactName;
            return this;
        }

        public Builder contactTitle(String contactTitle) {
            this.contactTitle = contactTitle;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder region(String region) {
            this.region = region;
            return this;
        }

        public Builder postalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Builder country(String country) {
            this.country = country;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder fax(String fax) {
            this.fax = fax;
            return this;
        }

        public Builder homePage(String homePage) {
            this.homePage = homePage;
            return this;
        }

        public MySupplier build() {
            return new MySupplier(this);
        }
    }

    @Override
    public String toString() {
        return "Supplier{\n" +
                "supplierID=" + supplierID + ",\n" +
                "companyName=" + companyName + ",\n" +
                "contactName=" + contactName + ",\n" +
                "contactTitle=" + contactTitle + ",\n" +
                "address=" + address + ",\n" +
                "city=" + city + "',\n" +
                "region=" + region + ",\n" +
                "postalCode=" + postalCode + "',\n" +
                "country=" + country + ",\n" +
                "phone=" + phone + ",\n" +
                "fax=" + fax + ",\n" +
                "homePage=" + homePage + "\n" +
                "}";

    }

}
