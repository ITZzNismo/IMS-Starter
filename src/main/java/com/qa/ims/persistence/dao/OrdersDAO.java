package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Items;
import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.DBUtils;

public class OrdersDAO implements Dao<Orders>
{

	public static final Logger LOGGER = LogManager.getLogger();

	@Override
	public Orders modelFromResultSet(ResultSet resultSet) throws SQLException 
	{
		Long orderId = resultSet.getLong("order_id");
		Long customerId = resultSet.getLong("customer_id");
		return new Orders(orderId, customerId);
	}

	/**
	 * Reads all orders from the database
	 * 
	 * @return A list of orders
	 */
	
	@Override
	public List<Orders> readAll() 
	{
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select orders.order_id, order_line.product_id, concat(customers.first_name,\" \", " + "customers.surname) as Customer, "
						+ "items.name, items.price, " + "sum(price) from orders as total, order_line, items, customers where orders.order_id = " 
						+ "order_line.order_id and items.product_id = order_line.product_id and orders.customer_id = customers.id order by orders.order_id, order_line.product_id;");)
		{
			List<Orders> orders = new ArrayList<>();
			while (resultSet.next()) 
			{
				orders.add(modelFromResultSet(resultSet));
			}
			return orders;
		} 
		catch (SQLException e) 
		{
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	public Orders readLatest() 
	{
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders ORDER BY order_id DESC LIMIT 1");) 
		{
			resultSet.next();
			return modelFromResultSet(resultSet);
		} 
		catch (Exception e) 
		{
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Creates an order in the database
	 * 
	 * @param orders - takes in an object. id will be ignored
	 */
	
	@Override
	public Orders create(Orders orders) 
	{
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();) 
		{
			statement.executeUpdate("INSERT INTO orders(order_id, customer_id) values('" + orders.getOrderId()
					+ "','" + orders.getCustomerId() + "')");
			return readLatest();
		} 
		catch (Exception e) 
		{
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	public Orders readOrders(Long orderId) 
	{
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders where order_id = " + orderId);) 
		{
//			ResultSetMetaData rsmd = resultSet.getMetaData();
//			System.out.println(rsmd.getColumnName(1));
			resultSet.next();
			return modelFromResultSet(resultSet);
		} 
		catch (Exception e) 
		{
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Updates an order in the database
	 * 
	 * @param customer - takes in an order object, the id field will be used to
	 *                 update that order in the database
	 * @return
	 */
	
	@Override
	public Orders update(Orders orders) 
	{
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();) 
		{
			statement.executeUpdate("update orders set product_id ='" + Items.getProductId() + "' where order_id =" + orders.getOrderId());
			return readOrders(orders.getOrderId());
		} 
		catch (Exception e) 
		{
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Deletes an order in the database
	 * 
	 * @param id - id of the order
	 */
	
	@Override
	public int delete(long orderId) 
	{
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();) 
		{
			return statement.executeUpdate("DELETE FROM orders where order_id = " + orderId);
		} 
		catch (Exception e) 
		{
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}

	public Orders addItem(Long orderId, Long productId)
	{
		try (Connection connection = DBUtils.getInstance().getConnection(); 
		PreparedStatement statement = connection.prepareStatement("INSERT INTO order_line(order_id, product_id) VALUES (?, ?)")) 
		{ 
			statement.setLong(1, orderId); 
			statement.setLong(2, productId); 
			statement.executeUpdate(); 
		} 
		catch (SQLException e) 
		{ 
			LOGGER.debug(e); 
			LOGGER.error(e.getMessage()); 
		} 
		return readOrders(orderId);
	}
	
	public Orders deleteItem(Long orderId, Long productId)
	{
		try (Connection connection = DBUtils.getInstance().getConnection(); 
		PreparedStatement statement = connection.prepareStatement("DELETE FROM order_line(order_id, product_id) VALUES (?, ?)")) 
		{ 
			statement.setLong(1, orderId); 
			statement.setLong(2, productId); 
			statement.executeUpdate(); 
		} 
		catch (SQLException e) 
		{ 
			LOGGER.debug(e); 
			LOGGER.error(e.getMessage()); 
		} 
		return readOrders(orderId);
	}
}