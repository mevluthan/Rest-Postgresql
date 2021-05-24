package com.example.product;


public class Kullanici {

    private int id;
    private String isim;
    private String soyisim;
    private int no;
    private String yetki;

    public Kullanici(){

    }
    public Kullanici(int id) {
        this.id = id;
    }

    public Kullanici(int id, String isim, String soyisim, int no, String yetki) {
        this.id = id;
        this.isim = isim;
        this.soyisim = soyisim;
        this.no = no;
        this.yetki = yetki;
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSoyisim() {
        return soyisim;
    }

    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getYetki() {
        return yetki;
    }

    public void setYetki(String yetki) {
        this.yetki = yetki;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Kullanici other = (Kullanici) obj;
        if (id != other.id)
            return false;
        return true;
    }
}