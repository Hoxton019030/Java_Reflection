package SQL;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import ConnectSql.MyConnection;
import ConnectSql.MyConnection_withDatabaseImp;

public class CRUD_Table {

	
	public void CreateTable() {
		String sql ="USE Columbarium\r\n"
				+ "Create table ColumbariumTable\r\n"
				+ "(編號 int NOT NULL IDENTITY PRIMARY KEY,\r\n"
				+ "鄉鎮市 varchar(10),\r\n"
				+ "公立或私立 char(10),\r\n"
				+ "設施名稱 varchar(50),\r\n"
				+ "電話 varchar(12)\r\n"
				+ ")";
			try {
				MyConnection myconn = new MyConnection_withDatabaseImp();
				Connection conn = myconn.getConnect();
				Statement stmt;
				stmt = conn.createStatement();
				stmt.executeUpdate(sql);
				System.out.println("Table created successfully...");
				myconn.free(conn, stmt, null);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			// TODO Auto-generated catch block
	}

}
