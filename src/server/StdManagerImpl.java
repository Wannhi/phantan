package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import object.Diem;
import object.LopHoc;
import object.MonHoc;
import object.SinhVien;

public class StdManagerImpl extends UnicastRemoteObject implements StdManagerInterface {
    private Connection connection;

    protected StdManagerImpl() throws RemoteException, ClassCastException, SQLException {
        super();
        try {
            connection = connect_data.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<SinhVien> getAllSinhVien() throws RemoteException {
        List<SinhVien> svList = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM students join lop on students.Malop = lop.Malop ORDER BY mssv ASC");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                SinhVien sv = new SinhVien(rs.getInt("mssv"), rs.getString("name"), rs.getInt("year"), rs.getString("Malop"), rs.getString("lop.TenLop"));
                svList.add(sv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RemoteException("Error fetching students data.", e);
        }
        return svList;
    }
    @Override
    public List<SinhVien> getStudentByClass(String Tenlop) throws RemoteException {
        List<SinhVien> svList = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM students join lop on students.Malop = lop.Malop WHERE lop.TenLop LIKE ? ORDER BY mssv ASC");
            st.setString(1, Tenlop);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                SinhVien sv = new SinhVien(rs.getInt("mssv"), rs.getString("name"), rs.getInt("year"), rs.getString("Malop"), rs.getString("lop.TenLop"));
                svList.add(sv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RemoteException("Error fetching students data.", e);
        }
        return svList;
    }
    @Override
    public List<LopHoc> getAllLopHoc() throws RemoteException {
        List<LopHoc> lhList = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM lop");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                LopHoc lh = new LopHoc(rs.getString("MaLop"), rs.getString("TenLop"));
                lhList.add(lh);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RemoteException("Error fetching classes data.", e);
        }
        return lhList;
    }

 //   @Override
//    public List<Diem> getAllDiem() throws RemoteException {
//        List<Diem> dList = new ArrayList<>();
//        try {
//            PreparedStatement st = connection.prepareStatement("SELECT * FROM diem");
//            ResultSet rs = st.executeQuery();
//            while (rs.next()) {
//                Diem diem = new Diem(rs.getInt("mssv"), rs.getString("MaMh"), rs.getFloat("score"));
//                dList.add(diem);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            throw new RemoteException("Error fetching scores data.", e);
//        }
//        return dList;
//    }

    @Override
    public List<MonHoc> getAllMonHoc() throws RemoteException {
        List<MonHoc> mhList = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM monhoc");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                MonHoc mh = new MonHoc(rs.getString("MaMH"), rs.getString("TenMH"));
                mhList.add(mh);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RemoteException("Error fetching subjects data.", e);
        }
        return mhList;
    }

    @Override
    public SinhVien findSinhVien(int mssv) throws RemoteException {
        try {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM students WHERE mssv=?");
            st.setInt(1, mssv);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new SinhVien(rs.getInt("mssv"), rs.getString("name"), rs.getInt("year"), rs.getString("Malop"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RemoteException("Error finding student with ID: " + mssv, e);
        }
        return null;
    }

    @Override
    public LopHoc findLop(String maLop) throws RemoteException {
        try {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM lop WHERE Malop=?");
            st.setString(1, maLop);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new LopHoc(rs.getString("Malop"), rs.getString("TenLop"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RemoteException("Error finding class with code: " + maLop, e);
        }
        return null;
    }

    @Override
    public MonHoc findMonHoc(String maMh) throws RemoteException {
        try {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM monhoc WHERE MaMH=?");
            st.setString(1, maMh);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new MonHoc(rs.getString("MaMH"), rs.getString("TenMH"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RemoteException("Error finding subject with code: " + maMh, e);
        }
        return null;
    }

//    @Override
//    public Diem findDiem(int mssv) throws RemoteException {
//        try {
//            PreparedStatement st = connection.prepareStatement("SELECT * FROM diem WHERE mssv=?");
//            st.setInt(1, mssv);
//            ResultSet rs = st.executeQuery();
//            if (rs.next()) {
//                return new Diem(rs.getInt("mssv"), rs.getString("MaMH"), rs.getFloat("score"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            throw new RemoteException("Error finding score for student with ID: " + mssv, e);
//        }
//        return null;
//    }

    @Override
    public boolean addSinhVien(SinhVien sinhvien) throws RemoteException {
        try {
            PreparedStatement st = connection.prepareStatement("INSERT INTO students(mssv, name, year, Malop) VALUES (?, ?, ?, ?)");
            st.setInt(1, sinhvien.getMssv());
            st.setString(2, sinhvien.getTen());
            st.setInt(3, sinhvien.getNamSinh());
            st.setString(4, sinhvien.getMaLop());
            int rowsAffected = st.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RemoteException("Error adding student.", e);
        }
    }

    @Override
    public boolean addLopHoc(LopHoc lophoc) throws RemoteException {
        try {
            PreparedStatement st = connection.prepareStatement("INSERT INTO lop(Malop, TenLop) VALUES (?, ?)");
            st.setString(1, lophoc.getMaLop());
            st.setString(2, lophoc.getTenLop());
            int rowsAffected = st.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RemoteException("Error adding class.", e);
        }
    }

    @Override
    public boolean addMonHoc(MonHoc monhoc) throws RemoteException {
        try {
            PreparedStatement st = connection.prepareStatement("INSERT INTO monhoc(MaMH, TenMH) VALUES (?, ?)");
            st.setString(1, monhoc.getMaMh());
            st.setString(2, monhoc.getTenMh());
            int rowsAffected = st.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RemoteException("Error adding subject.", e);
        }
    }

//    @Override
//    public boolean addDiem(Diem diem) throws RemoteException {
//        try {
//            PreparedStatement st = connection.prepareStatement("INSERT INTO diem(mssv, MaMH, score) VALUES (?, ?, ?)");
//            st.setInt(1, diem.getMssv());
//            st.setString(2, diem.getMaMh());
//            st.setFloat(3, diem.getDiem());
//            int rowsAffected = st.executeUpdate();
//            return rowsAffected > 0;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            throw new RemoteException("Error adding score.", e);
//        }
//    }

    // Tương tự, các phương thức cập nhật và xóa cũng được viết tương tự.

    @Override
    public boolean updateSinhVien(SinhVien sinhvien) throws RemoteException {
        try {
            PreparedStatement st = connection.prepareStatement("UPDATE students SET name=?, year=?, Malop=? WHERE mssv=?");
            st.setString(1, sinhvien.getTen());
            st.setInt(2, sinhvien.getNamSinh());
            st.setString(3, sinhvien.getMaLop());
            st.setInt(4, sinhvien.getMssv());
            int rowsAffected = st.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RemoteException("Error updating student.", e);
        }
    }

    @Override
    public boolean updateLopHoc(LopHoc lophoc) throws RemoteException {
        try {
            PreparedStatement st = connection.prepareStatement("UPDATE lop SET TenLop=? WHERE Malop=?");
            st.setString(1, lophoc.getTenLop());
            st.setString(2, lophoc.getMaLop());
            int rowsAffected = st.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RemoteException("Error updating class.", e);
        }
    }

    @Override
    public boolean updateMonHoc(MonHoc monhoc) throws RemoteException {
        try {
            PreparedStatement st = connection.prepareStatement("UPDATE monhoc SET TenMH=? WHERE MaMH=?");
            st.setString(1, monhoc.getTenMh());
            st.setString(2, monhoc.getMaMh());
            int rowsAffected = st.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RemoteException("Error updating subject.", e);
        }
    }

//    @Override
//    public boolean updateDiem(Diem diem) throws RemoteException {
//        try {
//            PreparedStatement st = connection.prepareStatement("UPDATE diem SET score=? WHERE mssv=? AND MaMH=?");
//            st.setFloat(1, diem.getDiem());
//            st.setInt(2, diem.getMssv());
//            st.setString(3, diem.getMaMh());
//            int rowsAffected = st.executeUpdate();
//            return rowsAffected > 0;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            throw new RemoteException("Error updating score.", e);
//        }
//    }

    @Override
    public boolean deleteSinhVien(int mssv) throws RemoteException {
        try {
            PreparedStatement st = connection.prepareStatement("DELETE FROM students WHERE mssv=?");
            st.setInt(1, mssv);
            int rowsAffected = st.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RemoteException("Error deleting student.", e);
        }
    }

    @Override
    public boolean deleteLopHoc(String Malop) throws RemoteException {
        try {
            PreparedStatement st = connection.prepareStatement("DELETE FROM lop WHERE Malop=?");
            st.setString(1, Malop);
            int rowsAffected = st.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RemoteException("Error deleting class.", e);
        }
    }

    @Override
    public boolean deleteMonHoc(String MaMH) throws RemoteException {
        try {
            PreparedStatement st = connection.prepareStatement("DELETE FROM monhoc WHERE MaMH=?");
            st.setString(1, MaMH);
            int rowsAffected = st.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RemoteException("Error deleting subject.", e);
        }
    }

    @Override
    public boolean deleteDiem(int mssv) throws RemoteException {
        try {
            PreparedStatement st = connection.prepareStatement("DELETE FROM diem WHERE mssv=?");
            st.setInt(1, mssv);
            int rowsAffected = st.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RemoteException("Error deleting score.", e);
        }
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

    
}
