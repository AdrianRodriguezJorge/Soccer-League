package services;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import utils.Connection;

public class EnterpriseServices {
	
	//Este método utiliza una consulta estática
	public String getEnterpriseName() throws SQLException, ClassNotFoundException {

		java.sql.Connection connection = ServicesLocator.getConnection();
		Statement statement = connection.createStatement (ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY); 

		String query_to_execute = "SELECT empresa.nom_empresa FROM empresa WHERE empresa.cod_empresa = '01'"; 

		/*en este string se escribe exactamente cuál es la consulta que se desea ejecutar*/

		ResultSet result = statement.executeQuery(query_to_execute);
		result.first(); /* esto es necesario para que la clase ResultSet cargue el valor de resultado de la consulta*/
		String enterpriseName = result.getString(1); /*esto lo que hace es devolver el primer campo del ResultSet que es de tipo String. Si hubiera más campos se pone el número correspondiente y se utiliza el get del tipo de dato de ese campo. Por ejemplo si tuviera dos campo y el segundo es entero se pusiera resultado.getInt(2)*/
		
		result.close();
		statement.close();
		connection.close();
		
		return enterpriseName;
	}
	
    //Este método ejecuta una función creada en el postgres
	public LinkedList<String> getWorkersInEnterpriseBiggerThan(int cant) throws SQLException, ClassNotFoundException {
		LinkedList<String> enterprisesList = new LinkedList<String>();
		String function = "{?= call empresas_mayor_plantilla_que(?)}"; /*se establece con el primer ? que la función tiene valor de retorno, con el segundo ? se está especificando que es un parámetro que será pasado */
		java.sql.Connection connection = ServicesLocator.getConnection();
		connection.setAutoCommit(false);
		CallableStatement preparedFunction = connection.prepareCall(function);
		preparedFunction.registerOutParameter(1, java.sql.Types.OTHER); /*Se especifica que el primer ? es de tipo varchar, es decir que el valor de retorno es un varchar */
		preparedFunction.setInt(2, cant); /*Se establece que el segundo ? será la variable idObrero y que será el parámetro que se pase a la función creada en postgres*/
		preparedFunction.execute();
		ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
		while (resultSet.next()){
			enterprisesList.add(resultSet.getString(1));
		}
		resultSet.close();
		preparedFunction.close();
		connection.close();
		
		return enterprisesList;
	}

}
