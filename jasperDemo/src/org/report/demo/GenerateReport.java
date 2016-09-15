package org.report.demo;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;

public class GenerateReport {

	public static void main(String[] args) {
		GenerateReport classs = new GenerateReport();
		classs.generateReport();
	}
	
	public void generateReport() {
		try {
			
			DemoListDao daoObj = new DemoListDaoImpl();
			List<ReportDemoBo> myList = daoObj.getListData();
			
			Map<String, Object> dataMap=new HashMap<String, Object>();
			dataMap.put("table","---Table---");
			 // Make sure the output directory exists.
		       File outDir = new File("/usr/jasperoutput");
		       outDir.mkdirs();
			JasperPrint jasperPrint=JasperFillManager.fillReport("/usr/reportDemo.jasper", dataMap,new JRBeanArrayDataSource(myList.toArray()));
			JasperExportManager.exportReportToPdfFile(jasperPrint,"/usr/jasperoutput/StyledTextReport.pdf");
		       System.out.println("Done!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
