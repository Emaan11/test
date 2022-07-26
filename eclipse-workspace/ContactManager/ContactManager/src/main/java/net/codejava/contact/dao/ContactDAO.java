package net.codejava.contact.dao;

import java.util.List;

import net.codejava.contact.model.contact;

public interface ContactDAO {
	public int Save(contact contact);
	public int update(contact contact);
	public contact get(Integer id);
	public int delete(Integer id);
	public List<contact> list();
	

}
