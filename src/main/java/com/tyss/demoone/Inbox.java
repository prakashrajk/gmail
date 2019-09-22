package com.tyss.demoone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "inbox")
public class Inbox {

	@Id
	@Column
	private int Message_Id;
	@Column
	private int User_Id;
	@Column
	private String Message;
	public int getMessage_Id() {
		return Message_Id;
	}
	public void setMessage_Id(int message_Id) {
		Message_Id = message_Id;
	}
	public int getUser_Id() {
		return User_Id;
	}
	public void setUser_Id(int user_Id) {
		User_Id = user_Id;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
}
