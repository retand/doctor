package org.example.action;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import Data.User;

public class ReserveAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5727080855805737128L;
	private String selectedDate;
	private String selectedDate2;
	private Map<String, Object> sessionMap;
	static HashMap<Date, String> dates = new HashMap<Date, String>();
	static SimpleDateFormat ft = new SimpleDateFormat("MM/dd/yyyy HH:mm");
	private String reason;
	// For SessionAware
	Map<String, Object> session;

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public void show() {
		init();
				
		SimpleDateFormat ft = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		System.out.println("show executed");

		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("dates", ReserveAction.dates);
		request.setAttribute("user", (User) session.get("user"));
		
		
		try {
			request.setAttribute("selectedDate", ft.parse(this.selectedDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public String getSelectedDate2() {
		return selectedDate2;
	}

	public void setSelectedDate2(String selectedDate2) {
		this.selectedDate2 = selectedDate2;
	}

	private void init() {
		ReserveAction.dates = readHashMapFromFile();

	}

	public Map<String, Object> getSessionMap() {
		return sessionMap;
	}

	public void setSessionMap(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}

	@Override
	public String execute() throws Exception {
		show();
		
		User user =(User) session.get("user");
		
		
		System.out.println(selectedDate);
		System.out.println(reason);

		Date searchDate = ft.parse(selectedDate);
		searchDate.setMinutes(0);

		System.out.println(searchDate);
		if (dates.containsKey(searchDate)) {
			return "fail";
		}

		dates.put(searchDate,String.format("%s %s: %s", user.getFirstName(),user.getLastName(),reason));
		
		writeHashMapInFile(dates);
		return "success";
	}

	private void writeHashMapInFile(HashMap<Date, String> dates2) {
		try {
			FileOutputStream fileOut = new FileOutputStream("D:/dates.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(dates2);
			out.close();
			fileOut.close();
			System.out.printf("Serialized data is saved in dates.ser");
		} catch (IOException i) {
			i.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public static HashMap<Date, String> readHashMapFromFile() {

		HashMap<Date, String> e = null;
		try {
			FileInputStream fileIn = new FileInputStream("D:/dates.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			e = (HashMap<Date, String>) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException i) {
			i.printStackTrace();
		} catch (ClassNotFoundException c) {
			System.out.println("Employee class not found");
			// c.printStackTrace();
		}
		return e;

	}

	public String getSelectedDate() {
		return selectedDate;
	}

	public void setSelectedDate(String selectedDate) {
		this.selectedDate = selectedDate;
	}

}
