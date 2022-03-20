package testZone;

import columbariumDAO.impl.columbaruumDAOImpl;
import method.DataCRUD.JsonData;

public class test {
	public static void main(String[] args) {
		JsonData jData = new JsonData();
		columbaruumDAOImpl cDAO = new columbaruumDAOImpl();
		
		System.out.println(cDAO.selectAllColumbarium());
		
	}

}
