package dbtransactions;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Savepoint;

public class SavePointDemo {

	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		try {
			con=Jdbcconnection.getConnection();
			con.setAutoCommit(false);
			stmt=con.createStatement();
			stmt.executeUpdate("insert into tempdata values ('wed',39)");
			stmt.executeUpdate("insert into tempdata values('thu',44)");
			Savepoint sv=con.setSavepoint();
			stmt.executeUpdate("insert into tempdata values('thu',24)");
			System.out.println("oh something went wrong so rollback");
			con.rollback(sv);
			con.commit();
		}catch(SQLException s) {
			s.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
