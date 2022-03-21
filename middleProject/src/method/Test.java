package method;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import columbariumDAO.columbariumDAO;
import columbariumDAO.bean.columbarium;
import columbariumDAO.impl.columbaruumDAOImpl;
import url.Url;

public class Test {
	
	public static void main(String[] args) {
		Test test = new Test();
//		test.test2();
		test.test3();
		
		
	}
	public void test2() {
		Url url = new Url();
		String jString = url.getJsonString();
		try {
			JSONArray jsonArray = new JSONArray(jString);
			JSONObject jobject = jsonArray.getJSONObject(4);
			System.err.println(jobject);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void test3() {
		Url url = new Url();
		String jString = url.getJsonString();
		try {
			JSONArray jsonArray = new JSONArray(jString);
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jObject = jsonArray.getJSONObject(i);

				String town = jObject.getString("鄉鎮市");
				String publicOrPrivacy = jObject.getString("公立或私立");
				String owner = jObject.getString("設施管理者");
				String facilityName = jObject.getString("設施名稱");
				String telephone = jObject.getString("電話");

				columbarium col = new columbarium();
				col.setTown(town);
				col.setPublicOrPrivacy(publicOrPrivacy);
				col.setOwner(owner);
				col.setFacilityName(facilityName);
				col.setTelephone(telephone);
				columbariumDAO cDAO = new columbaruumDAOImpl();
				cDAO.addcolumbarium(col);
			}
			System.out.println("JSON資料已匯入SQL");

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
