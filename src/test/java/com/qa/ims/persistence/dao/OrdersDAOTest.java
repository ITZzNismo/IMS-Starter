package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.DBUtils;

public class OrdersDAOTest 
{
	private final OrdersDAO DAO = new OrdersDAO();

	@Before
	public void setup() 
	{
		DBUtils.connect("src/test/resources/db.properties");
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}

	@Test
	public void testCreate() 
	{
		final Orders created = new Orders(2l, 1l);
		assertEquals(created, DAO.create(created));
	}

	@Test
	public void testReadAll() 
	{
		List<Orders> expected = new ArrayList<>();
		expected.add(new Orders(1l, 1l));
		assertEquals(expected, DAO.readAll());
	}

	@Test
	public void testReadLatest() 
	{
		assertEquals(new Orders(1l, 1l), DAO.readLatest());
	}

	@Test
	public void testRead() 
	{
		final long orderId = 1l;
		assertEquals(new Orders(orderId, 1l), DAO.readOrders(orderId));
	}

	@Test
	public void testUpdate() 
	{
		final Orders updated = new Orders(1l, 2l);
		assertEquals(updated, DAO.update(updated));
	}

	@Test
	public void testDelete() 
	{
		assertEquals(1, DAO.delete(1));
	}
}