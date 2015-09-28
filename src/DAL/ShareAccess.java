package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import exceptions.StudentExceptions;
import model.Student;
import model.Studied;
import model.Studying;

public class ShareAccess {

	static Connection con = null;
	static PreparedStatement preState = null;
	static ResultSet rs = null;
	static String error = "";

	public static void registerStudied(String sPnr, String cCode, String sGrade) {

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
		try {
			con = DbUtil.getConn();
			preState = con.prepareStatement(DbUtil.deleteStudying());
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

	public static ResultSet getStudentStudying(String spnr) throws SQLException {
		Connection con = null;
		PreparedStatement preState = null;
		ResultSet rs = null;
		con = DbUtil.getConn();

		preState = con.prepareStatement(
				"SELECT cname AS Kursnamn, c.ccode AS Coursecode, credits AS Credits FROM Studying s, Course c WHERE s.ccode = c.ccode AND spnr = ?");
		preState.setString(1, spnr);
		return preState.executeQuery();
	}

	private static boolean studentIsActive(String pnr, String ccode) throws SQLException {
		ResultSet rs = getStudentStudying(pnr);
		while (rs.next()) {
			if (rs.getString(2).equals(ccode)) {
				error = "Studenten läser redan denna kurs.";
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

		preState = con.prepareStatement(
				"SELECT cname AS Kursnamn, c.ccode AS Kurskod, grade AS Betyg FROM Studied s, Course c WHERE s.ccode = c.ccode AND spnr = ?");
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
				error = "Studenten har redan läst denna kurs.";
				return true;
			}
		}
		return false;
	}

	public static int registerStudentToCourse(String spnr, String ccode) throws SQLException {
		Connection con = null;
		PreparedStatement preState = null;
		ResultSet rs = null;
		con = DbUtil.getConn();

		preState = con.prepareStatement(
				"SELECT SUM(credits) FROM Studying s, Course c WHERE s.ccode = c.ccode AND spnr = ? GROUP BY spnr UNION SELECT credits FROM Course c WHERE ccode = ?");
		preState.setString(1, spnr);
		preState.setString(2, ccode);
		rs = preState.executeQuery();
		int totalPoints = 0;
		int newCredits = 0;
		while (rs.next()) {
			totalPoints += rs.getInt(1);

		}

		if (totalPoints > 45.0) {
			error = "A student may not read more than 45HP";
			return 0;
		} else if (!studentIsActive(spnr, ccode) && !studentHasGrade(spnr, ccode)) {
			PreparedStatement ps = con.prepareStatement("INSERT INTO Studying VALUES(?, ?)");
			ps.setString(1, spnr);
			ps.setString(2, ccode);
			return ps.executeUpdate();
		} else
			return 0;
	}

}
