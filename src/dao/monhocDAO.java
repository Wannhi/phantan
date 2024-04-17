package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import enity.MonHoc;

public class monhocDAO {
	private Connection connection;

    public monhocDAO(Connection connection) {
        this.connection = connection;
    }

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
}
