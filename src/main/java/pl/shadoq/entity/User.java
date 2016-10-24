package pl.shadoq.entity;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Jan on 2016-10-22.
 */

@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="firstName")
    private String firstName;

    @Column(name="middleName")
    private String middleName;

    @Column(name="lastName")
    private String lastName;

    @Column(name="sex")
    private Character sex;

    @Column(name="birth")
    private Date birth;

    @Column(name="pesel")
    private String pesel;

    @Column(name="city")
    private String city;

    @Column(name="address")
    private String address;

    @Column(name="zipCode")
    private String zipCode;

    @Column(name="state")
    private String state;

    @Column(name="phone")
    private String phone;

    @Column(name="country")
    private String country;

    @Column(name="numberBankAccount")
    private String numberBankAccount;

    @Column(name="height")
    private Integer height;

    @Column(name="weight")
    private Double weight;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Character getSex() {
        return sex;
    }

    public void setSex(Character sex) {
        this.sex = sex;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNumberBankAccount() {
        return numberBankAccount;
    }

    public void setNumberBankAccount(String numberBankAccount) {
        this.numberBankAccount = numberBankAccount;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }


    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return "Imie: " + firstName +
                "Drugie imie: " + middleName +
                "Nazwisko: " + lastName +
                "Plec: " + sex +
                "Adres: " + address +
                "Miasto: " + city +
                "Kod Pocztowy: " + zipCode +
                "Wojewodztwo: " + state +
                "Kraj: " + country +
                "Data urodzenia: " + dateFormat.format(birth) +
                "Pesel: " + pesel +
                "Numer Telefonu: " + phone +
                "Numer Konta: " + numberBankAccount +
                "Waga: " + weight +
                "Wzrost: " + height;
    }
}
