package services;

import java.sql.SQLException;

import utils.Connection;

public class ServicesLocator {
	private static EnterpriseServices enterpriseServices = null;
	private static WorkerServices workerServices = null;
	
	public static EnterpriseServices getEnterpriseServices(){
		if(enterpriseServices == null){
			enterpriseServices = new EnterpriseServices();
		}
		return enterpriseServices;
	}
	
	public static WorkerServices getWorkerServices(){
		if(workerServices == null){
			workerServices = new WorkerServices();
		}
		return workerServices;
	}
	
	public static java.sql.Connection getConnection(){
		Connection connection = null;
		try {
			connection = new Connection("localhost", "Agricola", "postgres", "postgres");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection.getConnection();
	}

}
