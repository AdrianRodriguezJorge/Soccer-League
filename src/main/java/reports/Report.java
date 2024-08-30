// package reports;

// import net.sf.jasperreports.engine.*;
// import utils.ConnectionManager;

// import Connection;
// import java.util.HashMap;

// /**
//  * Clase para la generación de reportes utilizando JasperReports.
//  */
// public class Report {
//     /**
//      * Método que genera y muestra un reporte.
//      *
//      * @param reportPath Ruta del archivo .jasper del reporte.
//      * @param parameters Parámetros que el reporte necesita.
//      */
//     public static void generateReport(String reportPath, HashMap<String, Object> parameters) {
//         try {
//             Connection conn = ConnectionManager.getConnection();
//             JasperPrint jasperPrint = JasperFillManager.fillReport(reportPath, parameters, conn);
//             JasperViewer.viewReport(jasperPrint, false);
//         } catch (JRException e) {
//             e.printStackTrace();
//         }
//     }
// }
