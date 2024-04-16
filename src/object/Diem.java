
package object;

import java.io.Serializable;

public class Diem implements Serializable{
    private int mssv;
    private String maMh;
    private float diem;
    public Diem(int mssv, String maMh, float diem) {
        this.mssv = mssv;
        this.maMh = maMh;
        this.diem = diem;
    }
    public int getMssv() {
        return mssv;
    }
    public String getMaMh() {
        return maMh;
    }
    public float getDiem() {
        return diem;
    }
    public void setMssv(int mssv) {
        this.mssv = mssv;
    }
    public void setMaMh(String maMh) {
        this.maMh = maMh;
    }
    public void setDiem(float diem) {
        this.diem = diem;
    }
    
}
