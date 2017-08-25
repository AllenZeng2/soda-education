package com.soda.service.impl;

import java.util.List;

import org.omg.CORBA.Request;

import com.soda.dao.UserDao;
import com.soda.dao.impl.UserDaoImpl;
import com.soda.entity.ConditionInfo;
import com.soda.entity.User;
import com.soda.service.*;

public class UserServiceImpl implements UserService {
	private UserDao ud = new UserDaoImpl();

	@Override
	public Integer getTotalPages(ConditionInfo cf) {
		// TODO Auto-generated method stub
		return ud.getTotalPages(cf);
	}

	@Override
	public List<User> selectUsers(ConditionInfo cf) {
		// TODO Auto-generated method stub
		return ud.selectUsers(cf);
	}

	@Override
	public User selectUserById(int id) {
		// TODO Auto-generated method stub
		return ud.selectUserById(id);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		ud.updateUser(user);
	}

	@Override
	public void updateState(int id, int num) {
		// TODO Auto-generated method stub
		//num=1位修改状态,2表示删除
		if(num==1||num==0){
			ud.updateState(id,num);
		}else if(num==2){
			ud.deleteUser(id);
		}
	}
	
	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		ud.addUser(user);
	}
	@Override
	public User selectUserByName(String name) {
		// TODO Auto-generated method stub
		return ud.selectUserByName(name);
	}
}
