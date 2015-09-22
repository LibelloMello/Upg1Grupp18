package DAL;

import java.util.*;
import model.Course;
import model.Student;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

public class DbUtil {
	private static String connStr = "jdbc:sqlserver://localhost:1433;databaseName=Uppgift1Grupp18;user=sa;password=hejsan;";

	public static Connection getConn() throws SQLException {
		return (Connection) DriverManager.getConnection(connStr);
	}

	public static String getAllCourses() {
		return "SELECT * " + "FROM Course ";
	}

	public static Course mapCourse(ResultSet rs) throws SQLException {
		Course course = new Course();
		course.setCcode(rs.getString("ccode"));
		course.setCname(rs.getString("cname"));
		course.setCredits(rs.getString("credits"));

		return course;

	}

	public static List<Course> mapCourses(ResultSet rs) throws SQLException {
		List<Course> cList = new ArrayList<Course>();

		while (rs.next()) {
			Course newCourse = mapCourse(rs);
			cList.add(newCourse);
		}
		return cList;
	}

}
