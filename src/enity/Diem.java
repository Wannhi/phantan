
package enity;

import java.io.Serializable;

public class Diem implements Serializable{
    String tenSV;
    String TenMH;
    private int mssv;
    private String maMh;
    public Diem(String tenSV, String tenMH, float thuongKi, float giuaKi, float cuoiKi) {
		super();
		this.tenSV = tenSV;
		this.TenMH = tenMH;
		//this.mssv = mssv;
	//	this.maMh = maMh;
		this.thuongKi = thuongKi;
		this.giuaKi = giuaKi;
		this.cuoiKi = cuoiKi;
	}
	public String getTenSV() {
		return tenSV;
	}
	public void setTenSV(String tenSV) {
		this.tenSV = tenSV;
	}
	public String getTenMH() {
		return TenMH;
	}
	public void setTenMH(String tenMH) {
		TenMH = tenMH;
	}
	private float thuongKi;
    private float giuaKi;
    private float cuoiKi;
    public Diem(int mssv, String maMh, float thuongKi, float giuaKi, float cuoiKi) {
		super();
		this.mssv = mssv;
		this.maMh = maMh;
		this.thuongKi = thuongKi;
		this.giuaKi = giuaKi;
		this.cuoiKi = cuoiKi;
	}
	public int getMssv() {
		return mssv;
	}
	public void setMssv(int mssv) {
		this.mssv = mssv;
	}
	public String getMaMh() {
		return maMh;
	}
	public void setMaMh(String maMh) {
		this.maMh = maMh;
	}
	public float getThuongKi() {
		return thuongKi;
	}
	public void setThuongKi(float thuongKi) {
		this.thuongKi = thuongKi;
	}
	public float getGiuaKi() {
		return giuaKi;
	}
	public void setGiuaKi(float giuaKi) {
		this.giuaKi = giuaKi;
	}
	public float getCuoiKi() {
		return cuoiKi;
	}
	public void setCuoiKi(float cuoiKi) {
		this.cuoiKi = cuoiKi;
	}
}