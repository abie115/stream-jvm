package service;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import entities.Person;
import entities.Role;
import entities.User;

public class UserServiceTest {
	private UserService service;
	List<User> exampleUsers;

	@Before
	public void init() {
		exampleUsers = new UserData().getUsers();
		service = new UserService(exampleUsers);
	}

	@Test
	public void findUsersWithAddressesCountMoreThan() {
		List<User> users = service.findUsersWithAddressesCountMoreThan(1);
		assertEquals(2, users.size());
	}

	@Test
	public void findOldestPerson() {
		Person person = service.findOldestPerson();
		Person personExpected = exampleUsers.get(1).getPersonDetails();
		assertEquals(personExpected.getAge(), person.getAge());
	}

	@Test
	public void findUserWithLongestUsername() {
		User user = service.findUserWithLongestUsername();
		User userEqual = exampleUsers.get(0);
		assertEquals(userEqual.getName(), user.getName());
	}

	@Test
	public void getNamesAndSurnamesCommaSeparatedOfAllUsersAbove18() {
		String users = service
				.getNamesAndSurnamesCommaSeparatedOfAllUsersAbove18();
		String usersExpected = exampleUsers.get(0).getPersonDetails().getName()
				+ " " + exampleUsers.get(0).getPersonDetails().getSurname()
				+ ", " + exampleUsers.get(1).getPersonDetails().getName() + " "
				+ exampleUsers.get(1).getPersonDetails().getSurname() + ", "
				+ exampleUsers.get(3).getPersonDetails().getName() + " "
				+ exampleUsers.get(3).getPersonDetails().getSurname();
		assertEquals(usersExpected, users);
	}

	@Test
	public void getSortedPermissionsOfUsersWithNameStartingWith() {
		List<String> perm = service
				.getSortedPermissionsOfUsersWithNameStartingWith("s");
		List<String> permSorted = Arrays.asList("create", "delete", "read");
		assertEquals(permSorted, perm);
	}

	@Test
	public void getUsersAverageAge() {
		double avg = service.getUsersAverageAge();
		double avgExpected = 0;
		for (User u : exampleUsers) {
			avgExpected += u.getPersonDetails().getAge();
		}
		avgExpected /= exampleUsers.size();
		assertEquals(0, avgExpected, avg);
	}

	@Test
	public void printCapitalizedPermissionNamesOfUsersWithSurnameEndingWith() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		service.printCapitalizedPermissionNamesOfUsersWithSurnameEndingWith("a");
		assertFalse(outContent.toString().isEmpty());
	}

	@Test
	public void groupUsersByRole() {
		Map<Role, List<User>> group = service.groupUsersByRole();
		Role role = exampleUsers.get(1).getPersonDetails().getRole();
		Assert.assertEquals(2, group.get(role).size());
	}

	@Test
	public void partitionUserByUnderAndOver18() {
		Map<Boolean, List<User>> part18 = service
				.partitionUserByUnderAndOver18();
		Assert.assertEquals(3, part18.get(true).size());
	}

}
