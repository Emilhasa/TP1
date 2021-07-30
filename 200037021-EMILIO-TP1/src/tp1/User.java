package tp1;

import java.util.Scanner;

public class User {
	Scanner input = new Scanner(System.in);
	
	private String name;
	private String address;
	private String telephone;
	
	public User(String name, String address, String telephone) {
		this.setName(name.toUpperCase());
		this.setAddress(address.toUpperCase());
		this.setTelephone(telephone);
	}
	
	public void setName(String name) {
		this.name = name.toUpperCase();
	}
	
	public String getName() {
		return name;
		
	}
	
	public void setAddress(String address) {
		this.address = address.toUpperCase();
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public String getTelephone() {
		return telephone;
	}
		
	public void data() {
		System.out.println("Nome: " + this.name);
		System.out.println("Endereço: " + this.address);
		System.out.println("Telefone: " + this.telephone);
	}
	
}
