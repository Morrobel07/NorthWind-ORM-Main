package models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.time.LocalDate;

@JsonDeserialize(builder = Employee.Builder.class)
public class Employee {

    private int employeeID;
    private String lastName;
    private String firstName;
    private String title;
    private String titleOfCourtesy;
    private LocalDate birthDate;
    private LocalDate hireDate;
    private String address;
    private String city;
    private String region;
    private String postalCode;
    private String country;
    private String homePhone;
    private String extension;
    private String photo;
    private String notes;
    private int reportsTo;
    private String photoPath;

    public Employee() {
        // Constructor sin argumentos para la inicialización en las pruebas
    }

    public Employee(Builder builder) {
        this.employeeID = builder.employeeID;
        this.lastName = builder.lastName;
        this.firstName = builder.firstName;
        this.title = builder.title;
        this.titleOfCourtesy = builder.titleOfCourtesy;
        this.birthDate = builder.birthDate;
        this.hireDate = builder.hireDate;
        this.address = builder.address;
        this.city = builder.city;
        this.region = builder.region;
        this.postalCode = builder.postalCode;
        this.country = builder.country;
        this.homePhone = builder.homePhone;
        this.extension = builder.extension;
        this.photo = builder.photo;
        this.notes = builder.notes;
        this.reportsTo = builder.reportsTo;
        this.photoPath = builder.photoPath;
    }

    public Integer getEmployeeID() {
        return employeeID;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getTitle() {
        return title;
    }

    public String getTitleOfCourtesy() {
        return titleOfCourtesy;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getHireDate() {
        return hireDate;
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

    public String getHomePhone() {
        return homePhone;
    }

    public String getExtension() {
        return extension;
    }

    public String getPhoto() {
        return photo;
    }

    public String getNotes() {
        return notes;
    }

    public int getReportsTo() {
        return reportsTo;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    @JsonPOJOBuilder(withPrefix = "")
    public static class Builder {

        private int employeeID;
        private String lastName;
        private String firstName;
        private String title;
        private String titleOfCourtesy;
        private LocalDate birthDate;
        private LocalDate hireDate;
        private String address;
        private String city;
        private String region;
        private String postalCode;
        private String country;
        private String homePhone;
        private String extension;
        private String photo;
        private String notes;
        private int reportsTo;
        private String photoPath;

        public Builder employeeID(int employeeID) {
            this.employeeID = employeeID;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder titleOfCourtesy(String titleOfCourtesy) {
            this.titleOfCourtesy = titleOfCourtesy;
            return this;
        }

        public Builder birthDate(LocalDate birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public Builder hireDate(LocalDate hireDate) {
            this.hireDate = hireDate;
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

        public Builder homePhone(String homePhone) {
            this.homePhone = homePhone;
            return this;
        }

        public Builder extension(String extension) {
            this.extension = extension;
            return this;
        }

        public Builder photo(String photo) {
            this.photo = photo;
            return this;
        }

        public Builder notes(String notes) {
            this.notes = notes;
            return this;
        }

        public Builder reportsTo(int reportsTo) {
            this.reportsTo = reportsTo;
            return this;
        }

        public Builder photoPath(String photoPath) {
            this.photoPath = photoPath;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }

    }

    @Override
    public String toString() {
        return "Employee {\n" +
                "  employeeID=" + employeeID + ",\n" +
                "  lastName='" + lastName + "',\n" +
                "  firstName='" + firstName + "',\n" +
                "  title='" + title + "',\n" +
                "  titleOfCourtesy='" + titleOfCourtesy + "',\n" +
                "  birthDate=" + birthDate + ",\n" +
                "  hireDate=" + hireDate + ",\n" +
                "  address='" + address + "',\n" +
                "  city='" + city + "',\n" +
                "  region='" + region + "',\n" +
                "  postalCode='" + postalCode + "',\n" +
                "  country='" + country + "',\n" +
                "  homePhone='" + homePhone + "',\n" +
                "  extension='" + extension + "',\n" +
                "  photo='" + photo + "',\n" +
                "  notes='" + notes + "',\n" +
                "  reportsTo=" + reportsTo + ",\n" +
                "  photoPath='" + photoPath + "'\n" +
                "}";
    }

}
