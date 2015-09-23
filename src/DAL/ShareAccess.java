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

	public static void registerStudentOnCourse(String spnr, String ccode) {

		try {
			con = DbUtil.getConn();
			preState = con.prepareStatement(DbUtil.registerStudentOnCourse());
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
	
	public static int getTotalCredits(String sPnr) throws StudentExceptions {
		Connection con = null;
		PreparedStatement preState = null;
		ResultSet rs = null;

		try {
			con = DbUtil.getConn();
			preState = con.prepareStatement(DbUtil.restraint45(sPnr));
			preState.setString(1, sPnr);
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

}
