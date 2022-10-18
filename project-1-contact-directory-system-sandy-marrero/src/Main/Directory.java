package Main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import DataStructures.List.DoublyLinkedList;
import DataStructures.List.LinkedList;
import DataStructures.List.List;

public class Directory implements BaseDirectory {
	DoublyLinkedList<ContactCard> users = new DoublyLinkedList<ContactCard>();
	@Override
	public void createDirectory(String path){
		// TODO Auto-generated method stub
		String[] contactInfo;
		try {
			File file = new File(path);
			FileReader fileReader = new FileReader(file);
			BufferedReader x = new BufferedReader(fileReader);
			String[] arrContacts;
			String line;

			while((line = x.readLine())!=null){
				String[] l = line.split("\n");
				for(int i=0;i<l.length;i++) {
					contactInfo = l[0].split(",");
					String[] calendar = contactInfo[5].split("-");
					Date date = setDate(Integer.parseInt(calendar[0]), Integer.parseInt(calendar[1]), Integer.parseInt(calendar[2]));
					DoublyLinkedList<ContactCard> fav = new DoublyLinkedList<ContactCard>();
					if(Arrays.copyOfRange(contactInfo,6,contactInfo.length).length>0) {
						for(int j = 6;j<contactInfo.length;j++) {
							ContactCard n = new ContactCard(Integer.parseInt(contactInfo[j]));
							fav.add(n);
						}
						ContactCard newUser = new ContactCard(Integer.parseInt(contactInfo[0]),contactInfo[1],contactInfo[2],contactInfo[3],contactInfo[4],date,fav);
						users.add(newUser);
						//System.out.println("contact");

					}else {
						DoublyLinkedList<ContactCard> c = new DoublyLinkedList<>();
						ContactCard newUser = new ContactCard(Integer.parseInt(contactInfo[0]),contactInfo[1],contactInfo[2],contactInfo[3],contactInfo[4],date,c);
						users.add(newUser);
					}


				}
			}
			for(int i=0;i<users.size();i++) {
				ContactCard u = users.get(i);
				//System.out.println(u.getName());
				//System.out.println(u.getFriends().size());
				DoublyLinkedList<ContactCard> fri = new DoublyLinkedList<>();
				for(int j=0;j<u.getFriends().size();j++) {
					ContactCard full = findByID(users,u.getFriends().get(j).getID());
					//System.out.println(full.getID() + " " + full.getName());
					fri.add(full);
				}
				u.setFriends(fri);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<ContactCard> recommendedFriends(ContactCard contact) {
		// TODO Auto-generated method stub
		//		Node<ContactCard> head = friends1.get(0);
		//		for(int i=0;i<friends1.size();i++) {
		//			head = friends1.
		//		}
		return null;
	}
	public ContactCard findByID(DoublyLinkedList<ContactCard> list,int ID) {
		for(int i=0;i<list.size();i++) {
			ContactCard x = list.get(i);
			if(x.getID()==ID) {
				//System.out.println("id "+ x.getID() + " ,"+ ID);
				return x;
			}
		}
		return null;
	}
	@Override
	public List<ContactCard> commonFriends(ContactCard c1, ContactCard c2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContactCard> shareBirthdays(ContactCard contact) {
		// TODO Auto-generated method stub
		DoublyLinkedList<ContactCard> shared = new DoublyLinkedList<>();
		for(int i =0;i<users.size();i++) {
			System.out.println("birthdays" + users.get(i).getID() + " " + contact.getID());
			if(users.get(i).getBirthday().equals(contact.getBirthday())) {
				System.out.println("birthdays" + users.get(i).getBirthday() + users.get(i).getID() + " " + contact.getID());
				System.out.println(contact.getBirthday());
				shared.add(users.get(i));
			}
		}
		System.out.println(shared.size());
		return shared;
	}

	public static Date setDate(int year, int month, int day) {
		return new Date(year-1900,month,day);
	}

	public List<ContactCard> getContacts() {
		// TODO Auto-generated method stub
		return users;
	}

}
