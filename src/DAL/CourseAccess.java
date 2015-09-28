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

public class CourseAccess {

	public static Course getCourse(String cCode) throws CourseExceptions {
		Connection con = null;
		PreparedStatement preState = null;
		ResultSet rs = null;

		try {
			con = DbUtil.getConn();
			preState = con.prepareStatement(DbUtil.getCourse());
			preState.setString(1, cCode);
			rs = preState.executeQuery();

			if (rs.next())
				return DbUtil.mapCourse(rs);

			return null;

		} catch (SQLException e) {
			throw new CourseExceptions("Didn´t find course", e);

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

	public static List<Course> getAllCourses() throws CourseExceptions {
		Connection con = null;
		PreparedStatement preState = null;
		ResultSet rs = null;

		try {
			con = DbUtil.getConn();
			preState = con.prepareStatement(DbUtil.getAllCourses());
			rs = preState.executeQuery();

			return DbUtil.mapCourses(rs);

		} catch (SQLException e) {
			throw new CourseExceptions("Hittade inga kurser", e);

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

	public static void deleteCourse(String ccode) throws CourseExceptions {
		Connection con = null;
		PreparedStatement preState = null;
		ResultSet rs = null;
		try {
			Course course = CourseAccess.getCourse(ccode);
			if (course == null) {
				return;
			}

			con = DbUtil.getConn();
			preState = con.prepareStatement(DbUtil.deleteCourse());
			preState.setString(1, ccode);
			preState.executeUpdate();

		} catch (SQLException e) {
			throw new CourseExceptions("Didn't find a course", e);

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

	public static void registerCourse(Course course) throws CourseExceptions {
		Connection con = null;
		PreparedStatement preState = null;
		ResultSet rs = null;
		
		try {
			con = DbUtil.getConn();
			preState = con.prepareStatement(DbUtil.registerCourse());

			preState.setString(1, course.getCcode());
			preState.setString(2, course.getCname());
			preState.setInt(3, course.getCredits());
			preState.executeUpdate();
			
			
		} catch (SQLException e) {
			throw new CourseExceptions("Course already exists", e);
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
