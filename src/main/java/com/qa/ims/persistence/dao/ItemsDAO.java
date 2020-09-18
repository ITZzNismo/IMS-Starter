package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Items;
import com.qa.ims.utils.DBUtils;

public class ItemsDAO implements Dao<Items>
{
	public static final Logger LOGGER = LogManager.getLogger();

	@Override
	public Items modelFromResultSet(ResultSet resultSet) throws SQLException 
	{
		Long productId = resultSet.getLong("product_id");
		String name = resultSet.getString("name");
		float price = resultSet.getFloat("price");
		return new Items(productId, name, price);
	}

	/**
	 * Reads all customers from the database
	 * 
	 * @return A list of customers
	 */
	
	@Override
	public List<Items> readAll() 
	{
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * from items");) 
		{
			List<Items> items = new ArrayList<>();
			while (resultSet.next()) 
			{
				items.add(modelFromResultSet(resultSet));
			}
			return items;
		} 
		catch (SQLException e) 
		{
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	public Items readLatest() 
	{
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM items ORDER BY product_id DESC LIMIT 1");) 
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
	 * Creates a customer in the database
	 * 
	 * @param customer - takes in a customer object. id will be ignored
	 */
	
	@Override
	public Items create(Items items) 
	{
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();) 
		{
			statement.executeUpdate("INSERT INTO items (name, price) values('" + items.getName()
					+ "','" + items.getPrice() + "')");
			return readLatest();
		} 
		catch (Exception e) 
		{
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	public Items readItems(Long productId) 
	{
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM items where product_id = " + productId);) 
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
	 * Updates an item in the database
	 * 
	 * @param items - takes in an items object, the id field will be used to
	 *                 update that item in the database
	 * @return
	 */
	
	@Override
	public Items update(Items items) 
	{
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();) 
		{
			statement.executeUpdate("update items set name ='" + items.getName() + "', price ='"
					+ items.getPrice() + "' where product_id =" + items.getProductId());
			return readItems(items.getProductId());
		} 
		catch (Exception e) 
		{
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Deletes a customer in the database
	 * 
	 * @param id - id of the customer
	 */
	
	@Override
	public int delete(long productId) 
	{
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();) 
		{
			return statement.executeUpdate("delete from items where product_id = " + productId);
		} catch (Exception e) 
		{
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}
}