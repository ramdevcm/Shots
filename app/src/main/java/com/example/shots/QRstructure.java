package com.example.shots;

public class QRstructure {

    private String QR;
    private String DATE;


    QRstructure(String QR,String Date){
        this.setQR(QR);
        this.setDATE(Date);

    }

    public String getQR() {
        return QR;
    }

    public void setQR(String qr) {
        QR = qr;
    }

    public String getDATE() {
        return DATE;
    }

    public void setDATE(String date) {
        DATE = date;
    }

}
