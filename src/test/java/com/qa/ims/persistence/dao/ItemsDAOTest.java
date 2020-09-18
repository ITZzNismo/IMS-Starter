package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Items;
import com.qa.ims.utils.DBUtils;

public class ItemsDAOTest
{
	private final ItemsDAO DAO = new ItemsDAO();

	@Before
	public void setup() 
	{
		DBUtils.connect("src/test/resources/db.properties");
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}

	@Test
	public void testCreate() 
	{
		final Items created = new Items(3l, "Golf Ball", 3.99f);
		assertEquals(created, DAO.create(created));
	}

	@Test
	public void testReadAll() 
	{
		List<Items> expected = new ArrayList<>();
		expected.add(new Items(1l, "Football", 9.99f));
		expected.add(new Items(2l, "Rugby Ball", 8.99f));
		assertEquals(expected, DAO.readAll());
	}

	@Test
	public void testReadLatest() 
	{
		assertEquals(new Items(2l, "Rugby Ball", 8.99f), DAO.readLatest());
	}

	@Test
	public void testRead() 
	{
		final long productId = 1l;
		assertEquals(new Items(productId, "Football", 9.99f), DAO.readItems(productId));
	}

	@Test
	public void testUpdate() 
	{
		final Items updated = new Items(1l, "Rugby Ball", 8.99f);
		assertEquals(updated, DAO.update(updated));
	}

	@Test
	public void testDelete() 
	{
		assertEquals(1, DAO.delete(1));
	}
}