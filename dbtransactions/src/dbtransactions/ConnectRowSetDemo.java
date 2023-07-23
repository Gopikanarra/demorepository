package dbtransactions;

import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class ConnectRowSetDemo {

	public static void main(String[] args) throws SQLException {
		RowSetFactory factory=RowSetProvider.newFactory();
		JdbcRowSet jdbcrowset=factory.createJdbcRowSet();
		jdbcrowset.setUrl("jdbc:mysql:///ineuron");
		jdbcrowset.setUsername("root");
		jdbcrowset.setPassword("gopikapassword");
		jdbcrowset.setCommand("select e_id,e_name,e_dept,c_id from emp");
		jdbcrowset.execute();
		System.out.println("emp details are:");
		while(jdbcrowset.next()) {
			System.out.println(jdbcrowset.getInt(1)+"\t"+jdbcrowset.getString(2)+"\t"+jdbcrowset.getString(3)+"\t"+jdbcrowset.getInt(4));
		}
		
		
		System.out.println();

		
		//insert code
//		jdbcrowset.moveToInsertRow();
//		jdbcrowset.updateInt(1,122);
//		jdbcrowset.updateString(2,"ram's");
//		jdbcrowset.updateString(3,"inf");
//		jdbcrowset.updateInt(4,101);
//		
//		
//		jdbcrowset.insertRow();
//		System.out.println("updated successfully");
		
		//taking cursor to 1 st row
		jdbcrowset.absolute(1);
		System.out.println(jdbcrowset.getString(2));
		jdbcrowset.deleteRow();
		System.out.println("row deleted successfully!!");
		
	}

}
