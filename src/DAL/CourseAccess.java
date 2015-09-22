package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import exceptions.CourseExceptions;
import model.Course;

public class CourseAccess {
	static Connection con = null;
	static PreparedStatement preState = null;
	static ResultSet rs = null;
	
	public static void getCourse(String ccode){
//		Connection con = null;
//		PreparedStatement preState = null;
//		ResultSet rs = null;
		
		try {
			con = DbUtil.getConn();
			preState = con.prepareStatement("SELECT * FROM Course WHERE ccode=?");
			preState.setString(1, ccode);
			rs = preState.executeQuery();
		
			while (rs.next()) {

				System.out.print(rs.getString(1) + ", " + rs.getString(3) + ", " + rs.getString(2));
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
	
	public static List<Course> getAllCourses()throws CourseExceptions{
		
		
		try {
			con = DbUtil.getConn();
			preState = con.prepareStatement(DbUtil.getAllCourses());
			rs = preState.executeQuery();
			
			return DbUtil.mapCourses(rs);
		
			
//			while (rs.next()) {
//				System.out.print(rs.getString("ccode"));
//				System.out.print(rs.getString("cname"));
//				System.out.println(rs.getString("credits"));
//			}
			
		}
		
		
		catch(SQLException e){
			throw new CourseExceptions("Hittade inga kurser", e);

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
	public static void deleteCourse(String ccode) {
		Connection con = null;
		PreparedStatement preState = null;
		ResultSet rs = null;
		try {
			con = DbUtil.getConn();
			preState = con.prepareStatement("DELETE FROM Studying WHERE ccode=? DELETE FROM Course WHERE ccode=?");
			preState.setString(1, ccode);
			preState.setString(2, ccode);
			preState.executeUpdate();
			
			}catch(SQLException e){
				e.printStackTrace();
			} finally {
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
			
		
		
		public static void registerCourse(String ccode, String cname, Integer credits) {
		
		try {
			con = DbUtil.getConn();
			preState = con.prepareStatement("INSERT INTO Course (ccode, cname, credits) VALUES (?, ?, ?)");
		
			
			preState.setString(1, ccode);
			preState.setString(2, cname);
			preState.setInt(3, credits);
			preState.executeUpdate();
			}catch(SQLException e){
				e.printStackTrace();
			} finally {
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


