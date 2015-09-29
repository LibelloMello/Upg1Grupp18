package _DALuppgift2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	private static String connStr = "jdbc:sqlserver://localhost:1433;databaseName=apa;user=nav;password=abc123;";

	public static Connection getConn() throws SQLException {
		return (Connection) DriverManager.getConnection(connStr);
	}

	public static String innehallEmp() {
		return "SELECT * FROM sys.objects WHERE name like '%AB$Employee%'";
	}

	// Fråga 1
	public static String allKeys() {
		return "SELECT TABLE_NAME, COLUMN_NAME FROM INFORMATION_SCHEMA.KEY_COLUMN_USAGE";
	}
	
	// Fråga 2
	public static String allIndexes() {
		return "SELECT * FROM sys.indexes";
	}

	//Fråga 3
	public static String allConstraints() {
		return "SELECT TABLE_NAME, CONSTRAINT_CATALOG, CONSTRAINT_SCHEMA, CONSTRAINT_NAME, TABLE_CATALOG FROM INFORMATION_SCHEMA. CONSTRAINT_TABLE_USAGE";
	}
	//Fråga 4alt1
	public static String allTables() {
		return "SELECT* FROM INFORMATION_SCHEMA. TABLES";
	}
	//Fråga 4 alt2
	public static String allTablesAlt2() {
		return "select name from sys.tables";
	}
	
	//Fråga 5 alt1
	public static String allColumnsEmp () {
		return "SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = 'CRONUS Sverige AB$Employee'";
	}
	//Fråga 5 alt2
	public static String allColumsEmpAlt2() {
		return "select sc.name from sys.columns sc INNER JOIN sys.tables st ON st.object_id = sc.object_id WHERE st.name = 'CRONUS Sverige AB$Employee'";
	}
	
	
	//Fråga 6
	public static String mostRows() {
		return "SELECT so.Name, si.rows FROM sysobjects so, sysindexes si WHERE so.xtype = 'U' AND si.id = OBJECT_ID(so.Name) AND si.rows = (SELECT MAX(rows) FROM sysindexes) GROUP BY so.Name, si.rows";
	}
	
	public static String allEmployee () {
		return "SELECT [First Name], [Middle Name], [Last Name], [Job Title], Address FROM [CRONUS Sverige AB$Employee]";
	}

	public static String allAbsence () {
		return "SELECT [Entry No_], [Employee No_], [Cause of Absence Code], [From Date], [To Date] FROM [CRONUS Sverige AB$Employee Absence]";
	}

			public static String allPortal () {
		return "SELECT [timestamp], [Primary Key], [Search Limit], [Back End Private Key], [Temp_ SharePoint Site Name] FROM [CRONUS Sverige AB$Employee Portal Setup]";
	}

			public static String allQualification () {
		return "SELECT [Employee No_], [Line No_], [Qualification Code], [From Date], [To Date] FROM [CRONUS Sverige AB$Employee Qualification]";
	}

			public static String allRelative () {
		return  "SELECT [Employee No_], [Line No_], [Relative Code], [First Name], [Last Name] FROM [CRONUS Sverige AB$Employee Relative]";
	}
		
			public static String allStatistics () {
		return "SELECT [timestamp], [Code], [Description], '','' FROM [CRONUS Sverige AB$Employee Statistics Group]";
	}	
	
}



