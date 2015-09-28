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

	public static Student getStudent(String sPnr) throws StudentExceptions {
		Connection con = null;
		PreparedStatement preState = null;
		ResultSet rs = null;
		String msg = "";

		try {
			con = DbUtil.getConn();
			preState = con.prepareStatement(DbUtil.getStudent());
			preState.setString(1, sPnr);
			rs = preState.executeQuery();

			if (rs.next())
				return DbUtil.mapStudent(rs);

			return null;

		} catch (SQLException e) {
			throw new StudentExceptions("Didn't find any student", e);

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

	public static void registerStudent(Student student) throws StudentExceptions {
		Connection con = null;
		PreparedStatement preState = null;
		ResultSet rs = null;

		try {
			con = DbUtil.getConn();
			preState = con.prepareStatement(DbUtil.registerStudent());

			preState.setString(1, student.getSpnr());
			preState.setString(2, student.getsName());
			preState.setString(3, student.getsAddress());
			preState.executeUpdate();

		} catch (SQLException e) {
			throw new StudentExceptions("Student already exists", e);
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

	public static void deleteStudent(String spnr) throws StudentExceptions {
		Connection con = null;
		PreparedStatement preState = null;
		ResultSet rs = null;
		try {
			Student student = StudentAccess.getStudent(spnr);
			if (student == null) {
				return;
			}

			con = DbUtil.getConn();
			preState = con.prepareStatement(DbUtil.deleteStudent());
			preState.setString(1, spnr);
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
