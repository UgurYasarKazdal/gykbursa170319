package com.example.uykaz.myapplication.models.malzemeler;

public class Konuk {
    private String ad;
    private int yas;
    private String dogumYeri;

    public Konuk(String ad, int yas, String dogumYeri) {
        this.ad = ad;
        this.yas = yas;
        this.dogumYeri = dogumYeri;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public int getYas() {
        return yas;
    }

    public void setYas(int yas) {
        this.yas = yas;
    }

    public String getDogumYeri() {
        return dogumYeri;
    }

    public void setDogumYeri(String dogumYeri) {
        this.dogumYeri = dogumYeri;
    }
}
