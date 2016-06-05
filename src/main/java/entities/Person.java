package entities;

import java.util.List;

public class Person {
	private String name;
	private String surname;
	private List<String> phoneNumbers;
	private List<Address> addresses;
	private Role role;
	private int age;

	public Person(String name, String surname, List<String> phoneNumbers,
			List<Address> addresses, Role role, int age) {
		this.name = name;
		this.surname = surname;
		this.phoneNumbers = phoneNumbers;
		this.addresses = addresses;
		this.role = role;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public Person setName(String name) {
		this.name = name;
		return this;
	}

	public String getSurname() {
		return surname;
	}

	public Person setSurname(String surname) {
		this.surname = surname;
		return this;
	}

	public List<String> getPhoneNumbers() {
		return phoneNumbers;
	}

	public Person setPhoneNumbers(List<String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
		return this;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public Person setAddresses(List<Address> addresses) {
		this.addresses = addresses;
		return this;
	}

	public Role getRole() {
		return role;
	}

	public Person setRole(Role role) {
		this.role = role;
		return this;
	}

	public int getAge() {
		return age;
	}

	public Person setAge(int age) {
		this.age = age;
		return this;
	}
}