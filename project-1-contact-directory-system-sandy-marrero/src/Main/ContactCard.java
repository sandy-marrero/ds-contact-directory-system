package Main;

import java.util.Date;

import DataStructures.List.LinkedList;
import DataStructures.List.DoublyLinkedList;
/**
 * Contact Card Class to hold all the information 
 * regarding one contact inside the directory
 * 
 * @author bermed28 & ADD YOUR NAME HERE
 */
public class ContactCard {
	/*TODO ADD YOUR CODE HERE*/
	private int ID;
	private String name;
	private String title;
	private String email;
	private String phone;
	private Date birthday;
	private DoublyLinkedList<ContactCard> friends;

	public ContactCard(int ID, String name, String title, String phone, String email, Date birthday, DoublyLinkedList<ContactCard> friends) {
	this.setID(ID);
	this.setName(name);
	this.setJobTitle(title);
	this.setPhone(phone);
	this.setEmail(email);
	this.setBirthday(birthday);
	this.setFriends(friends);
	
	}
	public ContactCard(int ID) {
		this.setID(ID);
		this.setName(null);
		this.setJobTitle(null);
		this.setPhone(null);
		this.setEmail(null);
		this.setBirthday(null);
		this.setFriends(null);
	}

	public String getJobTitle() {
		return title;
	}

	public void setJobTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public DoublyLinkedList<ContactCard> getFriends() {
		return friends;
	}

	public void setFriends(DoublyLinkedList<ContactCard> friends) {
		this.friends = friends;
	}
}
