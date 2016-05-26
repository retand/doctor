package org.example.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class DoctorAction extends ActionSupport {
	static HashMap<Date, String> dates = new HashMap<Date, String>();
	private String selectedDate2;
	static SimpleDateFormat ft = new SimpleDateFormat("MM/dd/yyyy HH:mm");
	
	public static HashMap<Date, String> getDates() {
		return dates;
	}

	public static void setDates(HashMap<Date, String> dates) {
		DoctorAction.dates = dates;
	}

	public String getSelectedDate2() {
		return selectedDate2;
	}

	public void setSelectedDate2(String selectedDate2) {
		this.selectedDate2 = selectedDate2;
	}

	private void init(){
		dates = ReserveAction.readHashMapFromFile();
	}
	
	@Override
	public String execute() throws Exception {
		init();
		Map<Date, Integer> m1 = new TreeMap(dates);
	    DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
	    
//	    for (Map.Entry<Date, Integer> entry : m1.entrySet())
//	    {
//	        System.out.println(df.format(entry.getKey()));
//	    }
	    HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("sortedDates", m1);
		request.setAttribute("selectedDate2", ft.parse(selectedDate2));
		return super.execute();
	}
	
	
}
