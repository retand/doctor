package org.example.action;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import com.opensymphony.xwork2.ActionSupport;

import Data.User;

public class SignUpAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String password2;
	private String firstName;
	private String lastName;

	HashMap<String, User> users = new HashMap<>();

	@Override
	public String execute() throws Exception {
		
		users.put(username, new User(username, password, firstName, lastName));
		
		writeHashMapInFile(users);

		return SUCCESS;
	}

	@Override
	public void validate() {
		users = readHashMapFromFile();
		
		if (org.apache.commons.lang3.StringUtils.isEmpty(getUsername()) || username.length() < 3) {
			addFieldError("username", "Username have to be atleast 3 symbols!");
		}
		
		if(firstName.isEmpty()){
			addFieldError("firstName", "Fill this information.");
		}
		
		if(lastName.isEmpty()){
			addFieldError("lastName", "Fill this information.");
		}
		
		if (!password.equals(password2) || password.isEmpty() || password2.isEmpty()) {
			addFieldError("password", "Password doesn't match");
		}
		
		if(users.containsKey(username)){
			addFieldError("username", "Username is used!");
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	private void writeHashMapInFile(HashMap<String, User> users) {
		try {
			FileOutputStream fileOut = new FileOutputStream("D:/users.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(users);
			out.close();
			fileOut.close();
			System.out.printf("Serialized data is saved in users.ser");
		} catch (IOException i) {
			i.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public static HashMap<String, User> readHashMapFromFile() {

		HashMap<String, User> e = null;
		try {
			FileInputStream fileIn = new FileInputStream("D:/users.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			e = (HashMap<String, User>) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException i) {
			i.printStackTrace();
		} catch (ClassNotFoundException c) {
			System.out.println("Employee class not found");
			c.printStackTrace();
		}
		return e;

	}

}
