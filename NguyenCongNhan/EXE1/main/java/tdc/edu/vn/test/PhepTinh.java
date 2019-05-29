package tdc.edu.vn.test;

public class PhepTinh {
    public int icon;
    public String soA;
    public String soB;
    public String pT, kQ;

    public PhepTinh(){}

    public PhepTinh(int icon, String soA, String soB, String pT, String kQ) {
        this.icon = icon;
        this.soA = soA;
        this.soB = soB;
        this.pT = pT;
        this.kQ = kQ;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getSoA() {
        return soA;
    }

    public void setSoA(String soA) {
        this.soA = soA;
    }

    public String getSoB() {
        return soB;
    }

    public void setSoB(String soB) {
        this.soB = soB;
    }

    public String getpT() {
        return pT;
    }

    public void setpT(String pT) {
        this.pT = pT;
    }

    public String getkQ() {
        return kQ;
    }

    public void setkQ(String kQ) {
        this.kQ = kQ;
    }
}
