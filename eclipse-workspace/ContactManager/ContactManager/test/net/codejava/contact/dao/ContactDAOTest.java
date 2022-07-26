package net.codejava.contact.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import net.codejava.contact.model.contact;

class ContactDAOTest {
	private DriverManagerDataSource dataSource;
	private ContactDAO dao;

	@BeforeEach
	void setuBeforeEach() {
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/contactdb");
		dataSource.setUsername("root");
		dataSource.setPassword("em404404em");

		dao = new ContactDAOImpl(dataSource);
	}

	@Test
	void testSave() {
		contact contact = new contact("eman", "ema@gmail.com", "HadayekHelwan", "0111");
		int result = dao.Save(contact);

		assertTrue(result > 0);
	}

	@Test
	void testUpdate() {
		contact contact = new contact(4,"emma", "ema@gmail.com", "HadayekHelwan", "0111");
		int result = dao.update(contact);

		assertTrue(result > 0);
	}

	@Test
	void testGet() {
		Integer id=1;
		contact contact =dao.get(id);
		if (contact !=null) {
			System.out.println(contact);
		}
		
	    assertNotNull(contact);
		
			}

	@Test
	void testDelete() {
		Integer id =2;
		int result =dao.delete(id);
		
		assertTrue(result > 0);
	}

	@Test
	void testList() {
		List<contact> listContacts = dao.list();     
		for (contact con : listContacts) {
			System.out.println(con);
		}
		assertTrue(!listContacts.isEmpty());
	}

}
