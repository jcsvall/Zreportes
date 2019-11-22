/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcsvall.datasource;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author scjuan
 */
public class App {
    
    private static final String REPORT_PATH = "C:\\Users\\scjuan\\Documents\\NetBeansProjects\\Zreportes\\src\\main\\java\\com\\jcsvall\\zreportes\\citestR.jrxml";
    private static final String REPORT_EXPORT_PATH = "C:\\Users\\scjuan\\Documents\\NetBeansProjects\\Zreportes\\src\\main\\java\\com\\jcsvall\\zreportes\\test.pdf";

    public static void main(String[] args) {
        System.out.println("test");
        String directorioRaiz = System.getProperty("user.dir");
        System.out.println("Directorio de trabajo = " + directorioRaiz);
        probarReporte();
    }

    public static void probarReporte() {
        List<SolicitudCitesPojo> citesList = new ArrayList<>();
        SolicitudCitesPojo ciObject = new SolicitudCitesPojo();

        ciObject.setImportacion("X");
        ciObject.setExportacion("");
        ciObject.setReExportacion("");
        ciObject.setOtros("");
        ciObject.setPermisoCertificado("permisoCertificado");
        ciObject.setValidoHasta("validoHasta");
        ciObject.setImportador("Wallmart S.A de C.V");
        ciObject.setExportador("Dell International");
        ciObject.setPaisDeImportacion("EL Guatemala");
        ciObject.setEstampillaSeguridad("1234589");
        ciObject.setValidoHasta("05/03/2019");
        ciObject.setNumeroCertificado("125489");
        ciObject.setCodicionesEspeciales("Testing");
        ciObject.setNombreCientificoA("Phalaenopsis sp\nPLANTA DE ORQUIDEA PHALAENOPSIS YU PIN ACACIA SIN TIERRA");

        citesList.add(ciObject);
        try {
          JRDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(citesList);
            String path="C:\\Users\\scjuan\\Documents\\NetBeansProjects\\Zreportes\\src\\main\\java\\com\\jcsvall\\zreportes\\citestR.jasper";
            String path2="C:\\Users\\scjuan\\Documents\\NetBeansProjects\\Zreportes\\src\\main\\java\\com\\jcsvall\\zreportes\\citestR.jasper";
            //JasperReport jrt = (JasperReport) JRLoader.loadObject(App.class.getResource("com/jcsvall/zreportes/citestR.jasper"));
            //dentro
            InputStream jasperStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("\\com\\jcsvall\\zreportes\\citestR.jasper");
           // URL in = this.getClass().getResource("Reporte_uno.jasper");
            //fuera
            File file = new File(path2);
            //JasperReport report = (JasperReport) JRLoader.loadObject(new File("jasperFolder/HibernateQueryDemoReport.jasper");
            JasperReport jr = (JasperReport) JRLoader.loadObject(file);
            Map params = new HashMap();
            
            String pathImgSv = "C:\\Users\\scjuan\\Documents\\NetBeansProjects\\Zreportes\\elSalvadorEscudo.jpg";        
            String pathImgCites = "C:\\Users\\scjuan\\Documents\\NetBeansProjects\\Zreportes\\CITES_logo.jpg";       
            params.put("PATH_IMG_LOGOSV", pathImgSv);
            params.put("PATH_IMG_CITES", pathImgCites);
            
            JasperPrint jp = JasperFillManager.fillReport(jr, params, beanCollectionDataSource);
            JasperViewer jv = new JasperViewer(jp);
            jv.show();
            
            /*JRExporter exporter = new JRPdfExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
        exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("reporte2PDF.pdf"));
        exporter.exportReport();*/
 
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
//    public static void getReport(){
//    JRDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(citesList);
//            String path="C:\\Users\\scjuan\\Documents\\NetBeansProjects\\Zreportes\\src\\main\\java\\com\\jcsvall\\zreportes\\citestR.jasper";
//            String path2="C:\\Users\\scjuan\\Documents\\NetBeansProjects\\Zreportes\\src\\main\\java\\com\\jcsvall\\zreportes\\citestR.jasper";
//            //JasperReport jr = (JasperReport) JRLoader.loadObject(App.class.getResource("/zreportes/citestR.jasper"));
//            //dentro
//            InputStream jasperStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("com/jcsvall/zreportes/citestR.jasper");
//            //fuera
//            File file = new File(path2);
//            //JasperReport report = (JasperReport) JRLoader.loadObject(new File("jasperFolder/HibernateQueryDemoReport.jasper");
//            JasperReport jr = (JasperReport) JRLoader.loadObject(file);
//            Map params = new HashMap();
//            JasperPrint jp = JasperFillManager.fillReport(jr, params, beanCollectionDataSource);
//            JasperViewer jv = new JasperViewer(jp);
//            jv.show();
//    }
}
