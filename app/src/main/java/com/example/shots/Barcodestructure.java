package com.example.shots;

public class Barcodestructure {


    private String BR;
    private String DATE;


    Barcodestructure(String BR,String Date){
        this.setBR(BR);
        this.setDATE(Date);

    }

    public String getBR() {
        return BR;
    }

    public void setBR(String br) {
        BR = br;
    }

    public String getDATE() {
        return DATE;
    }

    public void setDATE(String date) {
        DATE = date;
    }
}
