package tdc.edu.vn.test;

public class SoThich {
    public int icon;
    public String txtTen;
    public String txtSoThich;
    public String txtGT;

    public SoThich(){}

    public SoThich(int icon, String txtTen, String txtSoThich, String txtGT) {
        this.icon = icon;
        this.txtTen = txtTen;
        this.txtSoThich = txtSoThich;
        this.txtGT = txtGT;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getTxtTen() {
        return txtTen;
    }

    public void setTxtTen(String txtTen) {
        this.txtTen = txtTen;
    }

    public String getTxtSoThich() {
        return txtSoThich;
    }

    public void setTxtSoThich(String txtSoThich) {
        this.txtSoThich = txtSoThich;
    }

    public String getTxtGT() {
        return txtGT;
    }

    public void setTxtGT(String txtGT) {
        this.txtGT = txtGT;
    }
}
