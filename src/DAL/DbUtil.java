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
		return "SELECT * FROM Course ";
	}

	public static String registerCourse() {
		return "INSERT INTO Course (ccode, cname, credits) VALUES (?, ?, ?)";
	}

	public static String getAllStudents() {
		return "SELECT * FROM Student";
	}

	public static String getStudent() {
		return "SELECT * FROM STUDENT WHERE spnr = ?";
	}

	public static String deleteStudent() {
		return "DELETE FROM Student WHERE spnr=?";
	}

	public static String registerStudent() {
		return "INSERT INTO Student (spnr, sname, saddress) VALUES (?, ?, ?)";
	}

	public static String registerStudentOnCourse() {
		return "INSERT INTO Studying (spnr, ccode) VALUES (?, ?)";
	}

	public static String getFinishedStudents(String cCode) {
		return "SELECT s.spnr, c.ccode, s.grade FROM Course c JOIN Studied s ON c.ccode=s.ccode WHERE c.ccode=?";
	}

	public static String getResult(String sPnr, String cCode) {
		return "SELECT * FROM Studied WHERE spnr = ? AND ccode = ?";
	}

	public static String getUnfinishedStudents(String cCode) {
		return "SELECT s.spnr, c.ccode FROM Course c JOIN Studying s ON c.ccode=s.ccode WHERE c.ccode = ?";
	}

	public static String deleteStudying() {
		return "DELETE FROM Studying WHERE spnr=? AND ccode=?";
	}

	public static String getCourse() {
		return "SELECT * FROM Course WHERE ccode=?";
	}

	public static String deleteCourse() {
		return "DELETE FROM Course WHERE ccode=?";
	}

	public static String registerStudied() {
		return "INSERT INTO Studied (spnr, ccode, grade) VALUES (?, ?, ?)";
	}

	public static String getPercentA(String cCode) {
		return "Select (Count(grade)* 100 / (Select Count(*) From Studied where ccode=?)) as Score From Studied s WHERE s.grade='A' AND s.ccode=? Group By grade ";
	}

	public static String checkIfFortyFive(String sPnr) {
		return "SELECT sum(credits) FROM Course WHERE ccode IN (SELECT ccode FROM Studying WHERE spnr = ?)";
	}
	public static String getAllStudentsInStudying() {
		return "Select * FROM Studying";
	}

public static String getAllStudentsInStudied() {
		return "SELECT * FROM Studied";
	}


	/*
	 * public static String getStandardMetadata() { return "SELECT * FROM [" +
	 * tablename + "]"; }
	 */
	public static String checkIfMaxCredits() {
		return "SELECT SUM(credits) FROM Studying s, Course c WHERE s.ccode = c.ccode AND spnr = ? GROUP BY spnr UNION SELECT credits FROM Course c WHERE ccode = ?";
	}

	public static String getStudentStudied() {
		return "SELECT cname AS Kursnamn, c.ccode "
				+ "AS Kurskod, grade AS Betyg FROM Studied s, Course c WHERE s.ccode = c.ccode AND spnr = ?";
	}

	public static Course mapCourse(ResultSet rs) throws SQLException {
		Course course = new Course();
		course.setCcode(rs.getString("ccode"));
		course.setCname(rs.getString("cname"));
		course.setCredits(rs.getInt("credits"));

		return course;
	}

	public static String getStudentStudying(String spnr) {
		return "SELECT cname AS Kursnamn, c.ccode AS Coursecode, credits AS Credits FROM Studying s, Course c WHERE s.ccode = c.ccode AND spnr = ?";
	}

	public static String throughPut(String ccode) throws SQLException {
		return "SELECT TOP 1 ccode, (SUM(CASE WHEN grade != 'U' THEN 1 ELSE 0 END)) * 100 / (SUM(CASE WHEN grade LIKE '_' THEN 1 ELSE 0 END)) AS 'Percentage' FROM Studied s GROUP BY s.ccode ORDER BY Percentage DESC";
	}

	public static String getStudentsCourses(String sPnr) throws SQLException {
		return "SELECT c.ccode, s.credits FROM studying s, Course c WHERE spnr = ?";
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
