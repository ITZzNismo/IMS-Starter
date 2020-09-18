package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrdersDAO;
import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.Utils;

public class OrdersController implements CrudController<Orders>
{
	public static final Logger LOGGER = LogManager.getLogger();

	private OrdersDAO ordersDAO;
	private Utils utils;

	public OrdersController(OrdersDAO ordersDAO, Utils utils) 
	{
		super();
		this.ordersDAO = ordersDAO;
		this.utils = utils;
	}

	/**
	 * Reads all orders to the logger
	 */
	
	@Override
	public List<Orders> readAll() 
	{
		List<Orders> orders = ordersDAO.readAll();
		for (Orders order : orders) 
		{
			LOGGER.info(order.toString());
		}
		return orders;
	}

	/**
	 * Creates an order by taking in user input
	 */
	
	@Override
	public Orders create() 
	{
//		LOGGER.info("Please enter an order ID");
//		Long orderId = utils.getLong();
		LOGGER.info("Please enter your customer ID");
		Long customerId = utils.getLong();
		Orders orders = ordersDAO.create(new Orders(customerId));
		LOGGER.info("order created");
		return orders;
	}

	/**
	 * Updates an existing order by taking in user input
	 */
	
	@Override
	public Orders update() 
	{
		Orders order = null;
		LOGGER.info("Please enter the ID of the order you would like to update");
		Long orderId = utils.getLong();
		LOGGER.info("Would you like to add or remove an item?");
		
		if(utils.getString() == "add")
		{
		LOGGER.info("Please enter the product ID you would like to add to this order");
		Long productId = utils.getLong();
		LOGGER.info("Order Updated");
		order = ordersDAO.addItem(orderId, productId);
		}
		
		else if(utils.getString() == "remove")
		{
			LOGGER.info("Please enter the product ID you would like to remove from this order");
			Long productId = utils.getLong();
			LOGGER.info("Order Updated");		
			order = ordersDAO.deleteItem(orderId, productId);
		}
		return order;
	}

	/**
	 * Deletes an existing order by the id of the order
	 * 
	 * @return
	 */
	
	@Override
	public int delete() 
	{
		LOGGER.info("Please enter the ID of the order you would like to delete");
		Long orderId = utils.getLong();
		return ordersDAO.delete(orderId);
	}
}