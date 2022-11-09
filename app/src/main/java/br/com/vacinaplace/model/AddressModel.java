package br.com.vacinaplace.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class AddressModel implements Serializable {
    @SerializedName("address1")
    @Expose
    private String address1 = "";
    @SerializedName("address2")
    @Expose
    private String address2 = "";
    @SerializedName("number")
    @Expose
    private String number = "";
    @SerializedName("neighborhood")
    @Expose
    private String neighborhood = "";
    @SerializedName("city")
    @Expose
    private String city = "";
    @SerializedName("state")
    @Expose
    private String state = "";
    @SerializedName("zipcode")
    @Expose
    private String zipcode = "";
    @SerializedName("complement")
    @Expose
    private String complement = "";

    public AddressModel() {
    }

    public AddressModel(String address1, String address2, String number, String neighborhood, String city, String state, String zipcode, String complement) {
        this.address1 = address1;
        this.address2 = address2;
        this.number = number;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.complement = complement;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

}
