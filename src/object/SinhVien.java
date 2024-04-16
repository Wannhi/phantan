package object;

import java.io.Serializable;

public class SinhVien implements Serializable{
    private int mssv;
    private String ten;
    private int namSinh;
    private String maLop;
    public SinhVien(int mssv, String ten, int namSinh, String maLop, String tenLop) {
		super();
		this.mssv = mssv;
		this.ten = ten;
		this.namSinh = namSinh;
		this.maLop = maLop;
		TenLop = tenLop;
	}
	public String getTenLop() {
		return TenLop;
	}
	public void setTenLop(String tenLop) {
		TenLop = tenLop;
	}
	private String TenLop;
    public SinhVien(int mssv, String ten, int namSinh, String maLop) {
        this.mssv = mssv;
        this.ten = ten;
        this.namSinh = namSinh;
        this.maLop = maLop;
    }
    public int getMssv() {
        return mssv;
    }
    public String getTen() {
        return ten;
    }
    public int getNamSinh() {
        return namSinh;
    }
    public String getMaLop() {
        return maLop;
    }
    public void setMssv(int mssv) {
        this.mssv = mssv;
    }
    public void setTen(String ten) {
        this.ten = ten;
    }
    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }
    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }
    
    
    

}
