package JDBC;

import java.lang.reflect.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;

import org.omg.PortableServer.ID_ASSIGNMENT_POLICY_ID;

public class MarksheetModel {

	public int pk() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testrays", "root", "root");
		/*
		 * CallableStatement calstmt= conn.prepareCall("{?= Call MARKFUNC()}");
		 * 
		 * 
		 * calstmt.registerOutParameter(1, Types.INTEGER); calstmt.execute(); int cs=
		 * calstmt.getInt(1); cs++; System.out.println("Running "+ cs); return cs ;
		 */
		
		int ppk=0;
		PreparedStatement ps= conn.prepareStatement("SELECT MAX(ID) FROM MARKSHEET");
		ResultSet rs= ps.executeQuery();
		
		while(rs.next()) {
			ppk = rs.getInt(1);
			}
		return ppk+1;
	}

	public void update(MarksheetBean msb) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testrays", "root", "root");

		// MarksheetBean msb= new MarksheetBean ();

		conn.setAutoCommit(false);
		PreparedStatement ps = conn
				.prepareStatement("UPDATE MARKSHEET SET ROLLNO=?,FNAME=?, LNAME=?, PHY=?,CHEM=?,MATH=? WHERE ID = ?");

		ps.setString(1, msb.getRollNo());
		ps.setString(2, msb.getFname());
		ps.setString(3, msb.getLname());
		ps.setInt(4, msb.getPhy());
		ps.setInt(5, msb.getChem());
		ps.setInt(6, msb.getMath());
		ps.setInt(7, msb.getID());

		ps.execute();
		conn.commit();

		System.out.println("Insertion Done");

		ps.close();
		conn.close();

	}

	public void MeritList(MarksheetBean msb) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testrays", "root", "root");

		PreparedStatement ps = conn.prepareStatement(
				"SELECT *, (PHY+CHEM+MATH) AS TOTAL, ((PHY+CHEM+MATH)/3) AS PERCENTAGE FROM MARKSHEET ORDER BY TOTAL DESC LIMIT 3");

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			System.out.print(" " + rs.getString(1));
			System.out.print(" " + rs.getString(2));
			System.out.print(" " + rs.getString(3));
			System.out.print(" " + rs.getString(4));
			System.out.print(" " + rs.getString(5));
			System.out.print(" " + rs.getString(6));
			System.out.print(" " + rs.getString(7));
			System.out.print(" " + rs.getString(8));
			System.out.println(" " + rs.getString(9));

		}

		System.out.println("Merit List");

		ps.close();
		conn.close();

	}
	
	public void get(MarksheetBean msb) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testrays", "root", "root");

		PreparedStatement ps = conn.prepareStatement("SELECT * from marksheet");

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			System.out.print(" " + rs.getString(1));
			System.out.print(" " + rs.getString(2));
			System.out.print(" " + rs.getString(3));
			System.out.print(" " + rs.getString(4));
			System.out.print(" " + rs.getString(5));
			System.out.print(" " + rs.getString(6));
			System.out.println(" " + rs.getString(7));
			

		}

	    ps.close();
		conn.close();

	}


	public void add(MarksheetBean msb) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testrays", "root", "root");

		// MarksheetBean msb= new MarksheetBean ();

		conn.setAutoCommit(false);
		PreparedStatement ps = conn.prepareStatement("Insert into marksheet values(?,?,?,?,?,?,?)");

		ps.setInt(1, pk());
		ps.setString(2, msb.getRollNo());
		ps.setString(3, msb.getFname());
		ps.setString(4, msb.getLname());
		ps.setInt(5, msb.getPhy());
		ps.setInt(6, msb.getChem());
		ps.setInt(7, msb.getMath());

		ps.execute();
		conn.commit();

		System.out.println("Insertion Done");

		ps.close();
		conn.close();

	}

	public void delete(MarksheetBean msb) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testrays", "root", "root");

		// MarksheetBean msb= new MarksheetBean ();

		conn.setAutoCommit(false);
		PreparedStatement ps = conn.prepareStatement("DELETE FROM MARKSHEET WHERe ID=?");

		ps.setInt(1, msb.getID());

		ps.execute();
		conn.commit();

		System.out.println("Insertion Done");

		ps.close();
		conn.close();

	}

}
