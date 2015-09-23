package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import exceptions.CourseExceptions;
import exceptions.StudentExceptions;
import model.Course;
import model.Student;

public class StudentAccess {

	public static void getStudent(String spnr) {
		Connection con = null;
		PreparedStatement preState = null;
		ResultSet rs = null;

		try {
			con = DbUtil.getConn();
			preState = con.prepareStatement(DbUtil.getStudent());
			preState.setString(1, spnr);
			rs = preState.executeQuery();

			while (rs.next()) {

				System.out.print(rs.getString(1) + ", " + rs.getString(3) + ", " + rs.getString(2));
			}

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

	public static List<Student> getAllStudents() throws StudentExceptions {
		Connection con = null;
		PreparedStatement preState = null;
		ResultSet rs = null;

		try {
			con = DbUtil.getConn();
			preState = con.prepareStatement(DbUtil.getAllStudents());
			rs = preState.executeQuery();

			return DbUtil.mapStudents(rs);

		} catch (SQLException e) {
			throw new StudentExceptions("Hittade inga studenter", e);

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

	// public static void getAllStudents(){
	// Connection con = null;
	// PreparedStatement preState = null;
	// ResultSet rs = null;
	//
	// try {
	// con = DbUtil.getConn();
	// preState = con.prepareStatement("SELECT * FROM Student");
	// rs = preState.executeQuery();
	//
	// while (rs.next()) {
	// System.out.print(rs.getString("spnr"));
	// System.out.println(rs.getString(2));
	// }
	// }
	// catch(SQLException e){
	// e.printStackTrace();
	// }
	// finally {
	//
	// if (rs != null){
	// try {
	// rs.close();
	// }
	// catch(SQLException e) {}
	// }
	//
	// if ( preState != null){
	// try{
	// preState.close();
	// }catch(SQLException e){}
	// }
	//
	// if ( con != null){
	// try{
	// preState.close();
	// }catch(SQLException e){}
	// }
	// }
	//
	// }
	public static void registerStudent(String spnr, String sname, String saddress) {
		Connection con = null;
		PreparedStatement preState = null;
		ResultSet rs = null;

		try {
			con = DbUtil.getConn();
			preState = con.prepareStatement("INSERT INTO Student (spnr, sname, saddress) VALUES (?, ?, ?)");

			preState.setString(1, spnr);
			preState.setString(2, sname);
			preState.setString(3, saddress);
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

	public static void deleteStudent(String spnr) {
		Connection con = null;
		PreparedStatement preState = null;
		ResultSet rs = null;
		try {
			con = DbUtil.getConn();
			preState = con.prepareStatement(DbUtil.deleteStudent());
			preState.setString(1, spnr);
			preState.setString(2, spnr);
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

}
