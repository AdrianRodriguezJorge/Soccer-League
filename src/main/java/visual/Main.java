package visual;

import java.sql.SQLException;
import java.util.LinkedList;

import services.EnterpriseServices;
import services.ServicesLocator;
import services.WorkerServices;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//C�digo destinado a crear las instancias de las clases de servicios, para acceder mediante ellos a sus m�todos...
			EnterpriseServices enterpriseServices = ServicesLocator.getEnterpriseServices();
			WorkerServices workerServices = ServicesLocator.getWorkerServices();
			
			//M�todo que devuelve los obreros que poseen un salario mayor que un valor entrado como par�metro...
			float salario = 500;
			LinkedList<String> list = workerServices.getWorkersWithSalaryBiggerThanX(salario);
			System.out.println("Obreros que poseen un salario mayor que " + salario);
			for (String string : list) {
				System.out.println(string);
			}
			
			System.out.println("\n");
			//M�todo que devuelve el nombre de la empresa de c�digo 01.
			String Name = enterpriseServices.getEnterpriseName();
			System.out.println("M�todo que devuelve el nombre de la empresa de c�digo 01.");
			System.out.println(Name);
			
			//M�todo que devuelve las empresas con una cantidad de trabajadores mayor que un valor dado por par�metro...
			System.out.println("\n");
			int cant = 1;
			LinkedList<String> list2 = enterpriseServices.getWorkersInEnterpriseBiggerThan(cant);
			System.out.println("Empresas que poseen contratados una cantidad de obreros superior a: " + cant);
			for (String string : list2) {
				System.out.println(string);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 

	}

}
