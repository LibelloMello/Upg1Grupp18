package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exceptions.CourseExceptions;
import exceptions.StudentExceptions;
import model.Student;
import model.Studied;
import model.Studying;

public class ShareAccess {

	static Connection con = null;
	static PreparedStatement preState = null;
	static ResultSet rs = null;
	static String error = "";

	public static void registerStudied(String sPnr, String cCode, String sGrade) throws StudentExceptions {

		Connection con = null;
		PreparedStatement preState = null;
		ResultSet rs = null;

		try {
			con = DbUtil.getConn();
			preState = con.prepareStatement(DbUtil.registerStudied());
			preState.setString(1, sPnr);
			preState.setString(2, cCode);
			preState.setString(3, sGrade);
			preState.executeUpdate();

		} catch (SQLException e) {
			throw new StudentExceptions("Unable to register student");
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

	public static void deleteFromStudying(String spnr, String ccode)throws StudentExceptions {
		try {
			con = DbUtil.getConn();
			preState = con.prepareStatement(DbUtil.deleteStudying());
			preState.setString(1, spnr);
			preState.setString(2, ccode);
			preState.executeUpdate();

		} catch (SQLException e) {
			throw new StudentExceptions("Unable to delete student");
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

	public static List<Studied> getAllStudied(String cCode) throws StudentExceptions {
		Connection con = null;
		PreparedStatement preState = null;
		ResultSet rs = null;

		try {
			con = DbUtil.getConn();
			preState = con.prepareStatement(DbUtil.getFinishedStudents(cCode));
			preState.setString(1, cCode);
			rs = preState.executeQuery();

			return DbUtil.mapStudieds(rs);

		} catch (SQLException e) {
			throw new StudentExceptions("Hittade inga resultat", e);

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

	public static int getPercentA(String cCode) throws StudentExceptions {
		Connection con = null;
		PreparedStatement preState = null;
		ResultSet rs = null;

		try {
			con = DbUtil.getConn();
			preState = con.prepareStatement(DbUtil.getPercentA(cCode));
			preState.setString(1, cCode);
			preState.setString(2, cCode);
			rs = preState.executeQuery();
			int g = 0;

			while (rs.next()) {
				String str = rs.getString(1);
				g = Integer.parseInt(str);
			}
			return g;

		} catch (SQLException e) {
			throw new StudentExceptions("Hittade inga resultat", e);

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

	public static String getTotalCredits(String sPnr) throws StudentExceptions {
		Connection con = null;
		PreparedStatement preState = null;
		ResultSet rs = null;

		try {
			con = DbUtil.getConn();
			preState = con.prepareStatement(DbUtil.checkIfFortyFive(sPnr));
			preState.setString(1, sPnr);
			rs = preState.executeQuery();
			int g = 0;

			while (rs.next()) {
				g = rs.getInt(1);

			}
			String poop = Integer.toString(g);
			return poop;

		} catch (SQLException e) {
			throw new StudentExceptions("Hittade inga resultat", e);

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

	public static List<Studying> getAllStudying(String cCode) throws StudentExceptions {
		Connection con = null;
		PreparedStatement preState = null;
		ResultSet rs = null;

		try {
			con = DbUtil.getConn();
			preState = con.prepareStatement(DbUtil.getUnfinishedStudents(cCode));
			preState.setString(1, cCode);
			rs = preState.executeQuery();

			return DbUtil.mapStudyings(rs);

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

	public static Studied getResult(String sPnr, String cCode) throws StudentExceptions {

		Connection con = null;
		PreparedStatement preState = null;
		ResultSet rs = null;

		try {
			con = DbUtil.getConn();
			preState = con.prepareStatement(DbUtil.getResult(sPnr, cCode));
			preState.setString(1, sPnr);
			preState.setString(2, cCode);
			rs = preState.executeQuery();

			if (rs.next()) {

				return DbUtil.mapStudied(rs);

			}

			return null;

		} catch (SQLException e) {
			throw new StudentExceptions("Hittade ingen student på denna kurs", e);
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
//Kan inte fixa finally, felmeddelandet fuckar loss
	
	public static ResultSet getStudentStudying(String spnr) throws SQLException {
		Connection con = null;
		PreparedStatement preState = null;
		ResultSet rs = null;

		con = DbUtil.getConn();
		preState = con.prepareStatement(DbUtil.getStudentStudying(spnr));
		preState.setString(1, spnr);
		return preState.executeQuery();
	
	}
	public static String getStudentsCourses(String sPnr) throws StudentExceptions {

		Connection con = null;
		PreparedStatement preState = null;
		ResultSet rs = null;

		try {
			con = DbUtil.getConn();
			preState = con.prepareStatement(DbUtil.getStudentsCourses(sPnr));
			preState.setString(1, sPnr);
			rs = preState.executeQuery();

			return null;
		} catch (SQLException e) {
			throw new StudentExceptions("hej", e);
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


	private static boolean studentIsActive(String pnr, String ccode) throws SQLException {
		ResultSet rs = getStudentStudying(pnr);
		while (rs.next()) {
			if (rs.getString(2).equals(ccode)) {
	
				return true;
			}
		}
		return false;
	}

	public static ResultSet getStudentStudied(String pnr) throws SQLException {
		Connection con = null;
		PreparedStatement preState = null;
		ResultSet rs = null;
		con = DbUtil.getConn();

		preState = con.prepareStatement(DbUtil.getStudentStudied());
		preState.setString(1, pnr);
		return preState.executeQuery();
	}

	private static boolean studentHasGrade(String pnr, String ccode) throws SQLException {
		Connection con = null;
		PreparedStatement preState = null;
		ResultSet rs = null;
		con = DbUtil.getConn();

		rs = getStudentStudied(pnr);
		while (rs.next()) {
			if (rs.getString(2).equals(ccode)) {
			
				return true;
			}
		}
		return false;
	}

	public static int registerStudentToCourse(String spnr, String ccode) throws StudentExceptions {
		Connection con = null;
		PreparedStatement preState = null;
		ResultSet rs = null;
		try {
			con = DbUtil.getConn();
			//Kan inte byta ut mot ett preparedstatement i DbUtil då felmeddelandet slutar fungera. Vaffö? Fixat?
			preState = con.prepareStatement(DbUtil.checkIfMaxCredits());
			preState.setString(1, spnr);
			preState.setString(2, ccode);
			rs = preState.executeQuery();
			int totalPoints = 0;
			int newCredits = 0;
			while (rs.next()) {
				totalPoints += rs.getInt(1);
			}
			try {
				newCredits = CourseAccess.getCourse(ccode).getCredits();
			} catch (CourseExceptions e) {
				e.printStackTrace();
			}
		
			if (totalPoints > 45) {

				return 0;
			} else if (!studentIsActive(spnr, ccode) && !studentHasGrade(spnr, ccode)) {
				PreparedStatement ps = con.prepareStatement(DbUtil.registerStudentOnCourse());
				ps.setString(1, spnr);
				ps.setString(2, ccode);
				return ps.executeUpdate();
			} else
				return 2; 
		} catch (SQLException e) {
			throw new StudentExceptions("Student not found");
		}
	}
	public static List<Studying> getAllStudentsInStudying() throws StudentExceptions {
		Connection con = null;
		PreparedStatement preState = null;
		ResultSet rs = null;

		try {
			con = DbUtil.getConn();
			preState = con.prepareStatement(DbUtil.getAllStudentsInStudying());
			rs = preState.executeQuery();

			return DbUtil.mapStudyings(rs);

		} catch (SQLException e) {
			throw new StudentExceptions("Found no students", e);

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
	public static List<Studied> getAllStudentsInStudied() throws StudentExceptions {
		Connection con = null;
		PreparedStatement preState = null;
		ResultSet rs = null;

		try {
			con = DbUtil.getConn();
			preState = con.prepareStatement(DbUtil.getAllStudentsInStudied());
			rs = preState.executeQuery();

			return DbUtil.mapStudieds(rs);

		} catch (SQLException e) {
			throw new StudentExceptions("Found no students", e);

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
