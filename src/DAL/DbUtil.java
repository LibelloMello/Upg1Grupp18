package DAL;

import java.util.*;
import model.Course;
import model.Student;
import model.Studied;
import model.Studying;

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
	
	public static String getAllStudents() {
		return "SELECT * FROM Student";
	}
	
	public static String getStudent(String sPnr) {
		return "SELECT * FROM STUDENT WHERE spnr = ?";
	}
	
	public static String deleteStudent() {
		return "DELETE FROM Studying WHERE spnr=? DELETE FROM Student WHERE spnr=?";
	}
	
	public static String registerStudent() {
		return "INSERT INTO Student (spnr, sname, saddress) VALUES (?, ?, ?)";
	}
	public static String registerStudentOnCourse() {
		return 	"INSERT INTO Studying (spnr, ccode) VALUES (?, ?)";
	}

	public static String getFinishedStudents(String cCode) {
		return "SELECT s.spnr, c.ccode, s.grade FROM Course c JOIN Studied s ON c.ccode=s.ccode WHERE c.ccode=?";
	}
	
	public static String getUnfinishedStudents(String cCode) {
		return "SELECT s.spnr, c.ccode FROM Course c JOIN Studying s ON c.ccode=s.ccode WHERE c.ccode = ?";
	}
	
	public static String deleteStudying () {
		return "DELETE FROM Studying WHERE spnr=? AND ccode=?";
	}
	
	public static String getCourse() {
		return "SELECT * FROM Course WHERE ccode=?";
	}
	
	public static String registerStudied() {
		return "INSERT INTO Studied (spnr, ccode, grade) VALUES (?, ?, ?)";
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
	
	public static Student mapStudent(ResultSet rs) throws SQLException {
		Student student = new Student();
		student.setsPnr(rs.getString("spnr"));
		student.setsName(rs.getString("sname"));
		student.setsAddress(rs.getString("saddress"));

		return student;

	}
	
	public static List<Student> mapStudents(ResultSet rs) throws SQLException {
		List<Student> sList = new ArrayList<Student>();

		while (rs.next()) {
			Student newStudent = mapStudent(rs);
			sList.add(newStudent);
		}
		return sList;
	}
	
	public static Studied mapStudied(ResultSet rs) throws SQLException {
		Studied studied = new Studied();
		studied.setsPnr(rs.getString("spnr"));
		studied.setcCode(rs.getString("ccode"));
		studied.setsGrade(rs.getString("grade"));

		return studied;

	}

	public static List<Studied> mapStudieds(ResultSet rs) throws SQLException {
		List<Studied> studiedList = new ArrayList<Studied>();

		while (rs.next()) {
			Studied newStudied = mapStudied(rs);
			studiedList.add(newStudied);
		}
		return studiedList;
	}
	public static Studying mapStudying(ResultSet rs) throws SQLException {
		Studying studying = new Studying();
		studying.setsPnr(rs.getString("spnr"));
		studying.setcCode(rs.getString("ccode"));

		return studying;

	}

	public static List<Studying> mapStudyings(ResultSet rs) throws SQLException {
		List<Studying> studyingList = new ArrayList<Studying>();

		while (rs.next()) {
			Studying newStudying = mapStudying(rs);
			studyingList.add(newStudying);
		}
		return studyingList;
	}

}
