package com.example.baitap;

public class XucXac {

    private int icon1;
    private int icon2;
    private String ketqua;

    public String getKetqua() {
        return ketqua;
    }

    public void setKetqua(String ketqua) {
        this.ketqua = ketqua;
    }

    public int getIcon1() {
        return icon1;
    }

    public void setIcon1(int icon1) {
        this.icon1 = icon1;
    }

    public int getIcon2() {
        return icon2;
    }

    public void setIcon2(int icon2) {
        this.icon2 = icon2;
    }
    public XucXac() {
    }

    public XucXac(int icon1, int icon2, String ketqua) {
        this.icon1 = icon1;
        this.icon2 = icon2;
        this.ketqua = ketqua;
    }
}
