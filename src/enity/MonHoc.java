package enity;

import java.io.Serializable;

public class MonHoc implements Serializable{
    private String maMh;
    private String tenMh;
    public MonHoc(String maMh, String tenMh) {
        this.maMh = maMh;
        this.tenMh = tenMh;
    }
    public String getMaMh() {
        return maMh;
    }
    public String getTenMh() {
        return tenMh;
    }
    public void setMaMh(String maMh) {
        this.maMh = maMh;
    }
    public void setTenMh(String tenMh) {
        this.tenMh = tenMh;
    }
    
}
