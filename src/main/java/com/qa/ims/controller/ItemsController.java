package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.ItemsDAO;
import com.qa.ims.persistence.domain.Items;
import com.qa.ims.utils.Utils;

public class ItemsController implements CrudController<Items>
{
	/**
	 * Takes in customer details for CRUD functionality
	 *
	 */
		public static final Logger LOGGER = LogManager.getLogger();

		private ItemsDAO itemsDAO;
		private Utils utils;

		public ItemsController(ItemsDAO itemsDAO, Utils utils) 
		{
			super();
			this.itemsDAO = itemsDAO;
			this.utils = utils;
		}

		/**
		 * Reads all customers to the logger
		 */
		@Override
		public List<Items> readAll() 
		{
			List<Items> items = itemsDAO.readAll();
			for (Items item: items) 
			{
				LOGGER.info(item.toString());
			}
			return items;
		}

		/**
		 * Creates a customer by taking in user input
		 */
		@Override
		public Items create() {
			LOGGER.info("Please enter a product name");
			String name = utils.getString();
			LOGGER.info("Please enter a price");
			float price = utils.getFloat();
			Items items = itemsDAO.create(new Items(name, price));
			LOGGER.info("Item created");
			return items;
		}

		/**
		 * Updates an existing customer by taking in user input
		 */
		@Override
		public Items update() {
			LOGGER.info("Please enter the id of the product you would like to update");
			Long productId = utils.getLong();
			LOGGER.info("Please enter a product name");
			String name = utils.getString();
			LOGGER.info("Please enter a price");
			float price = utils.getFloat();
			Items items = itemsDAO.update(new Items(productId, name, price));
			LOGGER.info("Item Updated");
			return items;
		}

		/**
		 * Deletes an existing customer by the id of the customer
		 * 
		 * @return
		 */
		@Override
		public int delete() {
			LOGGER.info("Please enter the id of the product you would like to delete");
			Long productId = utils.getLong();
			return itemsDAO.delete(productId);
		}
	}