package JDBC;

public class MarksheetBean {
	private int ID;
	private String RollNo;
	private String Fname;
	private String Lname;
	private int Phy;
	private int Chem;
	private int Math;
	
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getRollNo() {
		return RollNo;
	}
	public void setRollNo(String rollNo) {
		RollNo = rollNo;
	}
	public String getFname() {
		return Fname;
	}
	public void setFname(String fname) {
		Fname = fname;
	}
	public String getLname() {
		return Lname;
	}
	public void setLname(String lname) {
		Lname = lname;
	}
	public int getPhy() {
		return Phy;
	}
	public void setPhy(int phy) {
		Phy = phy;
	}
	public int getChem() {
		return Chem;
	}
	public void setChem(int chem) {
		Chem = chem;
	}
	public int getMath() {
		return Math;
	}
	public void setMath(int math) {
		Math = math;
	}
	System.out.println("printed");
	

}
