package com.AshokIT.group.bean;

import java.util.List;

import com.AshokIT.group.model.Product;

public interface IDataFilter {	
	
	public List<Product> filterProducts(List<Product> productsList);

}
