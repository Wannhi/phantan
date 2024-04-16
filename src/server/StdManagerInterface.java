package server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import object.Diem;
import object.LopHoc;
import object.MonHoc;
import object.SinhVien;

public interface StdManagerInterface extends Remote{
    //Đọc dữ liệu sinh viên
    List<SinhVien> getAllSinhVien() throws RemoteException;
    //Đọc dữ liệu lop hoc
    List<SinhVien> getStudentByClass(String TenLop) throws RemoteException;
    List<LopHoc> getAllLopHoc() throws RemoteException;
    //Doc du lieu diem
    List<Diem> getAllDiem() throws RemoteException;
    //Doc du lieu mon hoc
    List<MonHoc> getAllMonHoc () throws RemoteException;

    //Tim kiem sinh vien
    
    SinhVien findSinhVien(int mssv) throws RemoteException;
    //Tim kiem lop hoc
    LopHoc findLop(String maLop) throws RemoteException;
    //Tim kiem mon hoc
    MonHoc findMonHoc(String maMh) throws RemoteException;
    //Tim kiem diem
    Diem findDiem(int mssv) throws RemoteException;

    //Them sinh vien
    boolean addSinhVien(SinhVien sinhvien) throws RemoteException;
    //Them lop hoc
    boolean addLopHoc(LopHoc lophoc) throws RemoteException;
    //Them mon hoc
    boolean addMonHoc(MonHoc monhoc) throws RemoteException;
    //Them diem
    boolean addDiem(Diem diem) throws RemoteException;

    //Cap nhat sinh vien
    boolean updateSinhVien(SinhVien sinhvien) throws RemoteException;
    //Cap nhat lop hoc
    boolean updateLopHoc(LopHoc lophoc) throws RemoteException;
    //Cap nhat mon hoc
    boolean updateMonHoc(MonHoc monhoc) throws RemoteException;
    //Cap nhat diem
    boolean updateDiem(Diem diem) throws RemoteException;

    //Xoa sinh vien
    boolean deleteSinhVien(int mssv) throws RemoteException;
    //Xoa lop hoc
    boolean deleteLopHoc(String Malop) throws RemoteException;
    //Xoa mon hoc
    boolean deleteMonHoc(String MaMH) throws RemoteException;
    //Xoa diem
    boolean deleteDiem(int mssv) throws RemoteException;

}
