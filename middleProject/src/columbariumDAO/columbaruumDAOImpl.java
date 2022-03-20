package columbariumDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import ConnectSql.MyConnection_withDatabaseImp;
import columbariumDAO.bean.columbarium;

public class columbaruumDAOImpl implements columbariumDAO {

	@Override
	public columbarium selectColumbariumById(int columbariumid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<columbarium> selectAllColumbarium() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addcolumbarium(columbarium c) {
		String sql="INSERT INTO[dbo].[ColumbariumTable] VALUES(?,?,?,?)\r\n"
				+ "";
		boolean succeed= false;
		MyConnection_withDatabaseImp myconn = new MyConnection_withDatabaseImp();
		Connection conn = myconn.getConnect();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,c.getTown());
			pstmt.setString(2,c.getPublicOrPrivacy());
			pstmt.setString(3,c.getFacilityName());
			pstmt.setString(4,c.getTelephone());
			int count = pstmt.executeUpdate();
			if(count>1) {
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

}
