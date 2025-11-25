/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package report;

import model.Mahasiswa;
import util.NewHibernateUtil;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import org.hibernate.Session;
import java.util.HashMap;
import java.util.List;

public class ReportGenerator {
    
    public static void generateReport() {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        
        try {
            System.out.println("===========================================");
            System.out.println("GENERATE LAPORAN MAHASISWA");
            System.out.println("===========================================");
            
            System.out.println("1. Memuat data mahasiswa dari database...");
            
            @SuppressWarnings("unchecked")
            List<Mahasiswa> listMahasiswa = session.createQuery("FROM Mahasiswa").list();
            
            System.out.println("   Data berhasil dimuat: " + listMahasiswa.size() + " records");
            
            if (listMahasiswa.isEmpty()) {
                System.out.println("   ERROR: Tidak ada data untuk ditampilkan!");
                return;
            }
            
            String reportPath = "reports/LaporanMahasiswa.jrxml";
            
            System.out.println("2. Compiling report template...");
            JasperReport jasperReport = JasperCompileManager.compileReport(reportPath);
            System.out.println("   Report template berhasil di-compile");
            
            System.out.println("3. Menyiapkan data source...");
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(listMahasiswa);
            
            HashMap<String, Object> parameters = new HashMap<>();
            
            System.out.println("4. Filling report dengan data...");
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
            System.out.println("   Report berhasil di-fill");
            
            System.out.println("5. Menampilkan report viewer...");
            JasperViewer viewer = new JasperViewer(jasperPrint, false);
            viewer.setTitle("Laporan Data Mahasiswa");
            viewer.setVisible(true);
            
            System.out.println("===========================================");
            System.out.println("LAPORAN BERHASIL DITAMPILKAN");
            System.out.println("===========================================\n");
            
        } catch (JRException e) {
            System.out.println("ERROR JasperReports: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    
    public static void exportToPDF(String outputPath) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        
        try {
            System.out.println("===========================================");
            System.out.println("EXPORT LAPORAN KE PDF");
            System.out.println("===========================================");
            
            System.out.println("1. Memuat data mahasiswa dari database...");
            
            @SuppressWarnings("unchecked")
            List<Mahasiswa> listMahasiswa = session.createQuery("FROM Mahasiswa").list();
            
            System.out.println("   Data berhasil dimuat: " + listMahasiswa.size() + " records");
            
            if (listMahasiswa.isEmpty()) {
                System.out.println("   ERROR: Tidak ada data untuk diekspor!");
                return;
            }
            
            String reportPath = "reports/LaporanMahasiswa.jrxml";
            
            System.out.println("2. Compiling report template...");
            JasperReport jasperReport = JasperCompileManager.compileReport(reportPath);
            
            System.out.println("3. Menyiapkan data source...");
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(listMahasiswa);
            
            HashMap<String, Object> parameters = new HashMap<>();
            
            System.out.println("4. Filling report dengan data...");
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
            
            System.out.println("5. Exporting to PDF...");
            JasperExportManager.exportReportToPdfFile(jasperPrint, outputPath);
            
            System.out.println("===========================================");
            System.out.println("PDF BERHASIL DISIMPAN");
            System.out.println("Lokasi: " + outputPath);
            System.out.println("===========================================\n");
            
        } catch (JRException e) {
            System.out.println("ERROR JasperReports: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
