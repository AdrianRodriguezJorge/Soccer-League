package services;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import utils.Connection;

public class WorkerServices {

    //Este método emplea una consulta con parámertos
	public LinkedList getWorkersWithSalaryBiggerThanX(float salary) throws SQLException, ClassNotFoundException {
		LinkedList workersList = new LinkedList();
		java.sql.Connection connection = ServicesLocator.getConnection();
		String sql = "SELECT obrero.nom_obrero FROM obrero " +
				"INNER JOIN obrero_agricola ON obrero_agricola.cod_obrero = obrero.cod_obrero " +
				"WHERE obrero_agricola.salario > ?"; /*Los símbolos ? indican los parámetros que se van a pasar */
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setFloat(1, salary); /* estamos dándole valor al primer parametro que se pasa, es decir al primer ? que aparezca. */
		statement.execute();
		ResultSet result = statement.getResultSet();
		String nombre;
		while (result.next()) {//Son sentencias para mostrar el nombre de los obreros.
			nombre = result.getString(1);
			workersList.add(nombre);
		}
		result.close();
		statement.close();
		connection.close();
		
		return workersList;
	}
}
