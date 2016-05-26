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
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import Data.User;

public class LoginAction extends ActionSupport implements SessionAware {
	private String userId;
	private String password;
	HashMap<String, User> users = new HashMap<>();
	// For SessionAware
	Map<String, Object> session;

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@Override
	public void validate() {

		// if(org.apache.commons.lang3.StringUtils.isEmpty(getUserId())){
		// addFieldError("userId", "Username have to be atleast 3 symbols!");
		// }
	}

	public String signUp() {
		return "signUp";
	}

	public String execute() {
		System.out.println("execute()");
		users = SignUpAction.readHashMapFromFile();

		User user = users.get(userId);
		session.put("user", (User) user);
		
		if(userId.equals("doctor")){
			HashMap<Date, String> dates = new HashMap<Date, String>();
			dates = ReserveAction.readHashMapFromFile();
					
			Map<Date, String> m1 = new TreeMap(dates);
		    DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		    
		    session.put("sortedDates", m1);
		    HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("sortedDates", m1);
		    
		    for (Map.Entry<Date, String> entry : m1.entrySet())
		    {
		        System.out.println(df.format(entry.getKey()));
		    }
			return "doctor";
		}
		
		if (user == null) {
			return "failure";
		} else if (user.getPassword().equals(password)) {
			return SUCCESS;
		}
		
		

		return "failure";
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getTodayDate() {
		return new Date();
	}

	public String display() {
		return "none";
	}
}
