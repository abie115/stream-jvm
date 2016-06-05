package service;

import entities.Person;
import entities.Role;
import entities.User;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserService implements UserServiceInterface {

	private List<User> users;

	public UserService(List<User> users) {
		this.users = users;
	}

	public List<User> findUsersWithAddressesCountMoreThan(int numberOfAddresses) {
		return users
				.stream()
				.filter(u -> u.getPersonDetails().getAddresses().size() > numberOfAddresses)
				.collect(Collectors.toList());
	}

	public Person findOldestPerson() {
		return users.stream().map(u -> u.getPersonDetails())
				.max((u1, u2) -> Integer.compare(u1.getAge(), u2.getAge()))
				.get();
	}

	public User findUserWithLongestUsername() {
		return users
				.stream()
				.max((u1, u2) -> Integer.compare(u1.getName().length(), u2
						.getName().length())).get();
	}

	public String getNamesAndSurnamesCommaSeparatedOfAllUsersAbove18() {
		return users.stream().map(u -> u.getPersonDetails())
				.filter(u -> u.getAge() > 18)
				.map(u -> u.getName() + " " + u.getSurname())
				.collect(Collectors.joining(", "));
	}

	public List<String> getSortedPermissionsOfUsersWithNameStartingWith(
			String prefix) {
		return users.stream().filter(u -> u.getName().startsWith(prefix))
				.map(u -> u.getPersonDetails().getRole().getPermissions())
				.flatMap(l -> l.stream()).map(p -> p.getName()).sorted()
				.collect(Collectors.toList());
	}

	public double getUsersAverageAge() {
		return users.stream()
				.mapToInt(user -> user.getPersonDetails().getAge()).average()
				.getAsDouble();
	}

	public void printCapitalizedPermissionNamesOfUsersWithSurnameEndingWith(
			String suffix) {
		users.stream().map(u -> u.getPersonDetails())
				.filter(user -> user.getSurname().endsWith(suffix))
				.map(user -> user.getRole().getPermissions())
				.flatMap(l -> l.stream()).map(p -> p.getName().toUpperCase())
				.forEach(System.out::println);
	}

	public Map<Role, List<User>> groupUsersByRole() {
		return users.stream().collect(
				Collectors.groupingBy(u -> u.getPersonDetails().getRole()));
	}

	public Map<Boolean, List<User>> partitionUserByUnderAndOver18() {
		return users.stream()
				.collect(
						Collectors.partitioningBy(u -> u.getPersonDetails()
								.getAge() >= 18));
	}
}
