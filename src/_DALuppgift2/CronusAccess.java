package _DALuppgift2;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import _DALuppgift2.DbUtil;

public class CronusAccess {

	private static String sqlString;

	public static Vector<String> getStandardMetaData(String tablename) throws SQLException {
		Vector<String> vectorList = new Vector<String>();

		Connection con = DbUtil.getConn();
		
		String a = "CRONUS Sverige AB$Employee Statistics Group";
		int col = 5;
		
		if(tablename.equals(a)){
			col = 3;
		}

		sqlString = "SELECT * FROM [" + tablename + "]";

		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sqlString);
		ResultSetMetaData rsmd = rs.getMetaData();
		
		for (int i = 1; i <= col; i++) {
			vectorList.add(rsmd.getColumnLabel(i));
		}
		return vectorList;
	}

	public static Vector<Vector<String>> getAllData(String tablename) throws SQLException {
		Connection con = DbUtil.getConn();
		String a = "CRONUS Sverige AB$Employee Statistics Group";
		int col = 5;
		
		if(tablename.equals(a)){
			col = 3;
		}
		
		String SQLquery = "SELECT * FROM [" + tablename + "]";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(SQLquery);

		Vector<Vector<String>> outerList = new Vector<Vector<String>>();
		

		while (rs.next()) {
			Vector<String> innerList = new Vector<String>();
			for (int i = 1; i <= col; i++) {
				innerList.add(rs.getString(i));
			}
			outerList.add(innerList);
		}
		return outerList;
	}
	
	
	public static Vector<Vector<String>> getKeys() throws SQLException {
		Connection con = DbUtil.getConn();
		int col = 2;
	
		PreparedStatement preStmt = con.prepareStatement(DbUtil.allKeys());
		ResultSet rs = preStmt.executeQuery();

		Vector<Vector<String>> outerList = new Vector<Vector<String>>();
		

		while (rs.next()) {
			Vector<String> innerList = new Vector<String>();
			for (int i = 1; i <= col; i++) {
				innerList.add(rs.getString(i));
			}
			outerList.add(innerList);
		}
		return outerList;
		
	}
	public static Vector<String> getKeysMetaData() throws SQLException {
		Vector<String> vectorList = new Vector<String>();
		
		Connection con = DbUtil.getConn();
		PreparedStatement preStmt = con.prepareStatement(DbUtil.allKeys());
		ResultSet rs = preStmt.executeQuery();
		
		ResultSetMetaData rsmd = rs.getMetaData();
		int j = rsmd.getColumnCount();
		for (int i = 1; i <= j; i++) {
			vectorList.add(rsmd.getColumnLabel(i));
		}	
		return vectorList;
	}
	public static Vector<Vector<String>> getIndexes() throws SQLException {
		Connection con = DbUtil.getConn();
		int col = 18;
	
		PreparedStatement preStmt = con.prepareStatement(DbUtil.allIndexes());
		ResultSet rs = preStmt.executeQuery();

		Vector<Vector<String>> outerList = new Vector<Vector<String>>();
		

		while (rs.next()) {
			Vector<String> innerList = new Vector<String>();
			for (int i = 1; i <= col; i++) {
				innerList.add(rs.getString(i));
				
			}
			outerList.add(innerList);
			
			
		}
		return outerList;
		
	}
	public static Vector<String> getIndexesMetaData() throws SQLException {
		Vector<String> vectorList = new Vector<String>();
		
		Connection con = DbUtil.getConn();
		PreparedStatement preStmt = con.prepareStatement(DbUtil.allIndexes());
		ResultSet rs = preStmt.executeQuery();
		
		ResultSetMetaData rsmd = rs.getMetaData();
		int j = rsmd.getColumnCount();
		for (int i = 1; i <= j; i++) {
			vectorList.add(rsmd.getColumnLabel(i));
		}	
		return vectorList;
	}
	public static Vector<Vector<String>> getConstraints() throws SQLException {
		Connection con = DbUtil.getConn();
		int col = 5;
	
		PreparedStatement preStmt = con.prepareStatement(DbUtil.allConstraints());
		ResultSet rs = preStmt.executeQuery();

		Vector<Vector<String>> outerList = new Vector<Vector<String>>();
		

		while (rs.next()) {
			Vector<String> innerList = new Vector<String>();
			for (int i = 1; i <= col; i++) {
				innerList.add(rs.getString(i));
				
			}
			outerList.add(innerList);
			
			
		}
		return outerList;
		
	}
	public static Vector<String> getConstraintsMetaData() throws SQLException {
		Vector<String> vectorList = new Vector<String>();
		
		Connection con = DbUtil.getConn();
		PreparedStatement preStmt = con.prepareStatement(DbUtil.allConstraints());
		ResultSet rs = preStmt.executeQuery();
		
		ResultSetMetaData rsmd = rs.getMetaData();
		int j = rsmd.getColumnCount();
		for (int i = 1; i <= j; i++) {
			vectorList.add(rsmd.getColumnLabel(i));
		}	
		return vectorList;	
	}
	public static Vector<Vector<String>> getMaxRows() throws SQLException {
		Connection con = DbUtil.getConn();
		int col = 2;
	
		PreparedStatement preStmt = con.prepareStatement(DbUtil.mostRows());
		ResultSet rs = preStmt.executeQuery();
		Vector<Vector<String>> outerList = new Vector<Vector<String>>();
		
		while (rs.next()) {
			Vector<String> innerList = new Vector<String>();
			for (int i = 1; i <= col; i++) {
				innerList.add(rs.getString(i));
				
			}
			outerList.add(innerList);
			
			
		}
		return outerList;
	}
	public static Vector<String> getMaxRowsMetaData() throws SQLException {
		Vector<String> vectorList = new Vector<String>();
		
		Connection con = DbUtil.getConn();
		PreparedStatement preStmt = con.prepareStatement(DbUtil.mostRows());
		ResultSet rs = preStmt.executeQuery();
		
		ResultSetMetaData rsmd = rs.getMetaData();
		int j = rsmd.getColumnCount();
		for (int i = 1; i <= j; i++) {
			vectorList.add(rsmd.getColumnLabel(i));
		}	
		return vectorList;	
	}




	
}
