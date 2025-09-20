package models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = Customer.Builder.class)
public class Customer {

    private int customerID;
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

    public Customer() {

    }

    private Customer(Builder builder) {
        this.customerID = builder.customerID;
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

    }

    public Integer getCustomerID() {
        return this.customerID;
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

    @JsonPOJOBuilder(withPrefix = "")
    public static class Builder {

        private int customerID;
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

        public Builder customerID(int customerID) {
            this.customerID = customerID;
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

        public Customer build() {
            return new Customer(this);
        }
    }

    @Override
    public String toString() {
        return "Customer {\n" +
                "  customerID=" + customerID + ",\n" +
                "  companyName='" + companyName + "',\n" +
                "  contactName='" + contactName + "',\n" +
                "  contactTitle='" + contactTitle + "',\n" +
                "  address='" + address + "',\n" +
                "  city='" + city + "',\n" +
                "  region='" + region + "',\n" +
                "  postalCode='" + postalCode + "',\n" +
                "  country='" + country + "',\n" +
                "  phone='" + phone + "',\n" +
                "  fax='" + fax + "'\n" +
                "}";
    }

}
