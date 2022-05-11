package kr.siat.model;

public class MemberDTO {
	int userNum;
	String userName;
	String userEmail;
	String userPhone;
	String userPassword;
	String userRegidate;
	int userType;
	
	public MemberDTO() {
		this(0, "", "", "", "", "", 0);
	}
	
	/*
	 * String userName = req.getParameter("userName"); String userEmail =
	 * req.getParameter("userEmail"); String userPassword =
	 * req.getParameter("userPassword"); String userPhone =
	 * req.getParameter("userPhone"); int userType =
	 * Integer.parseInt(req.getParameter("userType"));
	 */
	
	public MemberDTO(String userName, String userEmail, String userPassword, String userPhone, int userType) {
		this(0, userName, userEmail, userPassword, userPhone, "", userType);
	}
	
	public MemberDTO(int userNum, String userName, String userEmail, String userPassword, String userPhone, String userRegidate, int userType) {
		this.userNum = userNum;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userPhone = userPhone;
		this.userRegidate = userRegidate;
		this.userType = userType;
	}

	public int getUserNum() {
		return userNum;
	}

	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserRegidate() {
		return userRegidate;
	}

	public void setUserRegidate(String userRegidate) {
		this.userRegidate = userRegidate;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}
	
	
}
