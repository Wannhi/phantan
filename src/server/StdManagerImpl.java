package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import enity.Diem;
import enity.LopHoc;
import enity.MonHoc;
import enity.SinhVien;

import dao.connect_data;
import dao.sinhvienDAO;
import dao.lophocDAO;
import dao.monhocDAO;
//import dao.diemDAO;

public class StdManagerImpl extends UnicastRemoteObject implements StdManagerInterface {
	private Connection connection;
	private sinhvienDAO sinhVienDAO;
    private lophocDAO lopHocDAO;
    private monhocDAO monHocDAO;
//    private diemDAO diemDAO;

	protected StdManagerImpl() throws RemoteException, ClassCastException, SQLException {
		try {
			connection = connect_data.getConnection();
			this.sinhVienDAO = new sinhvienDAO(connection);
        	this.monHocDAO = new monhocDAO(connection);
        	this.lopHocDAO = new lophocDAO(connection);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	private static final long serialVersionUID = 1L;

	@Override
	public List<SinhVien> getAllSinhVien() throws RemoteException {
		// TODO Auto-generated method stub
		return sinhVienDAO.getAllSinhVien();
	}

	@Override
	public List<SinhVien> getStudentByClass(String TenLop) throws RemoteException {
		// TODO Auto-generated method stub
		return sinhVienDAO.getStudentByClass(TenLop);
	}

	@Override
	public List<LopHoc> getAllLopHoc() throws RemoteException {
		// TODO Auto-generated method stub
		return lopHocDAO.getAllLopHoc();
	}


	@Override
	public List<MonHoc> getAllMonHoc() throws RemoteException {
		// TODO Auto-generated method stub
		return monHocDAO.getAllMonHoc();
	}

	@Override
	public SinhVien findSinhVien(int mssv) throws RemoteException {
		// TODO Auto-generated method stub
		return sinhVienDAO.findSinhVien(mssv);
	}

	@Override
	public LopHoc findLop(String maLop) throws RemoteException {
		// TODO Auto-generated method stub
		return lopHocDAO.findLop(maLop);
	}

	@Override
	public MonHoc findMonHoc(String maMh) throws RemoteException {
		// TODO Auto-generated method stub
		return monHocDAO.findMonHoc(maMh);
	}


	@Override
	public boolean addSinhVien(SinhVien sinhvien) throws RemoteException {
		// TODO Auto-generated method stub
		return sinhVienDAO.addSinhVien(sinhvien);
	}

	@Override
	public boolean addLopHoc(LopHoc lophoc) throws RemoteException {
		// TODO Auto-generated method stub
		return lopHocDAO.addLopHoc(lophoc);
	}

	@Override
	public boolean addMonHoc(MonHoc monhoc) throws RemoteException {
		// TODO Auto-generated method stub
		return monHocDAO.addMonHoc(monhoc);
	}


	@Override
	public boolean updateSinhVien(SinhVien sinhvien) throws RemoteException {
		// TODO Auto-generated method stub
		return addSinhVien(sinhvien);
	}

	@Override
	public boolean updateLopHoc(LopHoc lophoc) throws RemoteException {
		// TODO Auto-generated method stub
		return lopHocDAO.updateLopHoc(lophoc);
	}

	@Override
	public boolean updateMonHoc(MonHoc monhoc) throws RemoteException {
		// TODO Auto-generated method stub
		return monHocDAO.updateMonHoc(monhoc);
	}


	@Override
	public boolean deleteSinhVien(int mssv) throws RemoteException {
		// TODO Auto-generated method stub
		return sinhVienDAO.deleteSinhVien(mssv);
	}

	@Override
	public boolean deleteLopHoc(String Malop) throws RemoteException {
		// TODO Auto-generated method stub
		return monHocDAO.deleteMonHoc(Malop);
	}

	@Override
	public boolean deleteMonHoc(String MaMH) throws RemoteException {
		// TODO Auto-generated method stub
		return monHocDAO.deleteMonHoc(MaMH);
	}

	@Override
	public List<Diem> getAllDiem() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Diem findDiem(int mssv) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addDiem(Diem diem) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateDiem(Diem diem) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteDiem(int mssv) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}



}
