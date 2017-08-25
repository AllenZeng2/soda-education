package com.soda.dao;

import com.soda.entity.Contact;

public interface ContactDao {

	Contact getContact();

	int updateContent(String phone, String content);



}
