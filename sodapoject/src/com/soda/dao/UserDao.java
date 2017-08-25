package com.soda.dao;

import java.util.List;

import com.soda.entity.ConditionInfo;
import com.soda.entity.User;

public interface UserDao {


	Integer getTotalPages(ConditionInfo cf);

	List<User> selectUsers(ConditionInfo cf);

	User selectUserById(int id);

	void updateUser(User user);

//	void updateState(int id);

	void deleteUser(int id);

	void addUser(User user);

	User selectUserByName(String name);

	void updateState(int id, int num);

}
