package com.example.uykaz.myapplication;

public class Ogrenci {
    public int resim;
    private String isimSoyisim;
    public String dogumTarihi;

    public Ogrenci(int resim, String isimSoyisim, String dogumTarihi) {
        this.resim = resim;
        this.isimSoyisim = isimSoyisim;
        this.dogumTarihi = dogumTarihi;
    }

    public String getIsimSoyisim() {
        return isimSoyisim;
    }

    public void setIsimSoyisim(String isimSoyisim) {
        this.isimSoyisim = isimSoyisim;
    }
}
