package com.example.layouy_pj;

public class CauHoi {
    private String CauHoi;
    private String CauTL1;
    private String CauTL2;
    private  String CauTL3;
    private  String CauTL4;
    private String DapAn;

    public CauHoi(String cauHoi, String cauTL1, String cauTL2, String cauTL3, String cauTL4, String dapAn, String giaiThichDung, String giaiThichSai, int anhCauHoi) {
        CauHoi = cauHoi;
        CauTL1 = cauTL1;
        CauTL2 = cauTL2;
        CauTL3 = cauTL3;
        CauTL4 = cauTL4;
        DapAn = dapAn;
        GiaiThichDung = giaiThichDung;
        GiaiThichSai = giaiThichSai;
        AnhCauHoi = anhCauHoi;
    }

    private String GiaiThichDung;

    public String getGiaiThichDung() {
        return GiaiThichDung;
    }

    public void setGiaiThichDung(String giaiThichDung) {
        GiaiThichDung = giaiThichDung;
    }

    public String getGiaiThichSai() {
        return GiaiThichSai;
    }

    public void setGiaiThichSai(String giaiThichSai) {
        GiaiThichSai = giaiThichSai;
    }

    private String GiaiThichSai;
    private int AnhCauHoi;

    public CauHoi() {
    }

    public String getCauHoi() {
        return CauHoi;
    }

    public void setCauHoi(String cauHoi) {
        CauHoi = cauHoi;
    }

    public String getCauTL1() {
        return CauTL1;
    }

    public void setCauTL1(String cauTL1) {
        CauTL1 = cauTL1;
    }

    public String getCauTL2() {
        return CauTL2;
    }

    public void setCauTL2(String cauTL2) {
        CauTL2 = cauTL2;
    }

    public String getCauTL3() {
        return CauTL3;
    }

    public void setCauTL3(String cauTL3) {
        CauTL3 = cauTL3;
    }

    public String getCauTL4() {
        return CauTL4;
    }

    public void setCauTL4(String cauTL4) {
        CauTL4 = cauTL4;
    }

    public String getDapAn() {
        return DapAn;
    }

    public void setDapAn(String dapAn) {
        DapAn = dapAn;
    }
    public int getAnhCauHoi() {
        return AnhCauHoi;
    }

    public void setAnhCauHoi(int anhCauHoi) {
        AnhCauHoi = anhCauHoi;
    }
}
