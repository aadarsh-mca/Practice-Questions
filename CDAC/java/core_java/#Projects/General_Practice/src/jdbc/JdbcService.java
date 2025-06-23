package jdbc;

public class JdbcService {
	
	private static JdbcService instance;
	
	private JdbcService() {
	}

	public static JdbcService getInstance() {
		if(instance == null) {
			instance = new JdbcService();
		}
		return instance;
	}
	
	
}
