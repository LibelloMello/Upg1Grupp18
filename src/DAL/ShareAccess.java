package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShareAccess {

	static Connection con = null;
	static PreparedStatement preState = null;
	static ResultSet rs = null;

	public static void registerStudentOnCourse(String spnr, String ccode) {
		int sum;
		try {
			con = DbUtil.getConn();
			preState = con.prepareStatement("INSERT INTO Studying (spnr, ccode) VALUES (?, ?)");
			preState.setString(1, spnr);
			preState.setString(2, ccode);
			preState.executeUpdate();

			// preState = con.prepareStatement("SELECT s.spnr, sum(c.credits) AS
			// totalcredits FROM Studying s JOIN Course c ON s.ccode = c.ccode
			// group by spnr");
			// rs = preState.executeQuery();
			// if(rs > 45)
			// Detta är för betyg A-B, fråga amanuens

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}

			if (preState != null) {
				try {
					preState.close();
				} catch (SQLException e) {
				}
			}

			if (con != null) {
				try {
					preState.close();
				} catch (SQLException e) {
				}
			}
		}

	}

	public static void deleteFromStudying(String spnr, String ccode) {
		int sum;
		try {
			con = DbUtil.getConn();
			preState = con.prepareStatement("DELETE FROM Studying WHERE spnr=? AND ccode=?");

			preState.setString(1, spnr);
			preState.setString(2, ccode);
			preState.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}

			if (preState != null) {
				try {
					preState.close();
				} catch (SQLException e) {
				}
			}

			if (con != null) {
				try {
					preState.close();
				} catch (SQLException e) {
				}
			}
		}

	}
	public static void getFinishedStudents(String ccode){
	
	Connection con = null;
//	PreparedStatement preState = null;
//	ResultSet rs = null;
	
	try {
		con = DbUtil.getConn();
		preState = con.prepareStatement("SELECT s.spnr, c.ccode, s.grade FROM Course c JOIN Studied s ON c.ccode=s.ccode WHERE c.ccode=?");
		preState.setString(1, ccode);
		rs = preState.executeQuery();
	
		while (rs.next()) {

			System.out.println(rs.getString(1) + ", " + rs.getString(3) + ", " + rs.getString(2));
		}
		
	}
	catch(SQLException e){
		e.printStackTrace();
	}
	finally {			
		
		if (rs != null){
			try {
				rs.close();	
			}
			catch(SQLException e) {}
		}
		
		if ( preState != null){
			try{
				preState.close();
			}catch(SQLException e){}
		}
		
		if ( con != null){
			try{
				preState.close();
			}catch(SQLException e){}
		}		
	}
	
	}
	
	public static void getUnfinishedStudents(String ccode){
		
		Connection con = null;
		PreparedStatement preState = null;
		ResultSet rs = null;
		
		try {
			con = DbUtil.getConn();
			preState = con.prepareStatement("SELECT s.spnr, c.ccode, s.grade FROM Course c JOIN Studying s ON c.ccode=s.ccode WHERE c.ccode=?");
			preState.setString(1, ccode);
			rs = preState.executeQuery();
		
			while (rs.next()) {

				System.out.println(rs.getString(1) + ", " + rs.getString(3) + ", " + rs.getString(2));
			}
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally {			
			
			if (rs != null){
				try {
					rs.close();	
				}
				catch(SQLException e) {}
			}
			
			if ( preState != null){
				try{
					preState.close();
				}catch(SQLException e){}
			}
			
			if ( con != null){
				try{
					preState.close();
				}catch(SQLException e){}
			}		
		}
		
}

}
