package dao;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import enity.LopHoc;

public class lophocDAO {
	private Connection connection;

    public lophocDAO(Connection connection) {
        this.connection = connection;
    }
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
}
