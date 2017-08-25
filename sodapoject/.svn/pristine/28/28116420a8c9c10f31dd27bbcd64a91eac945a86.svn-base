package com.soda.service;

import java.util.List;

import com.soda.entity.ConditionInfo;
import com.soda.entity.User;

public interface UserService {

	Integer getTotalPages(ConditionInfo cf);

	List<User> selectUsers(ConditionInfo cf);

	User selectUserById(int id);

	void updateUser(User user);

	void updateState(int id, int num);

	void addUser(User user);

	User selectUserByName(String name);
}

