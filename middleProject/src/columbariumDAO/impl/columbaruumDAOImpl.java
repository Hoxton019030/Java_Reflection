package columbariumDAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ConnectSql.MyConnection_withDatabaseImp;
import columbariumDAO.columbariumDAO;
import columbariumDAO.bean.columbarium;

public class columbaruumDAOImpl implements columbariumDAO {

	@Override
	public columbarium selectColumbariumById(int columbariumid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<columbarium> selectAllColumbarium() {
		MyConnection_withDatabaseImp myconn = new MyConnection_withDatabaseImp();
		String sql = "SELECT * \r\n" + "  FROM [Columbarium].[dbo].[ColumbariumTable]";
		List<columbarium> columbariumList = new ArrayList<columbarium>();

		try {
			Connection conn = myconn.getConnect();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				columbarium c = new columbarium();
				c.setTown(rs.getString("鄉鎮市"));
				c.setPublicOrPrivacy(rs.getString("公立或私立"));
				c.setOwner(rs.getString("設施管理者"));
				c.setFacilityName(rs.getString("設施名稱"));
				c.setTelephone(rs.getString("電話"));
				columbariumList.add(c);
			}

			myconn.free(conn, stmt, rs);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return columbariumList;
	}

	@Override
	public boolean addcolumbarium(columbarium c) {
		String sql = "INSERT INTO[dbo].[ColumbariumTable] VALUES(?,?,?,?,?)\r\n" + "";
		boolean succeed = false;
		MyConnection_withDatabaseImp myconn = new MyConnection_withDatabaseImp();
		Connection conn = myconn.getConnect();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, c.getTown());
			pstmt.setString(2, c.getPublicOrPrivacy());
			pstmt.setString(3, c.getOwner());
			pstmt.setString(4, c.getFacilityName());
			pstmt.setString(5, c.getTelephone());
			int count = pstmt.executeUpdate();
			if (count > 1) {
				succeed = true;
			}

			return succeed;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return succeed;
	}

	@Override
	public boolean updateColumbarium(columbarium c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteColumbarium(int columbariumid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addJsoncolumbarium() {
		return false;
	
	}

}
