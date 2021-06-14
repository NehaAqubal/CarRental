package com.car.rental.userApp.model;

import javax.persistence.*;

import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long U_Id;

	@Column(name = "Full_Name", nullable = false)
	private String fullName;

	@Column(name = "Password", nullable = false)
	private String password;

	@Column(name = "ADDRESS", nullable = false)
	private String address;

	@Column(name = "CONTACT_NO", nullable = false)
	private String contactNo;

	@Column(name = "e_mail", nullable = false)
	private String email;

	@Column(name = "DL_NO", nullable = false)
	private String dlNo;

	public Users(long u_Id, String fullName, String password, String address, String contactNo, String email,
			String dlNo) {
		super();
		U_Id = u_Id;
		this.fullName = fullName;
		this.password = password;
		this.address = address;
		this.contactNo = contactNo;
		this.email = email;
		this.dlNo = dlNo;
	}

	public long getU_Id() {
		return U_Id;
	}

	public void setU_Id(long u_Id) {
		U_Id = u_Id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDlNo() {
		return dlNo;
	}

	public void setDlNo(String dlNo) {
		this.dlNo = dlNo;
	}

	
	public Users()
	{}
	
	
}
