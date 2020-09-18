package com.qa.ims.persistence.domain;

import java.util.ArrayList;
import java.util.List;

public class Orders 
{
	private Long orderId;
	private Long customerId;
	private List<Items> items = new ArrayList<>();
	
	public Orders() 
	{
		super();
	}

	public Orders(Long customerId, List<Items> items) 
	{
		super();
		this.customerId = customerId;
		this.items = items;
	}

	public Orders(Long orderId, Long customerId) 
	{
		super();
		this.orderId = orderId;
		this.customerId = customerId;
	}

	public Orders(Long orderId, Long customerId, List<Items> items) 
	{
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.items = items;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public List<Items> getItems() {
		return items;
	}

	public void setItems(List<Items> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", customerId=" + customerId + ", items=" + items + "]";
	}
}