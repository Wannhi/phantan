package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import enity.*;

public class sinhvienDAO {

	private Connection connection;

    public sinhvienDAO(Connection connection) {
        this.connection = connection;
    }
	public List<SinhVien> getAllSinhVien() throws RemoteException {
		List<SinhVien> svList = new ArrayList<>();
		try {
			PreparedStatement st = connection.prepareStatement("SELECT * FROM students");
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				SinhVien sv = new SinhVien(rs.getInt("mssv"), rs.getString("name"), rs.getInt("year"),
						rs.getString("Malop"));
				svList.add(sv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RemoteException("Error fetching students data.", e);
		}
		return svList;
	}

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

	public boolean addSinhVien(SinhVien sinhvien) throws RemoteException {
		try {
			PreparedStatement st = connection
					.prepareStatement("INSERT INTO students(mssv, name, year, Malop) VALUES (?, ?, ?, ?)");
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

	public boolean updateSinhVien(SinhVien sinhvien) throws RemoteException {
		try {
			PreparedStatement st = connection
					.prepareStatement("UPDATE students SET name=?, year=?, Malop=? WHERE mssv=?");
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
	
       
}
