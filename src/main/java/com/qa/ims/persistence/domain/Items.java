package com.qa.ims.persistence.domain;

public class Items 
{
	private Long productId;
	private String name;
	private float price;

	public Items(Long productId, String name, float price) 
	{
		this.setproductId(productId);
		this.setName(name);
		this.setPrice(price);
	}

	public Items(String name, float price) 
	{
		this.setName(name);
		this.setPrice(price);
	}

	public Long getproductId() 
	{
		return productId;
	}

	public void setproductId(Long productId) 
	{
		this.productId = productId;
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
		return "Product ID: " + productId + "\n" + "Product Name: " + name + "\n" + "Price: " + price + "\n";
	}

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((name == null) ? 0 : name.hashCode());
//		result = prime * result + ((id == null) ? 0 : productId.hashCode());
//		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
//		return result;
//	}

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