package com.qa.ims.persistence.domain;

public class Items 
{
	private static Long productId;
	private String name;
	private float price;

	public Items(Long productId, String name, float price) 
	{
		this.setProductId(productId);
		this.setName(name);
		this.setPrice(price);
	}

	public Items(String name, float price) 
	{
		this.setName(name);
		this.setPrice(price);
	}

	public static Long getProductId() 
	{
		return productId;
	}

	public void setProductId(Long productId) 
	{
		Items.productId = productId;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public float getPrice() 
	{
		return price;
	}

	public void setPrice(float price) 
	{
		this.price = price;
	}

	@Override
	public String toString()
	{
		return "\n" + "Product ID: " + productId + "\n" + "Product Name: " + name + "\n" + "Price: " + price + "\n";
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Items other = (Items) obj;
		if (getName() == null) 
		{
			if (other.getName() != null)
				return false;
		} 
		else if (!getName().equals(other.getName()))
			return false;
		if (productId == null) 
		{
			if (other.productId != null)
				return false;
		}
		else if (!productId.equals(other.productId))
			return false;
		if (price == 0) 
		{
			if (other.price != 0)
				return false;
		} 
		else if (!(price == other.price))
			return false;
		return true;
	}
}