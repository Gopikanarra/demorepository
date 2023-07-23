package dbtransactions;

import java.sql.*;
import java.util.Scanner;

public class TransactionDemo {

	public static void main(String[] args) throws SQLException {
		Connection con=null;
		Statement stmt=null;
		ResultSet resultset=null;
		ResultSet resultset1=null;
		Scanner sc=null;
		String option=null;
		
		try {
		   con=Jdbcconnection.getConnection();
		   if(con!=null) {
			   stmt=con.createStatement();
			   System.out.println("data before transaction:");
			   resultset=stmt.executeQuery("select name,salary from transdata");
			   System.out.println("Data After Transaction");
			   
			   System.out.println("name\tsalary");
			   System.out.println("-----------------------");
			   while(resultset.next()) {
				   System.out.println(resultset.getString(1)+"\t"+resultset.getInt(2));
			   }
		   
		  con.setAutoCommit(false);
		 stmt.executeUpdate("update transdata set salary=salary+300 where name='arun'");
		 stmt.executeUpdate("update transdata set salary=salary-300 where name='tom'");
		  sc=new Scanner(System.in);
		  System.out.println("Can u please confirm the transaction of 300... [YES/NO]");
		  option= sc.nextLine();
		if(option.equalsIgnoreCase("yes")) {
			con.commit();
			System.out.println("transaction commited");
		}else {
			con.rollback();
			System.out.println("transaction rollback");
		}
		
		 resultset1=stmt.executeQuery("select name,salary from transdata");
		 System.out.println("Data After Transaction");
		   System.out.println("name\tsalary");
		   System.out.println("-----------------------------------------");
		   while(resultset1.next()) {
			   System.out.println(resultset1.getString(1)+"\t"+resultset1.getInt(2));
		   } 
		   }
		}catch(SQLException s) {
			s.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			Jdbcconnection.closeConnection(resultset, stmt, con);
		}

	}

}
