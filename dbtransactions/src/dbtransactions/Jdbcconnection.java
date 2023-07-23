package dbtransactions;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbcconnection {
	
	public static Connection getConnection() throws SQLException,IOException{
		Connection con=null;
		Properties props=new Properties();
		FileInputStream fis=new FileInputStream("F://eclipse projects//dbtransactions//src//dbtransactions/jdbc.properties");
		props.load(fis);
		String url=props.getProperty("url");
		String user=props.getProperty("user");
		String password=props.getProperty("password");
		con=DriverManager.getConnection(url,user,password);
		if(con!=null){
			return con;
		}
		return con;
	}
	public static void closeConnection(ResultSet resultset,Statement stmt,Connection con)throws SQLException{
		if(resultset!=null) {
			resultset.close();
		}if(stmt!=null) {
			stmt.close();
		}if(con!=null) {
			con.close();
		}
		
	}
}
