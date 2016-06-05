package entities;

import java.util.List;

public class Role {

	private String name;
	List<Permission> permissions;

	public Role(String name, List<Permission> permissions) {
		this.name = name;
		this.permissions = permissions;
	}

	public String getName() {
		return name;
	}

	public Role setName(String name) {
		this.name = name;
		return this;
	}

	public List<Permission> getPermissions() {
		return permissions;
	}

	public Role setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
		return this;
	}
}
