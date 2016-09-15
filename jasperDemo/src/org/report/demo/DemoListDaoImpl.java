package org.report.demo;

import java.util.ArrayList;
import java.util.List;

public class DemoListDaoImpl implements DemoListDao {

	public List<ReportDemoBo> getListData() { 
		
		List<ReportDemoBo> ls = new ArrayList<ReportDemoBo>();
		int i =1;
		int j = 1;
		while(i<=10){
			ReportDemoBo bo = new ReportDemoBo();
			bo.setTable(j +"          X");
			bo.setResult(i*j);
			ls.add(bo);
			i++;
		}
		 
		return ls;
	}

}
