package com.soda.service.impl;
import com.soda.dao.ContactDao;
import com.soda.dao.impl.ContactDaoImpl;
import com.soda.entity.Contact;
import com.soda.service.*;

public class ContactServiceImpl implements ContactService{

	private ContactDao cd = new ContactDaoImpl();
	
	@Override
	public Contact getContact() {
		// TODO Auto-generated method stub
		return cd.getContact();
	}

	@Override
	public int updateContent(String phone, String content) {
		// TODO Auto-generated method stub
		return cd.updateContent(phone,content);
	}

	@Override
	public Contact getContact(String phone) {
		// TODO Auto-generated method stub
		return null;
	}

}

