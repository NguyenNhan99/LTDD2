package tdc.edu.vn.test;

public class Song {
    private String tenBH;
    private String loiBH;
    private int hinhA;
    private int File;

    public Song(String tenBH, String loiBH, int hinhA, int file) {
        this.tenBH = tenBH;
        this.loiBH = loiBH;
        this.hinhA = hinhA;
        File = file;
    }

    public String getTenBH() {
        return tenBH;
    }

    public void setTenBH(String tenBH) {
        this.tenBH = tenBH;
    }

    public String getLoiBH() {
        return loiBH;
    }

    public void setLoiBH(String loiBH) {
        this.loiBH = loiBH;
    }

    public int getHinhA() {
        return hinhA;
    }

    public void setHinhA(int hinhA) {
        this.hinhA = hinhA;
    }

    public int getFile() {
        return File;
    }

    public void setFile(int file) {
        File = file;
    }
    //    public Song(String tenBH, int hinhA, int file) {
//        this.tenBH = tenBH;
//        this.hinhA = hinhA;
//        File = file;
//    }
//
//    public void setTenBH(String tenBH) {
//        this.tenBH = tenBH;
//    }
//
//    public void setHinhA(int hinhA) {
//        this.hinhA = hinhA;
//    }
//
//    public void setFile(int file) {
//        File = file;
//    }
//
//    public String getTenBH() {
//        return tenBH;
//    }
//
//    public int getHinhA() {
//        return hinhA;
//    }
//
//    public int getFile() {
//        return File;
//    }
}
