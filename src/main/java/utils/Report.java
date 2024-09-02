package utils;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.sql.Connection;
import java.util.Map;

public class Report {

    /**
     * Método para generar y visualizar un reporte dado el nombre del archivo Jasper y los parámetros.
     * 
     * @param reportPath Ruta al archivo .jasper del reporte.
     * @param parametros Parámetros necesarios para el reporte.
     * @param conn Conexión a la base de datos.
     * @throws JRException Si ocurre un error durante la generación del reporte.
     */
    public static void mostrarReporte(String reportPath, Map<String, Object> parametros, Connection conn) throws JRException {
        // Cargar y llenar el reporte
        JasperPrint jasperPrint = JasperFillManager.fillReport(reportPath, parametros, conn);

        // Crear una ventana para mostrar el reporte
        JasperViewer viewer = new JasperViewer(jasperPrint, false);
        viewer.setTitle("Reporte");
        viewer.setVisible(true);
    }
}
