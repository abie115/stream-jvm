package service;

import java.util.Arrays;
import java.util.List;

import entities.Address;
import entities.Permission;
import entities.Person;
import entities.Role;
import entities.User;

public class UserData {
	public List<User> getUsers() {
		List<Address> addresses = Arrays.asList(new Address("Konopnickiej", 1,
				2, "Swidnica", "11-111", "Polska"), new Address("Krasickiego",
				3, 4, "Zagan", "22-222", "Polska"), new Address("Srednia", 5,
				6, "Zary", "33-333", "Polska"));

		List<Permission> permissions = Arrays.asList(new Permission("delete"),
				new Permission("create"), new Permission("read"));

		Role admin = new Role("admin", Arrays.asList(permissions.get(0),
				permissions.get(1), permissions.get(2)));
		Role user = new Role("user", Arrays.asList(permissions.get(1),
				permissions.get(2)));
		Role guest = new Role("guest", Arrays.asList(permissions.get(2)));

		Person p1 = new Person("Sylwester", "Kowalski",
				Arrays.asList("111111111"), Arrays.asList(addresses.get(0)),
				admin, 23);
		Person p2 = new Person("Kazimierz", "Janczak",
				Arrays.asList("222222222"), Arrays.asList(addresses.get(1)),
				user, 49);
		Person p3 = new Person("Kasia", "Kowal", Arrays.asList("333333333"),
				Arrays.asList(addresses.get(2), addresses.get(1),
						addresses.get(0)), user, 13);
		Person p4 = new Person("Ala", "Falala", Arrays.asList("44444444"),
				Arrays.asList(addresses.get(2), addresses.get(1)), guest, 19);

		List<User> users = Arrays.asList(new User("sylwek123", "haslo", p1),
				new User("kaziu", "haslo2", p2),
				new User("kasia", "haslo3", p3), new User("alunia", "haslo4",
						p4));
		return users;
	}

}
