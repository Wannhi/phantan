package enity;

import java.io.Serializable;

public class LopHoc implements Serializable{
    private String maLop;
    private String tenLop;
    public LopHoc(String maLop, String tenLop) {
        this.maLop = maLop;
        this.tenLop = tenLop;
    }
    public String getMaLop() {
        return maLop;
    }
    public String getTenLop() {
        return tenLop;
    }
    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }
    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }
    
}
