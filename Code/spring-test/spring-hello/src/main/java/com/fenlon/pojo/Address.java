package com.fenlon.pojo;

public class Address {

    private String Address;

    public void setAddress(String address) {
        Address = address;
    }

    public String getAddress() {
        return Address;
    }

    @Override
    public String toString() {
        return "Address{" +
                "Address='" + Address + '\'' +
                '}';
    }
}
