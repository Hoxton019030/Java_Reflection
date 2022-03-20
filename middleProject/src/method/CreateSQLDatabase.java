package method;

import SQL.CRUD_Database;

public class CreateSQLDatabase {
	public static void main(String[] args) {
		CRUD_Database database = new CRUD_Database();
		database.createDatabase();
	}

}
