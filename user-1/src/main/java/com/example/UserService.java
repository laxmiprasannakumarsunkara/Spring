package com.example;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

@Service


public class UserService {
	List<User> users = new ArrayList<User>(Arrays.asList(new User(111L, "prasanna", "kumar", "prasanna@gmail.com"),
			new User(222L, "sai", "kumar", "Sai@gmail.com")));

	public User saveData(User user) {

		return users.add(user) ? user : null;
	}

	public List<User> getAllUsers() {

		return users;
	}

	public User getUsers(Long id) {

		return users.stream().filter(t -> t.getId() == id).findFirst().get();
	}

	public User getDetailsBasedOnID(User user) {
		Long Id = user.getId();
		String name = user.getLastName();
		for (User u : users) {
			if (u.getId() == Id && u.getLastName().equals(name)) {
				return u;
			}
		}
		return null;
	}
	public boolean delete(Long id) {
		User u = users.stream().filter(t -> t.getId() == id).findFirst().get();
		return users.remove(u);
	}

	public User updateById(Long id, User user) {
		User u = users.stream().filter(t -> t.getId() == id).findFirst().get();
		u.setId(user.getId());
		u.setFirstName(user.getFirstName());
		u.setLastName(user.getLastName());
		u.setEmail(user.getEmail());
		return u;
	}

	public User partialUpdate(Long id, Map<String, Object> newData) {
		User u = users.stream().filter(t -> t.getId() == id).findFirst().get();
		newData.forEach((key, value) -> {
			Field field = ReflectionUtils.findField(User.class, key);
			field.setAccessible(true);
			ReflectionUtils.setField(field, u, value);
		});
		return u;
	}



}
