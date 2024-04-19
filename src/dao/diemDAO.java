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

public class diemDAO {
	private Connection connection;

    public diemDAO(Connection connection) {
        this.connection = connection;
    }
    public List<Diem> getStudentAndScoreBySubject(String TenMonHoc) throws RemoteException {
        List<Diem> dsDiem = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement("SELECT name, TenMH, thuongki, giuaki, cuoiki FROM monhoc m join diem d on m.MaMH = d.MaMH join students s on d.mssv = s.mssv WHERE TenMH LIKE ?");
            st.setString(1, TenMonHoc);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Diem diem = new Diem(rs.getString("name"), rs.getString("TenMH"), rs.getFloat("thuongki"), rs.getFloat("giuaki"), rs.getFloat("cuoiki"));
                dsDiem.add(diem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RemoteException("Error fetching students data.", e);
        }
        return dsDiem;
	}
     public List<Diem> getStudentAndScoreByID(int mssv) throws RemoteException {
        List<Diem> dsDiem = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement("SELECT name, TenMH, thuongki, giuaki, cuoiki FROM monhoc m join diem d on m.MaMH = d.MaMH join students s on d.mssv = s.mssv WHERE d.mssv = ?");
            st.setInt(1, mssv);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Diem diem = new Diem(rs.getString("name"), rs.getString("TenMH"), rs.getFloat("thuongki"), rs.getFloat("giuaki"), rs.getFloat("cuoiki"));
                dsDiem.add(diem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RemoteException("Error fetching students data.", e);
        }
        return dsDiem;
	}
     
     public boolean addDiem(Diem diem) throws RemoteException {
		try {
			PreparedStatement st = connection.prepareStatement("INSERT INTO `diem` (`mssv`, `MaMH`, `thuongki`, `giuaki`, `cuoiki`) VALUES (?,?,?,?,?);");
			st.setInt(1, diem.getMssv());
			st.setString(2, diem.getMaMh());
			st.setFloat(3, diem.getThuongKi());
			st.setFloat(4, diem.getGiuaKi());
			st.setFloat(5, diem.getCuoiKi());
			int rowsAffected = st.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RemoteException("Error adding student.", e);
		}
	}
     public boolean updateDiem(String cotdiem, float diemmoi ,int mssv, String MaMH) throws RemoteException {
		try {
			PreparedStatement st = connection
					.prepareStatement("UPDATE diem SET " + cotdiem + " = ? WHERE mssv = ? AND MaMH LIKE ?");
			//st.setString(1, cotdiem);
			st.setFloat(1, diemmoi);
			st.setInt(2, mssv);
			st.setString(3, MaMH);
			int rowsAffected = st.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RemoteException("Error updating student.", e);
		}
	}
//        public float getScoreByIDandSubject(int mssv, String tencotDiem ,String maMh) throws RemoteException {
//		try {
//			PreparedStatement st = connection.prepareStatement("SELECT " + tencotDiem + " FROM diem WHERE mssv = ? AND MaMH LIKE ?");
//			//st.setString(1, tencotDiem);
//                        st.setInt(1, mssv);
//                        st.setString(2, maMh);
//			ResultSet rs = st.executeQuery();
//			if (rs.next()) {
//				//return new Diem(rs.getInt("mssv"), rs.getString("MaMH"),rs.getFloat("thuongki"), rs.getFloat("giuaki"), rs.getFloat("cuoiki") );
//                                return rs.getFloat(tencotDiem);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//			throw new RemoteException("Error finding student with ID: " + mssv, e);
//		}
//		return 0;
//	}
     
     public float getScoreByIDandSubject(int mssv, String tencotDiem, String maMh) throws RemoteException {
    float score = 0.0f;
    try {
        String query = "SELECT " + tencotDiem + " FROM diem WHERE mssv = ? AND MaMH like ?";
        PreparedStatement st = connection.prepareStatement(query);
        st.setInt(1, mssv);
        st.setString(2, maMh);
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            score = rs.getFloat(1);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        throw new RemoteException("Error finding student's score with ID: " + mssv + " for the subject: " + maMh, e);
    }
    return score;
}
     
     
//     public float getScoreByIDandSubject(int mssv, String tencotDiem, String maMh, Connection connection) throws RemoteException, SQLException {
//    float score = 0.0f;
//    PreparedStatement st = null;
//    ResultSet rs = null;
//    
//    try {
//        String query = "SELECT " + tencotDiem + " FROM diem WHERE mssv = ? AND MaMH = ?";
//        st = connection.prepareStatement(query);
//        st.setInt(1, mssv);
//        st.setString(2, maMh);
//        rs = st.executeQuery();
//        if (rs.next()) {
//            score = rs.getFloat(tencotDiem);
//        }
//    } catch (SQLException e) {
//        e.printStackTrace();
//        throw new RemoteException("Error finding student's score with ID: " + mssv + " for the subject: " + maMh, e);
//    } finally {
//        // Close PreparedStatement and ResultSet
//        if (rs != null) {
//            rs.close();
//        }
//        if (st != null) {
//            st.close();
//        }
//    }
//    return score;
//}
}