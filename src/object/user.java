/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object;

import java.io.Serializable;

/**
 *
 * @author Lenovo
 */
public class user implements Serializable{
    String username;
    String password;
    int phanquyen;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getPhanquyen() {
		return phanquyen;
	}
	public void setPhanquyen(int phanquyen) {
		this.phanquyen = phanquyen;
	}
	public user(String username, String password, int phanquyen) {
		super();
		this.username = username;
		this.password = password;
		this.phanquyen = phanquyen;
	}
    
}
